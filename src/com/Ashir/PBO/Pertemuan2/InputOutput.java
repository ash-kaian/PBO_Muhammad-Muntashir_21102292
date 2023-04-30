package com.Ashir.PBO.Pertemuan2;

import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukkan nama Anda : ");
        String nama = input.nextLine();

        System.out.println("Selamat pagi " + nama + "!");
    }
}
