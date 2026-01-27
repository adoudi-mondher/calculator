package ch.mondher.calculatrice.metier.operations;

import ch.mondher.calculatrice.metier.Operation;
import ch.mondher.calculatrice.metier.OperationException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SoustractionTest {

    @Test
    public void calculer_3_moins_2_retourne_1() throws OperationException {

        Operation soustraction = new Soustraction();

        double resultat = soustraction.calculer(3, 2);

        assertEquals(1.0, resultat, 0.0001);
    }
}
