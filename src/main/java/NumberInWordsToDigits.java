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
        initializeGroundTruthNumberMaps();
    }

    private void initializeGroundTruthNumberMaps() {
        allowedNumbersSum.put("zero", 0);
        allowedNumbersSum.put("one", 1);
        allowedNumbersSum.put("two", 2);
        allowedNumbersSum.put("three", 3);
        allowedNumbersSum.put("four", 4);
        allowedNumbersSum.put("five", 5);
        allowedNumbersSum.put("six", 6);
        allowedNumbersSum.put("seven", 7);
        allowedNumbersSum.put("eight", 8);
        allowedNumbersSum.put("nine", 9);
        allowedNumbersSum.put("ten", 10);
        allowedNumbersSum.put("eleven", 11);
        allowedNumbersSum.put("twelve", 12);
        allowedNumbersSum.put("thirteen", 13);
        allowedNumbersSum.put("fourteen", 14);
        allowedNumbersSum.put("fifteen", 15);
        allowedNumbersSum.put("sixteen", 16);
        allowedNumbersSum.put("seventeen", 17);
        allowedNumbersSum.put("eighteen", 18);
        allowedNumbersSum.put("nineteen", 19);
        allowedNumbersSum.put("twenty", 20);
        allowedNumbersSum.put("thirty", 30);
        allowedNumbersSum.put("fourty", 40);
        allowedNumbersSum.put("forty", 40);
        allowedNumbersSum.put("fifty", 50);
        allowedNumbersSum.put("sixty", 60);
        allowedNumbersSum.put("seventy", 70);
        allowedNumbersSum.put("eighty", 80);
        allowedNumbersSum.put("ninety", 90);
        allowedNumbersSum.put("hundred", 100);
        allowedNumbersProd.put("thousand", 1000);
        allowedNumbersProd.put("million", 1000000);
        allowedNumbersProd.put("billion", 1000000000);
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
