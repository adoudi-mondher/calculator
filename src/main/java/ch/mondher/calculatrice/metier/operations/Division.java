package ch.mondher.calculatrice.metier.operations;

import ch.mondher.calculatrice.metier.Operation;
import ch.mondher.calculatrice.metier.OperationException;

public class Division implements Operation {

    @Override
    public double calculer(double a, double b) throws OperationException {

        if (b == 0) {
            throw new OperationException("Division par zéro interdite !");
        }

        return a / b;
    }
}
