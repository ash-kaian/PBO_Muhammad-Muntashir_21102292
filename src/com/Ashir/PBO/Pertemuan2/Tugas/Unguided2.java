package com.Ashir.PBO.Pertemuan2.Tugas;

import java.util.Scanner;

public class Unguided2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukkan nama Anda : ");
        String username = input.nextLine();

        System.out.println("Gaji yang diterima oleh " + username + " adalah sebagai berikut");

        System.out.println("Gaji      = ");
        double gaji = input.nextDouble();

        System.out.println("Tunjangan = ");
        double tunjangan = input.nextDouble();

        System.out.println("Gaji      = " + gaji);
        System.out.println("Tunjangan = " + tunjangan);
        System.out.println("Pajak     = 7.65%");

        double pajak = 0.0765;
        double Gaji_kotor = gaji + tunjangan;
        double Pajak_negara = Gaji_kotor * pajak;
        double Gaji_bersih = Gaji_kotor - Pajak_negara;

        System.out.println("Total gaji bersih dari " + username + " yang diterima yaitu " + Gaji_bersih);
    }
}
