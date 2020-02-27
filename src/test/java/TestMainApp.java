import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestMainApp extends TestCase {

    private MainApp app;

    public TestMainApp(String str) {
        super(str);
        this.app = new MainApp();
    }

    @Test
    public void checkIfZeroIsProperlyTransformed() throws Exception {
        String testString = "zero";
        ByteArrayInputStream testIn = new ByteArrayInputStream(testString.getBytes());
        System.setIn(testIn);

        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        this.app.main(new String[0]);

        Assertions.assertEquals("Enter a phrase or text: \n0\n", testOut.toString());
    }

    @Test
    public void checkIfUpperLimitIsProperlyTransformed() throws Exception {
        String testString = "nine quintillion two hundred twenty-three quadrillion " +
                "three hundred seventy-two trillion thirty-six billion eight hundred " +
                "fifty-four million seven hundred seventy-five thousand eight hundred seven";
        ByteArrayInputStream testIn = new ByteArrayInputStream(testString.getBytes());
        System.setIn(testIn);

        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        this.app.main(new String[0]);

        Assertions.assertEquals("Enter a phrase or text: \n9223372036854775807\n", testOut.toString());
    }

    @Test
    public void checkIfTestInputWithAndIsProperlyTransformed() throws Exception {
        String testString = "One hundred and one";
        ByteArrayInputStream testIn = new ByteArrayInputStream(testString.getBytes());
        System.setIn(testIn);

        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        this.app.main(new String[0]);

        Assertions.assertEquals("Enter a phrase or text: \n101\n", testOut.toString());
    }

    @Test
    public void checkIfSimpleSentenceIsProperlyTransformed() throws Exception {
        String testString = "I have one hundred apples";
        ByteArrayInputStream testIn = new ByteArrayInputStream(testString.getBytes());
        System.setIn(testIn);

        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        this.app.main(new String[0]);

        Assertions.assertEquals("Enter a phrase or text: \nI have 100 apples\n", testOut.toString());
    }

    @Test
    public void checkIfSentenceWithMultipleNumbersIsProperlyTransformed() throws Exception {
        String testString = "I thirty, James forty-four! One thousand years and twenty-two springs!";
        ByteArrayInputStream testIn = new ByteArrayInputStream(testString.getBytes());
        System.setIn(testIn);

        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        this.app.main(new String[0]);

        Assertions.assertEquals("Enter a phrase or text: \nI 30, James 44! 1000 years and 22 springs!\n",
                testOut.toString());
    }

    @Test
    public void sentenceWithNoNumbersShouldOutputSameSentence() throws Exception {
        String testString = "My name is Miguel Ángel";
        ByteArrayInputStream testIn = new ByteArrayInputStream(testString.getBytes());
        System.setIn(testIn);

        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        this.app.main(new String[0]);

        Assertions.assertEquals("Enter a phrase or text: \nMy name is Miguel Ángel\n",
                testOut.toString());
    }

    @Test
    public void invalidNullInputShouldRaiseException() throws Exception {
        String testString = "\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(testString.getBytes());
        System.setIn(testIn);

        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        this.app.main(new String[0]);;

        Assertions.assertEquals("Enter a phrase or text: \nInvalid input string!\n",
                testOut.toString());
    }

    @Test
    public void inputNumberOutOfBoundsShouldRaiseExceptionOutOfRange() throws Exception {
        String testString = "nine quintillion two hundred twenty-three quadrillion " +
                "three hundred seventy-two trillion thirty-six billion eight hundred " +
                "fifty-four million seven hundred seventy-five thousand eight hundred eight";
        ByteArrayInputStream testIn = new ByteArrayInputStream(testString.getBytes());
        System.setIn(testIn);

        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        this.app.main(new String[0]);;

        Assertions.assertEquals("Enter a phrase or text: \nInput number out of range!\n",
                testOut.toString());
    }

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new TestMainApp("checkIfZeroIsProperlyTransformed"));
        suite.addTest(new TestMainApp("checkIfUpperLimitIsProperlyTransformed"));
        suite.addTest(new TestMainApp("checkIfTestInputWithAndIsProperlyTransformed"));
        suite.addTest(new TestMainApp("checkIfSentenceWithMultipleNumbersIsProperlyTransformed"));
        suite.addTest(new TestMainApp("checkIfSentenceWithMultipleNumbersIsProperlyTransformed"));
        suite.addTest(new TestMainApp("sentenceWithNoNumbersShouldOutputSameSentence"));
        suite.addTest(new TestMainApp("invalidNullInputShouldRaiseException"));
        suite.addTest(new TestMainApp("inputNumberOutOfBoundsShouldRaiseExceptionOutOfRange"));

        return suite;
    }
}
