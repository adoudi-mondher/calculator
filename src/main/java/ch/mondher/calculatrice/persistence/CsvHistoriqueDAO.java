package ch.mondher.calculatrice.persistence;

import ch.mondher.calculatrice.ui.Expression;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CsvHistoriqueDAO implements HistoriqueDAO {

    private final String cheminFichier;
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public CsvHistoriqueDAO(String cheminFichier) {
        this.cheminFichier = cheminFichier;
    }

    @Override
    public void sauvegarder(Expression expression,
                            Double resultat,
                            String statut,
                            String message) {

        try (FileWriter writer = new FileWriter(cheminFichier, true)) {

            String timestamp = LocalDateTime.now().format(FORMATTER);

            String a = (expression != null) ? String.valueOf(expression.getA()) : "";
            String symbole = (expression != null) ? expression.getSymbole() : "";
            String b = (expression != null) ? String.valueOf(expression.getB()) : "";
            String res = (resultat != null) ? String.valueOf(resultat) : "";

            writer.append(timestamp).append(";")
                    .append(a).append(";")
                    .append(symbole).append(";")
                    .append(b).append(";")
                    .append(res).append(";")
                    .append(statut).append(";")
                    .append(message)
                    .append("\n");

        } catch (IOException e) {
            System.err.println("Erreur écriture historique : " + e.getMessage());
        }
    }
}
