package ch.mondher.calculatrice.ui;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleUI implements UserInterface {

    private final Scanner scanner = new Scanner(System.in);

    // Regex : "2 + 3", "2+3", "-2.5 * 4", "-2,5 * 4", "10 / -2"
    private static final Pattern EXPRESSION_PATTERN =
            Pattern.compile(
                    "^\\s*([-+]?(?:\\d+(?:[\\.,]\\d+)?))\\s*(\\S)\\s*([-+]?(?:\\d+(?:[\\.,]\\d+)?))\\s*$"
            );

    @Override
    public Expression lireExpression() {
        String ligne = scanner.nextLine();

        if (ligne.equalsIgnoreCase("q") || ligne.equalsIgnoreCase("exit")) {
            return null; // signal de sortie
        }

        Matcher matcher = EXPRESSION_PATTERN.matcher(ligne);

        if (!matcher.matches()) {
            throw new UserInputException(
                    "Format invalide. Exemple attendu : 2 + 3, 2+3, -2.5 * 4, -2,5 * 4, 10 / -2"
            );
        }

        // Récupère les éléments sous forme texte
        String aTexte = matcher.group(1).replace(',', '.');
        String symbole = matcher.group(2);
        String bTexte = matcher.group(3).replace(',', '.');

        if (!symbole.matches("[+\\-*/]")) {
            throw new UserInputException("Opération inconnue : " + symbole + " (utilisez +, -, * ou /)");
        }

        double a = Double.parseDouble(aTexte);
        double b = Double.parseDouble(bTexte);

        return new Expression(a, symbole, b);
    }

    @Override
    public void afficherMessage(String message){
        System.out.println(message);
    }

    @Override
    public void afficherResultat(double resultat){
        System.out.println("Résultat : " + resultat);
    }

    @Override
    public void afficherErreur(String message){
        System.out.println("Erreur : " + message);
    }

}
