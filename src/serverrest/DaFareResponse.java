/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverrest;

/**
 *
 * @author delfo
 */
public class DaFareResponse {
    private String giocata;
    private int numero;
    private boolean vittoria;
    
    // Costruttore vuoto necessario per GSON
    public DaFareResponse() {
    }
    
    // Costruttore con parametri
   
    public DaFareResponse(String giocata, int numero, boolean vittoria) {
        this.giocata = giocata;
        this.numero = numero;
        this.vittoria = vittoria;
    }
    
    
    // Getter
     public String getGiocata() {
        return giocata;
    }
    public int getNumero() {
        return numero;
    }

    public boolean isVittoria() {
        return vittoria;
    }

    
    // Setter

  

    public void setGiocata(String giocata) {
        this.giocata = giocata;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setVittoria(boolean vittoria) {
        this.vittoria = vittoria;
    }

}