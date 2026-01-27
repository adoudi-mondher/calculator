package ch.mondher.calculatrice.metier.operations;

import ch.mondher.calculatrice.metier.Operation;
import ch.mondher.calculatrice.metier.OperationException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultiplicationTest {

    @Test
    public void calculer_2_fois_3_retourne_6() throws OperationException {

        Operation multiplication = new Multiplication();

        double resultat = multiplication.calculer(2, 3);

        assertEquals(6.0, resultat, 0.0001);
    }
}
