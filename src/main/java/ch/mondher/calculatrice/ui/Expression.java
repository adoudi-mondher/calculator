package ch.mondher.calculatrice.ui;

public class Expression {

    private final double a;
    private final String symbole;
    private final double b;

    public Expression(double a, String symbole, double b) {
        this.a = a;
        this.symbole = symbole;
        this.b = b;
    }

    public double getA() { return a; }
    public String getSymbole() { return symbole; }
    public double getB() { return b; }
}
