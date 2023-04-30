package com.Ashir.PBO.Pertemuan2;

public class Break {
    public static void main(String[] args) {
        int p = 1; // jika p = 0 maka break pada if akan berjalan tetapi jika p = 1 maka break pada if tidak akan berjalan karena kondisi if p == 50
        while (p <= 100) {
            System.out.println("Looping... ("+p+")");
            p += 10;

            if (p == 50) {
                System.out.println("Udahlah bro! Makasih");
                break;
            }
        }
    }
}
