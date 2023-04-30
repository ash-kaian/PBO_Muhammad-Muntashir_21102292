package com.Ashir.PBO.Pertemuan3;

public class Main {
    public static void main(String[] args) {
        // Pembuatan class
        SepedaMotor honda = new SepedaMotor("Honda", "Vario 160", 35000000);
        SepedaMotor yamaha = new SepedaMotor("Yamaha", "N Max", 40000000);
        SepedaMotor vespa = new SepedaMotor("Vespa", "Vespa Matic", 60000000);

        /*
        // Digunakan untuk constructor tanpa parameter
        // Mengisi nilai attribute object Honda
        honda.merk = "Honda";
        honda.tipe = "Vario 160";
        honda.harga = 35000000;

        // Mengisi nilai attribute object Yamaha
        yamaha.merk = "Yamaha";
        yamaha.tipe = "N Max";
        yamaha.harga = 40000000;

        // Mengisi nilai attribute object Vespa
        vespa.merk = "Vespa";
        vespa.tipe = "Vespa Matic";
        vespa.harga = 60000000;

        // Untuk menjalankan method
        honda.showInfo();
        yamaha.showInfo();
        vespa.showInfo();
         */

        // Uji coba getter and setter
        System.out.println("Motor merk " + honda.getMerk() + " dengan tipe data (sebelum) : " + honda.getTipe());
        honda.setTipe("Beat 110");
        System.out.println("Motor merk " + honda.getMerk() + " dengan tipe data (sesudah) : " + honda.getTipe());
    }
}
