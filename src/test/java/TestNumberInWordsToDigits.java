import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class TestNumberInWordsToDigits extends TestCase {

    private NumberInWordsToDigits converter;

    public TestNumberInWordsToDigits(String str) {
        super(str);
        converter = new NumberInWordsToDigits();
    }

    @Test
    public void valueInvalidShouldNotBeValid() throws Exception {
        ArrayList<String> numbers = new ArrayList<String>();

        numbers.add("minus");

        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            converter.convertWordNumbersToDigits(numbers);
        });

        assertTrue(thrown.getMessage().contains("Input number out of range!"));
    }

    @Test
    public void valueEqualToZeroShouldBeValidAnswer() throws Exception {
        ArrayList<String> numbers = new ArrayList<String>();

        numbers.add("zero");

        Assertions.assertEquals(converter.convertWordNumbersToDigits(numbers), 0);
    }

    @Test
    public void valueMinorThanTenAsInputShouldBeValidAnswer() throws Exception {
        ArrayList<String> numbers = new ArrayList<String>();

        numbers.add("five");

        Assertions.assertEquals(converter.convertWordNumbersToDigits(numbers), 5);
    }

    @Test
    public void valueBetweenTenAndOneHundredAsInputShouldBeValidAnswer() throws Exception {
        ArrayList<String> numbers = new ArrayList<String>();

        numbers.add("eighty");

        Assertions.assertEquals(converter.convertWordNumbersToDigits(numbers), 80);
    }

    @Test
    public void valueBetweenTenAndOneHundredWithDashAsInputShouldBeValidAnswer() throws Exception {
        ArrayList<String> numbers = new ArrayList<String>();

        numbers.add("twenty");
        numbers.add("four");

        Assertions.assertEquals(converter.convertWordNumbersToDigits(numbers), 24);
    }

    @Test
    public void valueOfOneThousandInputShouldBeValidAnswer() throws Exception {
        ArrayList<String> numbers = new ArrayList<String>();

        numbers.add("one");
        numbers.add("thousand");

        Assertions.assertEquals(converter.convertWordNumbersToDigits(numbers), 1000);
    }

    @Test
    public void valueBetweenOneHundredAndAThousandAsInputShouldBeValidAnswer() throws Exception {
        ArrayList<String> numbers = new ArrayList<String>();

        numbers.add("one");
        numbers.add("hundred");
        numbers.add("forty");
        numbers.add("three");

        Assertions.assertEquals(converter.convertWordNumbersToDigits(numbers), 143);
    }

    @Test
    public void valueBetweenOneThousandAndOneMillionAsInputShouldBeValidAnswer() throws Exception {
        ArrayList<String> numbers = new ArrayList<String>();

        numbers.add("fifteen");
        numbers.add("thousand");
        numbers.add("three");
        numbers.add("hundred");
        numbers.add("ninety");
        numbers.add("one");

        Assertions.assertEquals(converter.convertWordNumbersToDigits(numbers), 15391);
    }

    @Test
    public void valueEqualToUpperLimitShouldBeValid() throws Exception {
        ArrayList<String> numbers = new ArrayList<String>();

        numbers.add("nine");
        numbers.add("quintillion");
        numbers.add("two");
        numbers.add("hundred");
        numbers.add("twenty");
        numbers.add("three");
        numbers.add("quadrillion");
        numbers.add("three");
        numbers.add("hundred");
        numbers.add("seventy");
        numbers.add("two");
        numbers.add("trillion");
        numbers.add("thirty");
        numbers.add("six");
        numbers.add("billion");
        numbers.add("eight");
        numbers.add("hundred");
        numbers.add("fifty");
        numbers.add("four");
        numbers.add("million");
        numbers.add("seven");
        numbers.add("hundred");
        numbers.add("seventy");
        numbers.add("five");
        numbers.add("thousand");
        numbers.add("eight");
        numbers.add("hundred");
        numbers.add("seven");

        Assertions.assertEquals(converter.convertWordNumbersToDigits(numbers), 9223372036854775807L);
    }

    @Test
    public void valueGreaterThanEUpperLimitShouldNotBeValid() throws Exception {
        ArrayList<String> numbers = new ArrayList<String>();

        numbers.add("nine");
        numbers.add("quintillion");
        numbers.add("two");
        numbers.add("hundred");
        numbers.add("twenty");
        numbers.add("three");
        numbers.add("quadrillion");
        numbers.add("three");
        numbers.add("hundred");
        numbers.add("seventy");
        numbers.add("two");
        numbers.add("trillion");
        numbers.add("thirty");
        numbers.add("six");
        numbers.add("billion");
        numbers.add("eight");
        numbers.add("hundred");
        numbers.add("fifty");
        numbers.add("four");
        numbers.add("million");
        numbers.add("seven");
        numbers.add("hundred");
        numbers.add("seventy");
        numbers.add("five");
        numbers.add("thousand");
        numbers.add("eight");
        numbers.add("hundred");
        numbers.add("eight");

        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            converter.convertWordNumbersToDigits(numbers);
        });

        assertTrue(thrown.getMessage().contains("Input number out of range!"));
    }

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new TestNumberInWordsToDigits("valueInvalidShouldNotBeValid"));
        suite.addTest(new TestNumberInWordsToDigits("valueEqualToZeroShouldBeValidAnswer"));
        suite.addTest(new TestNumberInWordsToDigits("valueMinorThanTenAsInputShouldBeValidAnswer"));
        suite.addTest(new TestNumberInWordsToDigits("valueBetweenTenAndOneHundredAsInputShouldBeValidAnswer"));
        suite.addTest(new TestNumberInWordsToDigits("valueBetweenTenAndOneHundredWithDashAsInputShouldBeValidAnswer"));
        suite.addTest(new TestNumberInWordsToDigits("valueOfOneThousandInputShouldBeValidAnswer"));
        suite.addTest(new TestNumberInWordsToDigits("valueBetweenOneHundredAndAThousandAsInputShouldBeValidAnswer"));
        suite.addTest(new TestNumberInWordsToDigits("valueBetweenOneThousandAndOneMillionAsInputShouldBeValidAnswer"));
        suite.addTest(new TestNumberInWordsToDigits("valueEqualToUpperLimitShouldBeValid"));
        suite.addTest(new TestNumberInWordsToDigits("valueGreaterThanEUpperLimitShouldNotBeValid"));

        return suite;
    }
}
