package com.Ashir.PBO.Pertemuan6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiException {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Masukkan bilangan   : ");
            int bilangan1 = input.nextInt();

            System.out.print("Masukkan pembaginya : ");
            int bilangan2 = input.nextInt();

            int hasil = bilangan1/bilangan2;
            System.out.println(bilangan1 + " / " + bilangan2 + " = " + hasil + " (dibulatkan)");
        }
// Multiple Exception
//        catch (ArithmeticException | InputMismatchException e) {
//            System.out.println("Error gess, Tidak dapat di proses :(");
//        }

        catch (ArithmeticException e) {
            System.out.println("Error weh, TIdak bisa diproses!");
        }

        catch (InputMismatchException e) {
            System.out.println("Masukkan angka saja yooo :)");
        }

        System.out.println("Proses sudah selesai yoo :)");
    }
}
