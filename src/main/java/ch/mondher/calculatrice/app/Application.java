package ch.mondher.calculatrice.app;

import ch.mondher.calculatrice.metier.Calculatrice;
import ch.mondher.calculatrice.metier.Operation;
import ch.mondher.calculatrice.metier.OperationException;
import ch.mondher.calculatrice.metier.operations.Addition;
import ch.mondher.calculatrice.metier.operations.Division;
import ch.mondher.calculatrice.metier.operations.Multiplication;
import ch.mondher.calculatrice.metier.operations.Soustraction;
import ch.mondher.calculatrice.ui.UserInputException;
import ch.mondher.calculatrice.ui.UserInterface;

public class Application {

    private final UserInterface ui;
    private final Calculatrice calculatrice;

    public Application(UserInterface ui, Calculatrice calculatrice) {
        this.ui = ui;
        this.calculatrice = calculatrice;
    }

    public void demarrer() {
        Operation operation = null;
        double a = 0;
        double b = 0;

        while (operation == null) {
            try {
                ui.afficherMessage("Entrez une opération (+, -, *, /) :");
                String symbole = ui.lireChoixOperation();
                // Crée l'opération correspondant au symbole
                operation = creerOperation(symbole);
            } catch (OperationException e) {
                ui.afficherErreur(e.getMessage());
            }
        }

        while (true) {
            try {
                ui.afficherMessage("Entrez le premier nombre :");
                a = ui.lireNombre();
                break;
            } catch (UserInputException e) {
                ui.afficherErreur(e.getMessage());
            }
        }

        while (true) {
            try {
                ui.afficherMessage("Entrez le second nombre :");
                b = ui.lireNombre();
                break;
            } catch (UserInputException e) {
                ui.afficherErreur(e.getMessage());
            }
        }

        try {
            // Exécute le calcul via la calculatrice
            double resultat = calculatrice.executer(operation, a, b);
            // Affiche le résultat
            ui.afficherResultat(resultat);
        } catch (OperationException e) {
            ui.afficherErreur(e.getMessage());
        }
    }

    private Operation creerOperation(String symbole) throws OperationException {
        if (!symbole.matches("[+*/-]")) {
            throw new OperationException("Opération inconnue : " + symbole);
        }
        symbole = symbole.trim();
        switch (symbole) {
            case "+": return new Addition();
            case "-": return new Soustraction();
            case "*": return new Multiplication();
            case "/": return new Division();
            default :  throw new OperationException("Opération inconnue : " + symbole);
        }
    }
}
