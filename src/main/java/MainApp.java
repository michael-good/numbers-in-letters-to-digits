
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    private String text;
    private NumberInWordsToDigits converter;
    private InputParser parser;
    List<String> numbers;
    List<Integer> results;
    List<String> tempNumbers;
    List<Integer> firstIndexNumber;
    List<Integer> lastIndexNumber;

    public MainApp() {
        this.converter = new NumberInWordsToDigits();
        this.parser = new InputParser(converter);
    }

    public static void main(String[] args) throws Exception {
        MainApp app = new MainApp();
        app.execute();
    }

    public void execute() throws Exception {
        this.getUserInput();
        try {
            this.parseTextAndGetNumbersFromIt();
            this.initializeNeededVariablesForConversionOperation();
            this.convertAllNumbersInWordsFromTextToDigitsAndGetTheirLocationInText();
            this.replaceNumbersInWordsInTextByDigits();
            this.printResult();
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void getUserInput() {
        System.out.println("Enter a phrase or text: ");
        Scanner scanner = new Scanner(System.in);
        this.text = scanner.nextLine();
    }

    private void parseTextAndGetNumbersFromIt() throws Exception {
        this.parser.parseText(this.text);
    }

    private void initializeNeededVariablesForConversionOperation() {
        this.numbers = this.parser.getNumbers();
        this.results = new ArrayList<Integer>();
        this.tempNumbers = new ArrayList<String>();
        this.firstIndexNumber = new ArrayList<Integer>();
        this.lastIndexNumber = new ArrayList<Integer>();
    }

    private void convertAllNumbersInWordsFromTextToDigitsAndGetTheirLocationInText() throws Exception {
        for (String number : this.numbers) {
            if (!number.equalsIgnoreCase("separator")) {
                this.tempNumbers.add(number);
            } else {
                this.results.add(this.getConverter().convertWordNumbersToDigits(this.tempNumbers));
                this.firstIndexNumber.add(this.getText().indexOf(this.tempNumbers.get(0)));
                this.lastIndexNumber.add(this.getText().lastIndexOf(this.tempNumbers.get(this.tempNumbers.size() - 1)) +
                        this.tempNumbers.get(this.tempNumbers.size() - 1).length());
                this.tempNumbers.clear();
            }
        }
    }

    private void replaceNumbersInWordsInTextByDigits() {
        for (int i = this.firstIndexNumber.size(); i > 0; i--) {
            int startIndex = this.firstIndexNumber.get(i - 1);
            int endIndex = this.lastIndexNumber.get(i - 1);
            String replacement = Integer.toString(this.results.get(i - 1));
            String toBeReplaced = this.getText().substring(startIndex, endIndex);
            this.setText(this.getText().replace(toBeReplaced, replacement));
        }
    }

    private void printResult() {
        System.out.println(this.getText());
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public InputParser getParser() {
        return this.parser;
    }

    public NumberInWordsToDigits getConverter() {
        return this.converter;
    }
}




