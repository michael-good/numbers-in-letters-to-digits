
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    private String text;
    private NumberInWordsToDigits converter;
    private InputParser parser;

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
        this.parseTextAndGetNumbersFromIt();

        List<String> numbers = this.getParser().getNumbers();
        List<Integer> results = new ArrayList<Integer>();
        List<String> tempNumbers = new ArrayList<String>();
        List<Integer> firstIndexNumber = new ArrayList<Integer>();
        List<Integer> lastIndexNumber = new ArrayList<Integer>();

        String[] tokenizedText = this.getParser().getTokenizedText();
        for(String number: numbers) {
            if(!number.equalsIgnoreCase("separator")) {
                tempNumbers.add(number);
            } else {
                results.add(this.getConverter().convertWordNumbersToDigits(tempNumbers));
                firstIndexNumber.add(this.getText().indexOf(tempNumbers.get(0)));
                lastIndexNumber.add(this.getText().lastIndexOf(tempNumbers.get(tempNumbers.size()-1)) +
                        tempNumbers.get(tempNumbers.size()-1).length());
                tempNumbers.clear();
            }
        }

        for(int i = firstIndexNumber.size(); i > 0; i--) {
            int startIndex = firstIndexNumber.get(i - 1);
            int endIndex = lastIndexNumber.get(i-1);
            String replacement = Integer.toString(results.get(i-1));
            String toBeReplaced = this.getText().substring(startIndex, endIndex);
            this.setText(this.getText().replace(toBeReplaced, replacement));

        }
        System.out.println(this.getText());
    }

    public void getUserInput() {
        System.out.println("Enter a phrase or text: ");
        Scanner scanner = new Scanner(System.in);
        this.text = scanner.nextLine();
    }

    public void parseTextAndGetNumbersFromIt() throws Exception {
        this.parser.parseText(this.text);
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




