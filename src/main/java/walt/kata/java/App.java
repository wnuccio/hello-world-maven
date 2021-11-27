package walt.kata.java;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class App {

    public static void main(String[] args) {
        String inputFile = args.length > 0 ? args[0] : "input.json";
        System.out.printf("Reading from %s: %n", inputFile);
        readInputFileAndPrintToOutput(inputFile);

    }

    private static void readInputFileAndPrintToOutput(String inputFile) {
//        String read = new Gson().fromJson("value", String.class);
        Input input = readInput(inputFile);
        String output = new GsonBuilder().setPrettyPrinting().create().toJson(input);
        System.out.printf("Input:%n %s%n", output);
    }

    private static Input readInput(String inputFile) {
        try {
            JsonReader jsonReader = new JsonReader(new FileReader(inputFile));
            return new Gson().fromJson(jsonReader, Input.class);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
