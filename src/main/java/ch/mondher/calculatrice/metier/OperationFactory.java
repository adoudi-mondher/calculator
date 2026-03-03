package ch.mondher.calculatrice.metier;

import ch.mondher.calculatrice.metier.operations.Addition;
import ch.mondher.calculatrice.metier.operations.Division;
import ch.mondher.calculatrice.metier.operations.Multiplication;
import ch.mondher.calculatrice.metier.operations.Soustraction;

import java.util.HashMap;
import java.util.Map;

public class OperationFactory {

    private final Map<String, Operation> operations = new HashMap<>();

    public OperationFactory() {
        operations.put("+", new Addition());
        operations.put("-", new Soustraction());
        operations.put("*", new Multiplication());
        operations.put("/", new Division());
    }

    public Operation getOperation(String symbole) throws OperationException {
        symbole = symbole.trim();
        Operation operation = operations.get(symbole);

        if (operation == null) {
            throw new OperationException("Opération inconnue : " + symbole);
        }

        return operation;
    }
}