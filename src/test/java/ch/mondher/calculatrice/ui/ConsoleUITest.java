package ch.mondher.calculatrice.ui;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class ConsoleUITest {

    @Test
    public void lireExpression_valide_retourne_expression() {

        // Arrange
        Scanner scanner = new Scanner("2 + 3\n");
        ConsoleUI ui = new ConsoleUI(scanner);

        // Act
        Expression expression = ui.lireExpression();

        // Assert
        Assert.assertEquals(2.0, expression.getA(), 0.001);
        Assert.assertEquals("+", expression.getSymbole());
        Assert.assertEquals(3.0, expression.getB(), 0.001);
    }

    @Test(expected = UserInputException.class)
    public void lireExpression_format_invalide_leve_exception() {

        // Arrange
        Scanner scanner = new Scanner("5 5\n");
        ConsoleUI ui = new ConsoleUI(scanner);

        // Act
        ui.lireExpression(); // doit lever UserInputException
    }

    @Test(expected = UserInputException.class)
    public void lireExpression_operateur_inconnu_leve_exception() {

        // Arrange
        Scanner scanner = new Scanner("5 % 5\n");
        ConsoleUI ui = new ConsoleUI(scanner);

        // Act
        ui.lireExpression(); // doit lever UserInputException
    }
}