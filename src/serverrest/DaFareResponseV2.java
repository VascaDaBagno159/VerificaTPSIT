/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverrest;

/**
 *
 * @author delfo
 */
public class DaFareResponseV2 extends DaFareResponse {
    private float importoGiocato;
    private float importoRiscosso;
    
    // Costruttore vuoto necessario per GSON
    public DaFareResponseV2() {
    }
    
    // Costruttore con parametri
   
    public DaFareResponseV2(String giocata, int numero, boolean vittoria,
        float importoGiocato,float importoRiscosso) {
         
        super(giocata,numero,vittoria);
        this.importoGiocato = importoGiocato;
        this.importoRiscosso=importoRiscosso;

    }
    
    
    // Getter
    
    public float getImportoGiocato() {
        return importoGiocato;
    }

    public float getImportoRiscosso() {
        return importoRiscosso;
    }


    
    // Setter
   
    public void setImportoGiocato(float importoGiocato) {
        this.importoGiocato = importoGiocato;
    }

    public void setImportoRiscosso(float importoRiscosso) {
        this.importoRiscosso = importoRiscosso;
    }


 
}