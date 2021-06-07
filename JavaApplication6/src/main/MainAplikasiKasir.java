/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import classes.DaftarMenu;
import classes.Kuah;
import classes.Minuman;
import classes.Ramen;
import classes.Toping;
import classes.Transaksi;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class MainAplikasiKasir {
    
    public DaftarMenu daftarMenu;
    
    
    
    public static double PAJAK_PPN = 0.10;
    public static double BIAYA_SERVICE = 0.05;
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);       
        
        String no_transaksi, nama_pemesan, tanggal, no_meja = "";
        String transaksi_lagi = "", pesan_lagi = "", keterangan = "", makan_ditempat;
        int jumlah_pesanan, no_menu;
        
        System.out.println("======= TRANSAKSI =======");
        do {
            System.out.print("No Transaksi : ");
            no_transaksi = input.next();
            System.out.print("Pemesan : ");
            nama_pemesan = input.next();
            System.out.print("Tanggal : [dd-mm-yyyy] ");
            tanggal = input.next();
            System.out.print("Makan ditempat? [Y/N] ");
            makan_ditempat = input.next();
            
            if (makan_ditempat.equalsIgnoreCase("Y")) {
                System.out.print("Nomor Meja : ");
                no_meja = input.next();
            }
             
        Transaksi trans = new Transaksi(no_transaksi, nama_pemesan, tanggal, no_meja);
            System.out.println("======= PESANAN =======");
            int no_kuah;
            do {
                Menu meni_yang_dipilih = app.daftarMenu.pillihMenu();
                
                jumlah_pesanan = (int) app.cekInputNumber("Jumlah : ");
                
                Pesanan pesanan = new Pesanan(menu_yang_dipilih, jumlah_pesanan);
                trans.tambahPesanan(pesanan);
                
                if (menu_yang_dipilih.getKategori().equals("Ramen")) {
                    int jumlah_ramen = jumlah_pesanan;
                    do {
                        Menu kuah_yang_dipilih = app.daftarMenu.pilihkuah();
                        
                        System.out.print("Level : [0-5] : ");
                        String level = input = input.next();
                        
                        int jumlah_kuah = 0;
                        do {
                            
                            jumlah_kuah = (int) app.cekInputNumber("Jumlah : ");
                            
                            if (jumlah_kuah > jumlah_ramen) {
                                System.out.println("[Err] Jumlah kuah melebihi jumlah ramen yang sudah dipesan");                                
                            }else{
                                
                                break;
                            }
                        }while (jumlah_kuah > jumlah_ramen);
                        
                        Pesanan pesan_kuah = new Pesanan(kuah_yang_dipilih, jumlah_kuah);
                        pesan_kuah.setKeterangan("Level "+ level);
                        
                        trans.tambahPesanan(pesan_kuah);
                        
                        jumlah_ramen -= jumlah_kuah;                                                              
                    } while (jumlah_ramen > 0);
                } else {
                    
                    System.out.println("Keterangan [- jika kosong]: ");
                    keterangan = input.next();
                }
                
                if (!keterangan.equals("-")) {
                    pesanan.setKeterangan(keterangan);
                }
                
                System.out.print("tambah Pesanan lagi? [Y/N] : ");
             
                pesan_lagi = input.next();
            
            }   while (pesan_lagi.equalsIgnoreCase("Y"));
            
            trans.cetakStruk();
            
            double total_pesanan = trans.hitungTotalPesanan();
            System.out.println("============================");
            System.out.println("Total : \t\t" + total_pesanan);
            
            trans.setPajak(PAJAK_PPN);
            double ppn = trans.hitungPajak();
            System.out.println("Pajak 10% : \t\t" + ppn);
            
            trans.setPajak(PAJAK_PPN);
            double ppn = trans.hitungPajak();
            System.out.println("pajak 10% : \t\t + ppn");
            
            double biaya_service = 0;
            if (makan_ditempat.equalsIgnoreCase("Y")) {
                trans.setBiayaService();
                System.out.ptintln("Biaya Service 5% : \t" + biaya_service;)
            }
            
            System.out.println("Total : \t\t" + trans.hitungTotalBiayar(ppn, biaya_service));
            
            double kembalian =0;
            do {
                double uang_bayar = app.cekInputNumber("Uang Bayar : \t\t");
                
                kembalian = trans.hitungKembalian(uang_bayar);
                if (kembalian < 0 ){
                    System.out.println("[Err] Uang anda Kuang");
                }else {
                    System.out.println("Lembalian : \t\t +" kembalian);
                    break;
                }
            }while (kembalian <0);
            
            System.out.println("===== TERIMA KASIH =====");
    }
         
    public void generateDaftarMenu() {
        daftarMenu = new DaftarMenu();
        daftarMenu.tambahMenu(new Ramen("Ramen Seafoood", 25000));
        daftarMenu.tambahMenu(new Ramen("Ramen Original", 18000));
        daftarMenu.tambahMenu(new Ramen("Ramen Vegetarian", 22000));
        daftarMenu.tambahMenu(new Ramen("Ramen Karnivor", 28000));
        daftarMenu.tambahMenu(new Kuah("Kuah Orisinil"));
        daftarMenu.tambahMenu(new Kuah("Kuah Internasional"));
        daftarMenu.tambahMenu(new Kuah("Kuah Spycy Lada"));
        daftarMenu.tambahMenu(new Kuah("Kuah Soto Padang"));
        daftarMenu.tambahMenu(new Toping("Crab Stick Bakar", 6000));
        daftarMenu.tambahMenu(new Toping("Chiken Katsu", 8000));
        daftarMenu.tambahMenu(new Toping("Gyouza Goreng", 4000));
        daftarMenu.tambahMenu(new Toping("Bakso Goreng", 7000));
        daftarMenu.tambahMenu(new Toping("Enoki Goreng", 5000));
        daftarMenu.tambahMenu(new Minuman("Jus Alpukat SPC", 10000));
        daftarMenu.tambahMenu(new Minuman("JusStroberi Goreng", 11000));
        daftarMenu.tambahMenu(new Minuman("Capucino Coffe", 15000));
        daftarMenu.tambahMenu(new Minuman("Vietnam Dripp", 14000));
        
        daftarMenu.tampilDaftarMenu();    
    }
    
    public double cekInputNumber(String label) {
        try{
            Scanner get_input = new Scanner(System.in);
            System.out.print(label);
            double nilai = get_input.nextDouble();
            
            return nilai;
        }catch(InputMismatchException ex){
            System.out.println("[Err] Harap masukkan angka");
            return cekInputNumber(label);
        }
    }
            
}
