package ch.mondher.calculatrice.ui;

import java.util.Scanner;

public class ConsoleUI implements UserInterface {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void afficherMessage(String message){
        System.out.println(message);
    }

    @Override
    public String lireChoixOperation(){
        String symbole = scanner.next();
        return symbole;
    }

    @Override
    public double lireNombre(){
        try {
            return scanner.nextDouble();
        } catch (Exception e) {
            scanner.next();
            throw new UserInputException("Veuillez saisir un nombre !");
        }
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
