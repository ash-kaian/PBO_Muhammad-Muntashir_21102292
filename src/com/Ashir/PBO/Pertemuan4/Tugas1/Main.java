package com.Ashir.PBO.Pertemuan4.Tugas1;

public class Main {
    public static void main(String[] args) {

        Hewan[] animals = new Hewan[3];
        animals[0] = new Anjing("Anjing", "Alex", 7);
        animals[1] = new Kucing("Kucing", "Rey", 6);
        animals[2] = new Ikan("Ikan", "Piranha", 1);

        for (Hewan hewan : animals) {
            System.out.println("Hewan dengan jenis " + hewan.jenis + " dengan nama " + hewan.nama + " berumur " + hewan.umur + " tahun.");
            hewan.suara();
            System.out.println("");
        }
    }
}
