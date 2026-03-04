package ch.mondher.calculatrice;

import ch.mondher.calculatrice.app.Application;
import ch.mondher.calculatrice.metier.Calculatrice;
import ch.mondher.calculatrice.metier.OperationFactory;
import ch.mondher.calculatrice.persistence.CsvHistoriqueDAO;
import ch.mondher.calculatrice.persistence.HistoriqueDAO;
import ch.mondher.calculatrice.ui.ConsoleUI;
import ch.mondher.calculatrice.ui.UserInterface;

public class Main {
    public static void main(String[] args) {

        // Création de l'interface utilisateur (console)
        UserInterface ui = new ConsoleUI();
        // Création de la calculatrice (service métier)
        Calculatrice calculatrice = new Calculatrice();
        // Fabriquer une opération avec Factory
        OperationFactory factory = new OperationFactory();
        // Suvegarder les opérations dans historique.csv
        HistoriqueDAO dao = new CsvHistoriqueDAO("historique.csv");
        // Création de l'application (orchestrateur)
        Application app = new Application(ui, calculatrice, factory, dao);
        // Démarrage de l'application
        app.demarrer();
    }
}