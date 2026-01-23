package ch.mondher.calculatrice.ui;

public interface UserInterface {

    void afficherMessage(String message);
    Expression lireExpression();
    void afficherResultat(double resultat);
    void afficherErreur(String message);

}
