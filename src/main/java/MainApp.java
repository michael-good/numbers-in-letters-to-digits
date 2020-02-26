
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public String text;

    public MainApp() {

    }

    public void getUserInput() {
        System.out.println("Enter a phrase or text: ");
        Scanner scanner = new Scanner(System.in);
        this.text = scanner.nextLine();
    }

    public void parseTextAndGetNumbersFromIt() throws Exception {
        NumberInWordsToDigits converter = new NumberInWordsToDigits();
        InputParser parser = new InputParser(converter);
        parser.parseText(this.text);
    }

    public static void main(String[] args) throws Exception {

        MainApp app = new MainApp();
        app.getUserInput();

        NumberInWordsToDigits conversor = new NumberInWordsToDigits();
        InputParser parser = new InputParser(conversor);
        parser.parseText(app.text);

        List<Integer> results = new ArrayList<Integer>();
        List<String> numbers = parser.getNumbers();
        List<String> tempNumbers = new ArrayList<String>();
        List<Integer> firstIndexNumber = new ArrayList<Integer>();
        List<Integer> lastIndexNumber = new ArrayList<Integer>();

        String[] tokenizedText = parser.getTokenizedText();
        for(String number: numbers) {
            if(!number.equalsIgnoreCase("separator")) {
                tempNumbers.add(number);
            } else {
                results.add(conversor.convertWordNumbersToDigits(tempNumbers));
                firstIndexNumber.add(app.text.indexOf(tempNumbers.get(0)));
                lastIndexNumber.add(app.text.lastIndexOf(tempNumbers.get(tempNumbers.size()-1)) +
                        tempNumbers.get(tempNumbers.size()-1).length());
                tempNumbers.clear();
            }
        }

        for(int i = firstIndexNumber.size(); i > 0; i--) {
            int startIndex = firstIndexNumber.get(i - 1);
            int endIndex = lastIndexNumber.get(i-1);
            String replacement = Integer.toString(results.get(i-1));
            String toBeReplaced = app.text.substring(startIndex, endIndex);
            app.text = app.text.replace(toBeReplaced, replacement);

        }
        System.out.println(app.text);
    }
}




