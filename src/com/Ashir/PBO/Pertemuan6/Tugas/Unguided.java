package com.Ashir.PBO.Pertemuan6.Tugas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Unguided {
    public static double BagiBilangan(int bilangan1, int bilangan2) {
        return (double) bilangan1/bilangan2;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Masukkan bilangan pertama : ");
            int bilangan1 = input.nextInt();

            System.out.print("Masukkan bilangan kedua   : ");
            int bilangan2 = input.nextInt();

            double hasil = BagiBilangan(bilangan1, bilangan2);
            System.out.println(bilangan1 + " / " + bilangan2 + " = " + hasil);
        }

        catch (ArithmeticException e) {
            System.out.println("Terjadi kesalahan: Pembagian dengan nol tidak diperbolehkan.");
        }

        catch (InputMismatchException e) {
            System.out.println("Terjadi kesalahan: Input tidak valid. Harap masukkan bilangan bulat.");
        }
    }
}
