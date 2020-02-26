import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberInWordsToDigits {

    private String text;
    private List<String> numbers;
    private HashMap<String, Integer> allowedNumbersSum;
    private HashMap<String, Integer> allowedNumbersProd;

    public NumberInWordsToDigits() {
        this.numbers = new ArrayList<String>();
        this.allowedNumbersSum = new HashMap<String, Integer>();
        this.allowedNumbersProd = new HashMap<String, Integer>();
        this.initializeGroundTruthNumberMaps();
    }

    private void initializeGroundTruthNumberMaps() {
        this.allowedNumbersSum.put("zero", 0);
        this.allowedNumbersSum.put("one", 1);
        this.allowedNumbersSum.put("two", 2);
        this.allowedNumbersSum.put("three", 3);
        this.allowedNumbersSum.put("four", 4);
        this.allowedNumbersSum.put("five", 5);
        this.allowedNumbersSum.put("six", 6);
        this.allowedNumbersSum.put("seven", 7);
        this.allowedNumbersSum.put("eight", 8);
        this.allowedNumbersSum.put("nine", 9);
        this.allowedNumbersSum.put("ten", 10);
        this.allowedNumbersSum.put("eleven", 11);
        this.allowedNumbersSum.put("twelve", 12);
        this.allowedNumbersSum.put("thirteen", 13);
        this.allowedNumbersSum.put("fourteen", 14);
        this.allowedNumbersSum.put("fifteen", 15);
        this.allowedNumbersSum.put("sixteen", 16);
        this.allowedNumbersSum.put("seventeen", 17);
        this.allowedNumbersSum.put("eighteen", 18);
        this.allowedNumbersSum.put("nineteen", 19);
        this.allowedNumbersSum.put("twenty", 20);
        this.allowedNumbersSum.put("thirty", 30);
        this.allowedNumbersSum.put("fourty", 40);
        this.allowedNumbersSum.put("forty", 40);
        this.allowedNumbersSum.put("fifty", 50);
        this.allowedNumbersSum.put("sixty", 60);
        this.allowedNumbersSum.put("seventy", 70);
        this.allowedNumbersSum.put("eighty", 80);
        this.allowedNumbersSum.put("ninety", 90);
        this.allowedNumbersSum.put("hundred", 100);
        this.allowedNumbersProd.put("thousand", 1000);
        this.allowedNumbersProd.put("million", 1000000);
        this.allowedNumbersProd.put("billion", 1000000000);
    }

    public HashMap<String, Integer> getAllowedNumbersSum() {
        return this.allowedNumbersSum;
    }

    public HashMap<String, Integer> getAllowedNumbersProd() {
        return this.allowedNumbersProd;
    }

    public int convertWordNumbersToDigits(List<String> numbers) throws Exception {
        int result = 0, finalResult = 0;
        for (String number : numbers) {
            if (allowedNumbersSum.containsKey(number.toLowerCase())) {
                if (number.equalsIgnoreCase("hundred")) {
                    result *= allowedNumbersSum.get(number.toLowerCase());
                } else {
                    result += allowedNumbersSum.get(number.toLowerCase());
                }
            } else if (allowedNumbersProd.containsKey(number.toLowerCase())) {
                result *= allowedNumbersProd.get(number.toLowerCase());
                finalResult += result;
                result = 0;
            } else {
                throw new Exception("Input number out of range!");
            }
        }
        finalResult += result;
        if (isValidOutput(finalResult)) {
            return finalResult;
        } else {
            throw new Exception("Input number out of range!");
        }
    }

    static boolean isValidOutput(int finalResult) {
        return (finalResult >= 0 && finalResult <= Integer.MAX_VALUE);
    }
}
