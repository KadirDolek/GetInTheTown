@echo off
:: Compilation
if not exist bin mkdir bin
javac -d bin src\*.java

:: Exécution
java -cp bin Main
pause