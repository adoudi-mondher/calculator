package ch.mondher.calculatrice.app;

import ch.mondher.calculatrice.metier.Calculatrice;
import ch.mondher.calculatrice.metier.Operation;
import ch.mondher.calculatrice.metier.OperationException;
import ch.mondher.calculatrice.metier.OperationFactory;
import ch.mondher.calculatrice.persistence.HistoriqueDAO;
import ch.mondher.calculatrice.ui.Expression;
import ch.mondher.calculatrice.ui.UserInputException;
import ch.mondher.calculatrice.ui.UserInterface;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Application {

    private final UserInterface ui;
    private final Calculatrice calculatrice;
    private final OperationFactory operationFactory;
    private final HistoriqueDAO historiqueDAO;

    public Application(UserInterface ui,
                       Calculatrice calculatrice,
                       OperationFactory operationFactory,
                       HistoriqueDAO historiqueDAO) {

        this.ui = ui;
        this.calculatrice = calculatrice;
        this.operationFactory = operationFactory;
        this.historiqueDAO = historiqueDAO;
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

                Operation operation = operationFactory.getOperation(expr.getSymbole());

                double resultat = calculatrice.executer(operation, expr.getA(), expr.getB());

                double resultatArrondi = BigDecimal
                        .valueOf(resultat)
                        .setScale(2, RoundingMode.HALF_UP)
                        .doubleValue();

                ui.afficherResultat(resultatArrondi);
                historiqueDAO.sauvegarder(expr,
                        resultatArrondi,
                        "SUCCESS",
                        "");
            } catch (UserInputException | OperationException e) {

                ui.afficherErreur(e.getMessage());

                historiqueDAO.sauvegarder(null,
                        null,
                        "ERROR",
                        e.getMessage());
            }
        }
    }
}
