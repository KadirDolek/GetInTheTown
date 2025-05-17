#!/bin/bash

# Compilation
mkdir -p bin
javac -d bin src/*.java

# Exécution
java -cp bin Main