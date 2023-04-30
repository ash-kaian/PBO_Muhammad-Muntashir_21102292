package com.Ashir.PBO.Pertemuan2.Tugas;

import java.util.Scanner;

public class Unguided1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukkan username : ");
        String username = input.nextLine();

        System.out.println("Masukkan password : ");
        String password = input.nextLine();

        if (username.equals("Ashir") && password.equals("123")) {
            System.out.println("Login berhasil silahkan masuk");
        } else if (username.equals("Ashir") || password.equals("123")) {
            System.out.println("Silahkan login dengan username dan password yang sah!");
        } else {
            System.out.println("Username dan password Anda salah");
        }
    }
}
