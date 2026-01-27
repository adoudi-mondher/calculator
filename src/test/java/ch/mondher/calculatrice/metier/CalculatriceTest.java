package ch.mondher.calculatrice.metier;

import ch.mondher.calculatrice.metier.operations.Addition;
import ch.mondher.calculatrice.metier.operations.Division;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatriceTest {

    Calculatrice calculatrice = new Calculatrice();

    @Test
    public void executer_addition_2_plus_3_retourne_5() throws OperationException {

        Operation addition = new Addition();

        double resultatAddition = calculatrice.executer(addition, 2, 3);

        assertEquals(5.0, resultatAddition, 0.0001);
    }

    @Test(expected = OperationException.class)
    public void executer_division_par_zero_propage_operationexception() throws OperationException {

        Operation division = new Division();

        calculatrice.executer(division, 10, 0);

        // Pas d'Assert : si l'exception est levée, le test passe
    }
}
