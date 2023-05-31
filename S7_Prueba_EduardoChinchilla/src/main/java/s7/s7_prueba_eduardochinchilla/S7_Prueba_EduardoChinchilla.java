package s7.s7_prueba_eduardochinchilla;

import java.util.Scanner;

public class S7_Prueba_EduardoChinchilla {

    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        char resp = 's';
        while (resp == 's' || resp == 'S') {
            System.out.println("Ingrese una cadena: ");
            String s = read.next().toLowerCase();

            while (esCorrecta(s) == false) {
                System.out.println("Error, vuelva a ingresar una cadena");
                s = read.next();
            }
            System.out.println("Ingrese limite");
            int lim = read.nextInt();

            int sumfin = (suma(s));

            if (sumfin % 2 == 0) {
                System.out.println(sumfin + " " + "par desarrolla serie");
                System.out.println(sucesion(sumfin, lim));
                System.out.println(" ");
            } else if (sumfin % 2 == 1) {
                System.out.println(sumfin +" " + "impar desarrolla formula");
                imprimir(formula(sumfin, lim));
                System.out.println(" ");
            }
            System.out.println("Desea continuar con el programa s/n");
            resp = read.next().charAt(0);
            if (resp == 'n' || resp == 'N') {
                System.out.println("Ha salido del programa");
            }
        }
    }

    public static boolean esCorrecta(String s) {
        boolean let = false;
        boolean numeros = false;

        for (int i = 0; i < s.length(); i++) {
            char letra = s.charAt(i);
            if (letra >= 97 && letra <= 122) {
                let = true;

            } else if (letra >= 48 && letra <= 58) {
                numeros = true;

            } else {
                let = false;
                numeros = false;
            }

        }
        return let && numeros;
    }

    public static int suma(String s) {
        int sumafinal = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char letra = s.charAt(i);
            if (Character.isDigit(letra)) {
                int num = Character.getNumericValue(letra);
                sumafinal += num;
            }
        }

        return sumafinal;
    }

    public static double[] formula(int num, int lim) {
        double sumafinal = 0.0;
        
        double[] temp = new double[lim + 1];
        for (int i = 0; i < lim; i++) {

            double parte1 = Math.pow((double) (i + num), (double) (i));
            double parte2 = (i + 1);
            double suma = parte1 / parte2;

            sumafinal += suma;
            temp[i] = suma;       
            temp[temp.length - 1] = sumafinal;

        }
        return temp;

    }

    public static String sucesion(int sumfin, int lim) {
        String acum = " ";
        for (int i = 1; i <= lim; i++) {
            acum += sumfin * i + " , ";
        }
        return acum;
    }

    public static void imprimir(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("[" + array[i] + "]" + " ");
        }
    }
}
