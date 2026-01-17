package ch.mondher.calculatrice.metier;

public interface Operation {
    double calculer(double a,  double b) throws OperationException;
}
