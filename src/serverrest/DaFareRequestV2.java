/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverrest;

/**
 *
 * @author delfo
 */
public class DaFareRequestV2 extends DaFareRequest {
    
    private float importo;

    // Costruttore vuoto necessario per GSON
    public DaFareRequestV2() {
    }
    
    // Costruttore con parametri  
    public DaFareRequestV2(String giocata, int numero,float importo) {
        super(giocata,numero);
        this.importo = importo;
    }


    
    // Getter
    
    public float getImporto() {
        return importo;
    }
   
    // Setter
  

    public void setImporto(float importo) {
        this.importo = importo;
    }

    
   
    // ToString

   @Override
    public String toString() {
        return "DaFareRequestV2 : [importo=" + importo + ", getGiocata()=" + getGiocata() + ", getImporto()="
                + getImporto() + ", getNumero()=" + getNumero() + "]";
    }
    
    
    

}