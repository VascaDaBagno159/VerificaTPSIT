/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverrest;

/**
 *
 * @author delfo
 */
public class DaFareRequest {
    
    private String giocata;
    private int numero;

    // Costruttore vuoto necessario per GSON
    public DaFareRequest() {
    }
    
    // Costruttore con parametri  
    public DaFareRequest(String giocata, int numero) {
        this.giocata = giocata;
        this.numero = numero;
    }
    
    
    // Getter
   
    public String getGiocata() {
        return giocata;
    }
    public int getNumero() {
        return numero;
    }
    // Setter
    public void setGiocata(String giocata) {
        this.giocata = giocata;
    }

    

    public void setNumero(int numero) {
        this.numero = numero;
    }

   
    // ToString
    @Override
     public String toString() {
            return "Richiesta : [giocata=" + giocata + ", numero=" + numero + "]";
        }

    
    

}