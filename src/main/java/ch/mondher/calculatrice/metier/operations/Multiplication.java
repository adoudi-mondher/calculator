package ch.mondher.calculatrice.metier.operations;

import ch.mondher.calculatrice.metier.Operation;

public class Multiplication implements Operation {

    @Override
    public double calculer(double a, double b) {
        return a * b;
    }
}
