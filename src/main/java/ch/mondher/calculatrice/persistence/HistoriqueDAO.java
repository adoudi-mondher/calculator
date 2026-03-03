package ch.mondher.calculatrice.persistence;

import ch.mondher.calculatrice.ui.Expression;

public interface HistoriqueDAO {
    void sauvegarder(Expression expression,
                     Double resultat,
                     String statut,
                     String message);
}
