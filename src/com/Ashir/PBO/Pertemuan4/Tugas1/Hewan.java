package com.Ashir.PBO.Pertemuan4.Tugas1;

public class Hewan {
    protected String nama, jenis;
    protected int umur;

    public Hewan(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    public void suara() {
        System.out.println("Hewan ini membuat suara");
    }
}