package clases;

import java.util.Scanner;
import org.nfunk.jep.ParseException;

public class ClaseMain {

    public static void main(String[] args) throws ParseException {

        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese la funcion:");
        String f = input.nextLine();
        System.out.println("Ingrese el valor inicial:");
        String x = input.nextLine();
        System.out.println("Ingrese el numero de iteraciones:");
        String i = input.nextLine();

        MetodoNewtonRaphson metodoNewtonRaphson = new MetodoNewtonRaphson(f, Integer.parseInt(i), Double.parseDouble(x));
        metodoNewtonRaphson.evaluarMetodoNewtonRaphson();
    }
}
