package com.Ashir.PBO.Pertemuan5;

public class Main {
    public static void main(String[] args) {
        // Membuat Array kosong
        Barang[] keranjang = new Barang[10];

        // Membuat Array dengan isinya
        Barang[] etalase = {
                new Barang("Indomie", 3000),
                new Barang("Pulpen", 3000),
                new Barang("Pensil", 2500),
                new Barang("Spidol", 5000),
                new Barang("Penghapus", 4000)
        };

        // Menampilkan jumlah data dalam Array
        System.out.println("Jumlah barang yang ada di etalase : " + etalase.length);

        // Menampilkan data yang ada didalama Array
        System.out.println("Daftar barang yang ada dalam etalase : " );

        // Perulangan for each unuk menampilkan data yang ada dalam Array
        int i = 1;
        for (Barang b : etalase) {
            System.out.println("Barang ke-" + i);
            b.showInfo();
            i++;
        }

        for (int j=0; j< etalase.length ;j++){
            System.out.println("Barang ke-" + (j+1));
            etalase[j].showInfo();
        }
    }
}
