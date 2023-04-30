package com.Ashir.PBO.Pertemuan4.Tugas1;

public class Ikan extends Hewan {
    String jenis;

    public Ikan(String jenis, String nama, int umur) {
        super(nama, umur);
        this.jenis = jenis;
    }

    @Override
    public void suara() {
        super.suara();
    }
}
