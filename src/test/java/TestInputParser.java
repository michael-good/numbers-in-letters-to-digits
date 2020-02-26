import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class TestInputParser extends TestCase {


    private InputParser parser;

    public TestInputParser(String str) {
        super(str);
        NumberInWordsToDigits converter = new NumberInWordsToDigits();
        parser = new InputParser(converter);
    }


    @Test
    public void checkIfZeroIsProperlyProcessed() throws Exception {
        String text = "zero";
        ArrayList<String> numbers = new ArrayList<String>();

        parser.parseText(text);
        numbers.add("zero");
        numbers.add("separator");

        Assertions.assertEquals(parser.getNumbers(), numbers);
    }

    @Test
    public void checkIfNumbersAreProperlyExtractedFromText() throws Exception {
        String text = "There are three numbers in this text: one, two";
        ArrayList<String> numbers = new ArrayList<String>();

        parser.parseText(text);
        numbers.add("three");
        numbers.add("separator");
        numbers.add("one");
        numbers.add("separator");
        numbers.add("two");
        numbers.add("separator");

        Assertions.assertEquals(parser.getNumbers(), numbers);
    }

    @Test
    public void checkIfSingleNumberIsProperlyStored() throws Exception {
        String text = "five";
        ArrayList<String> numbers = new ArrayList<String>();

        parser.parseText(text);
        numbers.add("five");
        numbers.add("separator");

        Assertions.assertEquals(parser.getNumbers(), numbers);
    }

    @Test
    public void checkIfSingleDashedNumberIsProperlyStored() throws Exception {
        String text = "Twenty-nine";
        ArrayList<String> numbers = new ArrayList<String>();

        parser.parseText(text);
        numbers.add("Twenty");
        numbers.add("nine");
        numbers.add("separator");

        Assertions.assertEquals(parser.getNumbers(), numbers);
    }

    @Test
    public void valueEqualToUpperLimitShouldBeStoredProperly() throws Exception {
        String text = "two billion one hundred forty seven million " +
                "four hundred eighty three thousand six hundred forty seven";
        ArrayList<String> numbers = new ArrayList<String>();

        parser.parseText(text);
        numbers.add("two");
        numbers.add("billion");
        numbers.add("one");
        numbers.add("hundred");
        numbers.add("forty");
        numbers.add("seven");
        numbers.add("million");
        numbers.add("four");
        numbers.add("hundred");
        numbers.add("eighty");
        numbers.add("three");
        numbers.add("thousand");
        numbers.add("six");
        numbers.add("hundred");
        numbers.add("forty");
        numbers.add("seven");
        numbers.add("separator");

        Assertions.assertEquals(parser.getNumbers(), numbers);
    }

    @Test
    public void nullTextStringShouldNotBeAccepted() throws Exception {
        String text = null;
        ArrayList<String> numbers = new ArrayList<String>();

        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            parser.parseText(text);
        });

        assertTrue(thrown.getMessage().contains("Invalid input string!"));
    }

    @Test
    public void emptyStringShouldNotBeAccepted() throws Exception {
        String text = "";
        ArrayList<String> numbers = new ArrayList<String>();

        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            parser.parseText(text);
        });

        assertTrue(thrown.getMessage().contains("Invalid input string!"));
    }

    @Test
    public void sentenceStartingWithNumberShouldRetrieveSuchNumber() throws Exception {
        String text = "Forty-six years old";
        ArrayList<String> numbers = new ArrayList<String>();

        parser.parseText(text);
        numbers.add("Forty");
        numbers.add("six");
        numbers.add("separator");

        Assertions.assertEquals(parser.getNumbers(), numbers);
    }

    @Test
    public void numbersWithAndInTheMiddleShouldBeRecognizedAndTheAndIgnored() throws Exception {
        String text = "I have one hundred and four dollars";
        ArrayList<String> numbers = new ArrayList<String>();

        parser.parseText(text);
        numbers.add("one");
        numbers.add("hundred");
        numbers.add("four");
        numbers.add("separator");

        Assertions.assertEquals(parser.getNumbers(), numbers);
    }

    @Test
    public void numbersAtTheEndShouldBeProperlyStored() throws Exception {
        String text = "I am fifty-three";
        ArrayList<String> numbers = new ArrayList<String>();

        parser.parseText(text);
        numbers.add("fifty");
        numbers.add("three");
        numbers.add("separator");

        Assertions.assertEquals(parser.getNumbers(), numbers);
    }

    @Test
    public void specialCharactersShouldNotAffectDetectedNumbers() throws Exception {
        String text = "Fifteen years old I am! Wanna live until eighty!";
        ArrayList<String> numbers = new ArrayList<String>();

        parser.parseText(text);
        numbers.add("Fifteen");
        numbers.add("separator");
        numbers.add("eighty");
        numbers.add("separator");

        Assertions.assertEquals(parser.getNumbers(), numbers);
    }

    @Test
    public void sentencesMustBeProperlyTokenized() throws Exception {
        String text = "Thirty, soldiers again! Hello? One hundred.";
        String[] tokens = new String[9];

        parser.parseText(text);
        tokens[0] = "Thirty";
        tokens[1] = "";
        tokens[2] = "soldiers";
        tokens[3] = "again";
        tokens[4] = "";
        tokens[5] = "Hello";
        tokens[6] = "";
        tokens[7] = "One";
        tokens[8] = "hundred";

        Assertions.assertArrayEquals(parser.getTokenizedText(), tokens);
    }


    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new TestInputParser("checkIfZeroIsProperlyProcessed"));
        suite.addTest(new TestInputParser("checkIfNumbersAreProperlyExtractedFromText"));
        suite.addTest(new TestInputParser("checkIfSingleNumberIsProperlyStored"));
        suite.addTest(new TestInputParser("checkIfSingleDashedNumberIsProperlyStored"));
        suite.addTest(new TestInputParser("valueEqualToUpperLimitShouldBeStoredProperly"));
        suite.addTest(new TestInputParser("nullTextStringShouldNotBeAccepted"));
        suite.addTest(new TestInputParser("emptyStringShouldNotBeAccepted"));
        suite.addTest(new TestInputParser("sentenceStartingWithNumberShouldRetrieveSuchNumber"));
        suite.addTest(new TestInputParser("numbersWithAndInTheMiddleShouldBeRecognizedAndTheAndIgnored"));
        suite.addTest(new TestInputParser("numbersAtTheEndShouldBeProperlyStored"));
        suite.addTest(new TestInputParser("specialCharactersShouldNotAffectDetectedNumbers"));
        suite.addTest(new TestInputParser("sentencesMustBeProperlyTokenized"));

        return suite;
    }
}
