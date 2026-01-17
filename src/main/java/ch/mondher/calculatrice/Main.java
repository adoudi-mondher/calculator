package ch.mondher.calculatrice;

import ch.mondher.calculatrice.app.Application;
import ch.mondher.calculatrice.metier.Calculatrice;
import ch.mondher.calculatrice.ui.ConsoleUI;
import ch.mondher.calculatrice.ui.UserInterface;

public class Main {
    public static void main(String[] args) {

        // Création de l'interface utilisateur (console)
        UserInterface ui = new ConsoleUI();
        // Création de la calculatrice (service métier)
        Calculatrice calculatrice = new Calculatrice();
        // Création de l'application (orchestrateur)
        Application application = new Application(ui, calculatrice);
        // Démarrage de l'application
        application.demarrer();

    }
}