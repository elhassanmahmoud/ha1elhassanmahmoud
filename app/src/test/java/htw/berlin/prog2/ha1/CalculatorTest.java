package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //TODO hier weitere Tests erstellen
    @Test
    @DisplayName ("soll den Bildschirm auf 0 zurücksetzen, wenn die Clear-Taste = 0 gedrückt wird")
    void testClearScreen() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);//1 eingeben
        calc.pressDigitKey(6);//6 eingeben und dann clear taste drücken
        calc.pressClearKey();// clear taste drücken

        String expected = "0";// ergebnis ist 0
        String actual = calc.readScreen(); //commit 1 -

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName ("soll 'Error' anzeigen, wenn ein negativer Wert durch Null geteilt wird")
    void testNegativeDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);// 9 eingeben
        calc.pressNegativeKey(); // -9 eingeben
        calc.pressBinaryOperationKey("/");// geteilt eingeben
        calc.pressDigitKey(0); // geteilt 0 eingeben
        calc.pressEqualsKey(); // ergebnis berechnen = error

        String expected = "Error"; //zeigt error an
        String actual = calc.readScreen(); //commit 2 - 1/2 -

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName ("soll 'Error' ausgeben, wenn der Kehrwert von 0 ermittelt wird")
    void testInverseWithoutValue() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(0); // 0 eingeben
        calc.pressUnaryOperationKey("1/x"); // 1/x taste drücken = 1 durch 0 ist nicht definiert

        String expected = "Error"; // zeigt error an
        String actual = calc.readScreen(); //commit 2 - 2/2 p

        assertEquals(expected, actual);
    }

}