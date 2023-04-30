package com.Ashir.PBO.Pertemuan4.Tugas1;

public class Kucing extends Hewan {
    String jenis;

    public Kucing(String jenis, String nama, int umur) {
        super(nama, umur);
        this.jenis = jenis;
    }

    @Override
    public void suara() {
        System.out.println("Meow...");
    }
}
