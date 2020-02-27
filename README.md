# numbers-in-letters-to-digits

## Summary

This program converts written numbers in words to digits in the middle of a paragraph. 
For instance:
  - If the input is ‘one hundred and one’, the output should be ‘101’
  - If the input is ‘I have one hundred apples’ the output should be ‘I have 100 apples’
  
Test cases have been written so that 100% coverage is achieved. Binaries (JAR) for the execution of the program can be found within bin/ folder.

## Assumptions

1. Only quantities i.e. positive numbers are converted.
2. There can be more than one number in a sentence/paragraph.
3. Maximum value of numbers is 9,223,372,036,854,775,807 (64-bit variable limit).

## Requirements

- JavaSE 8 (Java 1.8)

## How to run in Linux

Open up a terminal console and type in:

```console
foo@bar:~$ cd ~
```
```console
foo@bar:~$ git clone https://github.com/michael-good/numbers-in-letters-to-digits.git
```
```console
foo@bar:~$ cd numbers-in-letters-to-digits/bin/
```
```console
foo@bar:~$ java -jar verbio-1.0-SNAPSHOT.jar
```

## How to run in Windows

1. Git clone or download .zip file from GitHub at desired location.
2. Extract such file and navigate to numbers-in-letters-to-digits\bin\
3. Open a cmd command line.
4. Type in the following and press Enter: java -jar verbio-1.0-SNAPSHOT.jar

# Code explanation

## MainApp class

