import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberInWordsToDigits {

    private String text;
    private List<String> numbers;
    private HashMap<String, Long> allowedNumbersSum;
    private HashMap<String, Long> allowedNumbersProd;

    public NumberInWordsToDigits() {
        this.numbers = new ArrayList<String>();
        this.allowedNumbersSum = new HashMap<String, Long>();
        this.allowedNumbersProd = new HashMap<String, Long>();
        this.initializeGroundTruthNumberMaps();
    }

    private void initializeGroundTruthNumberMaps() {
        this.allowedNumbersSum.put("zero", 0L);
        this.allowedNumbersSum.put("one", 1L);
        this.allowedNumbersSum.put("two", 2L);
        this.allowedNumbersSum.put("three", 3L);
        this.allowedNumbersSum.put("four", 4L);
        this.allowedNumbersSum.put("five", 5L);
        this.allowedNumbersSum.put("six", 6L);
        this.allowedNumbersSum.put("seven", 7L);
        this.allowedNumbersSum.put("eight", 8L);
        this.allowedNumbersSum.put("nine", 9L);
        this.allowedNumbersSum.put("ten", 10L);
        this.allowedNumbersSum.put("eleven", 11L);
        this.allowedNumbersSum.put("twelve", 12L);
        this.allowedNumbersSum.put("thirteen", 13L);
        this.allowedNumbersSum.put("fourteen", 14L);
        this.allowedNumbersSum.put("fifteen", 15L);
        this.allowedNumbersSum.put("sixteen", 16L);
        this.allowedNumbersSum.put("seventeen", 17L);
        this.allowedNumbersSum.put("eighteen", 18L);
        this.allowedNumbersSum.put("nineteen", 19L);
        this.allowedNumbersSum.put("twenty", 20L);
        this.allowedNumbersSum.put("thirty", 30L);
        this.allowedNumbersSum.put("fourty", 40L);
        this.allowedNumbersSum.put("forty", 40L);
        this.allowedNumbersSum.put("fifty", 50L);
        this.allowedNumbersSum.put("sixty", 60L);
        this.allowedNumbersSum.put("seventy", 70L);
        this.allowedNumbersSum.put("eighty", 80L);
        this.allowedNumbersSum.put("ninety", 90L);
        this.allowedNumbersSum.put("hundred", 100L);
        this.allowedNumbersProd.put("thousand", 1000L);
        this.allowedNumbersProd.put("million", 1000000L);
        this.allowedNumbersProd.put("billion", 1000000000L);
        this.allowedNumbersProd.put("trillion", 1000000000000L);
        this.allowedNumbersProd.put("quadrillion", 1000000000000000L);
        this.allowedNumbersProd.put("quintillion", 1000000000000000000L);
    }

    public HashMap<String, Long> getAllowedNumbersSum() {
        return this.allowedNumbersSum;
    }

    public HashMap<String, Long> getAllowedNumbersProd() {
        return this.allowedNumbersProd;
    }

    public long convertWordNumbersToDigits(List<String> numbers) throws Exception {
        long result = 0, finalResult = 0;
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

    private boolean isValidOutput(long finalResult) {
        return (finalResult >= 0 && finalResult <= Long.MAX_VALUE);
    }
}
