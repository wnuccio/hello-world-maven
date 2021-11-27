#!/bin/bash
cd $(dirname "${BASH_SOURCE[0]}")/..
java -jar ./target/hello-world-maven-1.0-SNAPSHOT-jar-with-dependencies.jar $1
