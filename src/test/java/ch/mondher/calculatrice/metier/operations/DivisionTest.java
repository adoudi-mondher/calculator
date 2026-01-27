package ch.mondher.calculatrice.metier.operations;

import ch.mondher.calculatrice.metier.Operation;
import ch.mondher.calculatrice.metier.OperationException;
import org.junit.Test;

public class DivisionTest {

    @Test(expected = OperationException.class)
    public void division_par_zero_leve_une_exception() throws OperationException {

        Operation division = new Division();

        division.calculer(10, 0);

        // Pas d'Assert : si l'exception est levée, le test passe
    }
}
