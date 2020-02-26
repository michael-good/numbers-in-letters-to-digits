import java.util.ArrayList;
import java.util.List;

public class InputParser {

    private NumberInWordsToDigits converter;
    private List<String> numbers;
    private String[] tokenizedText;
    private String text;

    public InputParser(NumberInWordsToDigits converter) {
        this.converter = converter;
        this.numbers = new ArrayList<String>();
    }

    public void parseText(String text) throws Exception {
        this.text = text;
        if (!isValidInput())
            throw new Exception("Invalid input string!");
        tokenizeText();
        getNumberWordsFromText();
    }

    private boolean isValidInput() {
        return (this.text != null && this.text.length() > 0);
    }

    private void tokenizeText() {
        this.text = this.text.replaceAll("[^a-zA-Z0-9]", " ");
        this.tokenizedText = text.split(" ");
    }

    private void getNumberWordsFromText() {
        int index = 0;
        for (String token : this.tokenizedText) {
            if (isTokenANumber(token)) {
                this.numbers.add(token);
            } else {
                if (isSeparatorNeededBecauseOfEndOfNumber(index)) {
                    this.numbers.add("separator");
                }
            }
            index++;
        }
        if (!isThereSeparatorAtTheEndAlready())
            this.numbers.add("separator");
    }

    private boolean isTokenANumber(String token) {
        return (converter.getAllowedNumbersSum().containsKey(token.toLowerCase()) ||
                converter.getAllowedNumbersProd().containsKey(token.toLowerCase()));
    }

    private boolean isSeparatorNeededBecauseOfEndOfNumber(int index) {
        return (index > 0 && !this.numbers.isEmpty() &&
                tokenizedText[index - 1].equalsIgnoreCase(this.numbers.get(this.numbers.size() - 1)) &&
                !tokenizedText[index].equalsIgnoreCase("and"));
    }

    private boolean isThereSeparatorAtTheEndAlready() {
        return this.numbers.get(this.numbers.size() - 1).equalsIgnoreCase("separator");
    }

    public List<String> getNumbers() {
        return this.numbers;
    }

    public String[] getTokenizedText() {
        return this.tokenizedText;
    }
}
