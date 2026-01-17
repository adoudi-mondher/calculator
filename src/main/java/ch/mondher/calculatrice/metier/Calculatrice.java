package ch.mondher.calculatrice.metier;

public class Calculatrice {

    public double executer(Operation op, double a, double b) throws OperationException {

        return op.calculer(a, b);
    }
}
