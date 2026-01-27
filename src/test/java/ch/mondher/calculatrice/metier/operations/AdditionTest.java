package ch.mondher.calculatrice.metier.operations;

import ch.mondher.calculatrice.metier.Operation;
import static org.junit.Assert.assertEquals;

import ch.mondher.calculatrice.metier.OperationException;
import org.junit.Test;

public class AdditionTest {

    @Test
    public void calculer_2_plus_3_retourne_5() throws OperationException {

        Operation addition = new Addition();

        double resultat = addition.calculer(2, 3);

        assertEquals(5.0, resultat, 0.0001);
    }
}
