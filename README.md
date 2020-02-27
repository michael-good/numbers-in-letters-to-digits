# numbers-in-letters-to-digits

## Summary

This program converts written numbers in words to digits in the middle of a paragraph. 
For instance:
  - If the input is ‘one hundred and one’, the output should be ‘101’
  - If the input is ‘I have one hundred apples’ the output should be ‘I have 100 apples’
  
Test cases have been written so that 100% coverage is achieved. Binaries (JAR) for the execution of the program can be found within bin/ folder.
Project has been compiled, built and tested using Gradle.

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

In the main method, a new application object is created. It then launches the program by calling execute(). This method gets a paragraph from user by means of Scanner. 
Input text is parsed by InputParser, where tokenized text and numbers are extracted and stored into Lists. Such numbers in letters are then converted to digits.
The idea is that when analyzing the sequences, InputParser looks for numbers and stores them sequentally. If there are separated numbers, a separator mark is appended at the array to indicate that there are more than one number stored. That way, convertAllNumbersInWordsFromTextToDigitsAndGetTheirLocationInText() in MainApp receives the whole array and only converts data in between separation marks separately. As a result, a vector with different digits is obtained and stored within "results" list. Positions of the beginning and end of the numbers in their letter form within original input text are also hold. This positions are used in replaceNumbersInWordsInTextByDigits() to replace all numbers in letters in the original text by their digit form by means of replace() and substring(). 
When this last operation is completed, converted text is shown to the user.

## InputParser class

This class needs a NumberInWordsToDigits object to be initialized and has parseText(String text) as its more important method. parseText(String text) receives the input of the user and extracts the numbers in letters from it. In order to do so, it first validates that the input is correct and valid, otherwise and exception is raised. It then tokenizes the text by deleting all special characters and splitting the paragraph by its blank spaces. This tokenized text is analyzed in getNumberWordsFromText(), where numbers are extracted from words. 
NumberInWordsToDigits objects have two maps that play the role of ground truth to determine whether a word represents a number or not. In getNumberWordsFromText() each token of the previously tokenized text is compared to the keys of the aforementioned maps. If the word is indeed a key, it is stored within the "numbers" array. If not, a separator mark is placed right after the last number stored. Last if statement takes care of texts that only contain a single number without any other word of any kind e.g. "twenty".
Numbers and tokenized text are stored in variables of the class that can be accessed by other objects by means of getters and setters.

## NumberInWordsToDigits class

In initializeGroundTruthNumberMaps(), which is called from the constructor, the aforementioned maps that serve the ground truth purpose are initialized manually. There are two maps: allowedNumbersSum and allowedNumbersProd. The first one stores numbers from 0 to 100 and the former only 1000, 1000000 and 1000000000. Moreover, a list of numbers to store the results of the conversion is needed aswell. 
Method convertWordNumbersToDigits(List<String> numbers) is the one to call from outside. Given a sequence of numbers written in letters it retrieves the same sequence converted to digits. In order to do so, a small algorithm is programmed: for each number of the sequence, the program looks if it belongs to allowedNumbersSum or allowedNumbersProd. If it belongs to the first one, the value of the number is added to "result", which is an accumulative variable. If it belongs to allowedNumbersProd, the previous result is multiplied by the corresponding value (1000, 1000000 or 1000000000) and the result added to "finalResult", another accumulative variable. "result" is then cleared. There is a special case: a value of 100 involves multiplying the previous result by 100 but does not add anything to "finalResult" nor clears "result".
Once numbers are processed one by one with the algorithm explained previously, the final result is validated i.e. its value is between 0 and the maximum possible value (64 bits --> 9,223,372,036,854,775,807).
