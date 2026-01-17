package ch.mondher.calculatrice.ui;

public interface UserInterface {

    void afficherMessage(String message);
    String lireChoixOperation();
    double lireNombre();
    void afficherResultat(double resultat);
    void afficherErreur(String message);

}
