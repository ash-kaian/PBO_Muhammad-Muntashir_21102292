package com.Ashir.PBO.Pertemuan3.Tugas;

public class StrukPembayaran {
    String namaPesanan;
    int hargaPesanan;
    int banyakPesanan;
    int subTotal;

    public void setNamaPesanan(String namaPesanan) {
        this.namaPesanan = namaPesanan;
    }

    public void setHargaPesanan(int hargaPesanan) {
        this.hargaPesanan = hargaPesanan;
    }

    public void setBanyakPesanan(int banyakPesanan) {
        this.banyakPesanan = banyakPesanan;
    }

    public String getNamaPesanan() {
        return this.namaPesanan;
    }

    public int getHargaPesanan() {
        return this.hargaPesanan;
    }

    public int getBanyakPesanan() {
        return this.banyakPesanan;
    }

    public int getSubTotal() {
        return this.subTotal = this.hargaPesanan * this.banyakPesanan;
    }
}
