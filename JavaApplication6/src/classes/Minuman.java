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
public class Minuman extends Menu{
    
    public Minuman (String nama_minuman, double harga) {
        setNama_menu(nama_minuman);
        setHarga(harga);
        setKetegori("Minuman");
    }

    private void setKetegori(String minuman) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
