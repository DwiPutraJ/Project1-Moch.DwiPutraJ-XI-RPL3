/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Acer
 */

import java.util.ArrayList;

public class DaftarMenu {
    private ArrayList<Menu> daftarMenu;
            
        public DaftarMenu() {
            daftarMenu = new ArrayList<>();
        }
            
        public void tambahMenu(Menu menu) {
            daftarMenu.add(menu);
        }
            
        public void getMenuByKetegori(String kategori) {
            System.out.println("======="+ kategori + "=======");
            
            for (int i = 0; i < daftarMenu.size(); i++) {
                Menu m = daftarMenu.get(i);
                if (m.getKategori().equals(kategori)) {
                    System.out.println((i + 1) + ". " + m.getNama_menu() + "\t " + m.getharga());                   
                }
                    
            }
        }
            
        public void tampilDaftarMenu() {
        System.out.println("======= ALDEBARAMEN =======");
        getMenuByKetegori("Ramen");
        getMenuByKetegori("Kuah");
        getMenuByKetegori("Toping");
        getMenuByKetegori("Minuman");
    }
    
}
