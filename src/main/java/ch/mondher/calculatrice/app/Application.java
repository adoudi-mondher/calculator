package ch.mondher.calculatrice.app;

import ch.mondher.calculatrice.metier.Calculatrice;
import ch.mondher.calculatrice.metier.Operation;
import ch.mondher.calculatrice.metier.OperationException;
import ch.mondher.calculatrice.metier.operations.Addition;
import ch.mondher.calculatrice.metier.operations.Division;
import ch.mondher.calculatrice.metier.operations.Multiplication;
import ch.mondher.calculatrice.metier.operations.Soustraction;
import ch.mondher.calculatrice.ui.Expression;
import ch.mondher.calculatrice.ui.UserInputException;
import ch.mondher.calculatrice.ui.UserInterface;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Application {

    private final UserInterface ui;
    private final Calculatrice calculatrice;

    public Application(UserInterface ui, Calculatrice calculatrice) {
        this.ui = ui;
        this.calculatrice = calculatrice;
    }

    public void demarrer() {
        while (true) {
            try {
                ui.afficherMessage("Entrez une expression (ex: 2 + 3, 2+3, -2.5 * 4, -2,5 * 4, 10 / -2 ou q pour quitter :");
                Expression expr = ui.lireExpression();
                // Signal de sortie
                if (expr == null) {
                    ui.afficherMessage("Fin du programme.");
                    return; // sortie propre
                }
                Operation operation = creerOperation(expr.getSymbole());
                double resultat = calculatrice.executer(operation, expr.getA(), expr.getB());

                double resultatArrondi = BigDecimal
                        .valueOf(resultat)
                        .setScale(2, RoundingMode.HALF_UP)
                        .doubleValue();

                ui.afficherResultat(resultatArrondi);
                ui.afficherResultat(resultat);
            } catch (UserInputException | OperationException e) { ui.afficherErreur(e.getMessage()); }
        }
    }

    private Operation creerOperation(String symbole) throws OperationException {
        symbole = symbole.trim();
        switch (symbole) {
            case "+": return new Addition();
            case "-": return new Soustraction();
            case "*": return new Multiplication();
            case "/": return new Division();
            default : throw new OperationException("Opération inconnue : " + symbole);
        }
    }
}
