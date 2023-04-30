package com.Ashir.PBO.Pertemuan4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager managerkami = new Manager();
        Pegawai pegawaikami = new Pegawai();
        Scanner input = new Scanner(System.in);

        managerkami.nip = 198067857;
        managerkami.nama = "Hasan Sadikin";


        pegawaikami.nip = 19806798;
        pegawaikami.nama = "Asep Hutama";

        managerkami.showInfo();
        managerkami.extraInfo();
        managerkami.bonus(12000000);
        managerkami.bonus();

        pegawaikami.showInfo();
    }
}
