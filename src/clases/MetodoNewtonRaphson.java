package clases;

import org.nfunk.jep.ParseException;

public class MetodoNewtonRaphson {

    private String funcion;
    private int iteraciones;
    private double x;
    private EvaluarFuncion evaluador;

    public MetodoNewtonRaphson(String funcion, int iteraciones, double x) {
        this.funcion = funcion;
        this.iteraciones = iteraciones;
        this.x = x;
        evaluador = new EvaluarFuncion();
        evaluador.setFuncion(funcion);
    }

    public int getIteraciones() {
        return iteraciones;
    }

    public void setIteraciones(int iteraciones) {
        this.iteraciones = iteraciones;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public EvaluarFuncion getEvaluador() {
        return evaluador;
    }

    public void setEvaluador(EvaluarFuncion evaluador) {
        this.evaluador = evaluador;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public double iteracionSiguiente(double x) {
        return x - evaluador.evaluarFuncion(x) / evaluador.evaluarFuncionDerivada(x);
    }

    public void evaluarMetodoNewtonRaphson() throws ParseException {

        evaluador.derivarFuncion();

        System.out.println("Numero de iteraciones: " + this.iteraciones + "\n"
                + "Valor inicial: " + this.x + "\n"
                + "Funcion dada: " + this.funcion);

        System.out.println("i = 0  || x0 = " + x
                + " || f(x0) = " + String.format("%.5f", this.evaluador.evaluarFuncion(x))
                + " || f'(x0) = " + String.format("%.5f", this.evaluador.evaluarFuncionDerivada(x))
                + " || |xi - xi-1| = *****");

        for (int i = 1; i <= iteraciones; i++) {
            x = iteracionSiguiente(x);
            System.out.println("i = " + i
                    + " || x" + i + " = " + String.format("%.5f", x)
                    + " || f(x" + i + ") = " + String.format("%.5f", this.evaluador.evaluarFuncion(x))
                    + " || f'(x" + i + ") = " + String.format("%.5f", this.evaluador.evaluarFuncionDerivada(x))
                    + " || |xi - xi-1| = " + String.format("%.5f", Math.abs(iteracionSiguiente(x) - x)));
        }

    }

}
