package com.Ashir.PBO.Pertemuan3.Tugas;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class StrukMain {
    private static StrukPembayaran pesanan = new StrukPembayaran();
    private static Object[][] daftarPesanan;
    private static DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
    private static DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
    private static int totalBayar;


    public static void catatPesanan(String namaPesanan, int hargaPesanan, int banyakPesanan, int index) {
        pesanan.setNamaPesanan(namaPesanan);
        pesanan.setHargaPesanan(hargaPesanan);
        pesanan.setBanyakPesanan(banyakPesanan);
        daftarPesanan[index][0] = pesanan.getNamaPesanan();
        daftarPesanan[index][1] = pesanan.getHargaPesanan();
        daftarPesanan[index][2] = pesanan.getBanyakPesanan();
        daftarPesanan[index][3] = pesanan.getSubTotal();
    }

    public static void main(String[] args) {
        System.out.println("Menu Makanan");
        System.out.println("1. Nasi ayam bakar    : Rp. 18,000,00");
        System.out.println("2. Nasi tongkol bakar : Rp. 20,000,00");
        System.out.println("3. Nasi bebek bakar   : Rp. 25,000,00");
        System.out.println("4. Nasi cumi bakar    : Rp. 30,000,00");
        System.out.println("5. Nasi goreng        : Rp. 25,000,00");
        System.out.print("Masukan Jumlah makanan yang ingin dibeli : "); int jumlahPesanan = new Scanner(System.in).nextInt();
        daftarPesanan = new Object[jumlahPesanan][4];

        System.out.println();

        for(int index = 0; index < jumlahPesanan; index++) {
            System.out.print("Masukan kode makanan ke - " + (index + 1) + "   : "); int kodePesanan =  new Scanner(System.in).nextInt();
            System.out.print("Masukan jumlah makanan ke - " + (index + 1) + " : "); int banyakPesanan =  new Scanner(System.in).nextInt();

            switch(kodePesanan) {
                case 1:
                    catatPesanan("Nasi Ayam Bakar   ", 18000, banyakPesanan, index);
                    break;
                case 2:
                    catatPesanan("Nasi Tongkol Bakar", 20000, banyakPesanan, index);
                    break;
                case 3:
                    catatPesanan("Nasi Bebek Bakar  ", 25000, banyakPesanan, index);
                    break;
                case 4:
                    catatPesanan("Nasi Cumi Bakar    ", 30000, banyakPesanan, index);
                    break;
                case 5:
                    catatPesanan("Nasi Goreng        ", 25000, banyakPesanan, index);
                    break;
                default:
                    System.out.println("Kode Barang Tidak Tersedia");
                    break;
            }
        }

        System.out.println();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);

        System.out.printf("%s. %s\t\t\t\t\t%s\t\t\t\t%s\t\t%s\n", "No", "Nama", "Harga", "Qty", "Sub Total");

        for(int index = 0; index < jumlahPesanan; index++){
            int subTotal = (int) daftarPesanan[index][3];
            totalBayar += subTotal;
            System.out.println(index + 1 + "   " + daftarPesanan[index][0] + "      " + kursIndonesia.format(daftarPesanan[index][1]) + "        " + daftarPesanan[index][2] + "      " + kursIndonesia.format(daftarPesanan[index][3]));
        }

        System.out.println();

        System.out.println("Total Bayar : " + kursIndonesia.format(totalBayar));
    }
}
