/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverrest;

public class DaFareService {

    /**
     * Determina se la giocata "pari"/"dispari" vince sul numero dato.
     *
     * @param giocata "pari" oppure "dispari" (case-insensitive)
     * @param numero  numero estratto, 0–36
     * @return true se la giocata è vincente, false altrimenti
     * @throws IllegalArgumentException se i parametri non sono validi
     */
    public static boolean logicaDiCalcolo(String giocata, int numero) throws IllegalArgumentException {
        if (!parametriValidi(giocata, numero)) {
            throw new IllegalArgumentException("Parametri non validi: giocata deve essere 'pari' o 'dispari' e numero tra 0 e 36");
        }

        // In roulette europea lo 0 perde sia per pari che per dispari
        if (numero == 0) return false;

        boolean numeroPari = (numero % 2 == 0);
        boolean puntataPari = giocata.equalsIgnoreCase("pari");
        return numeroPari == puntataPari;
    }

    private static boolean parametriValidi(String giocata, int numero) {
        if (giocata == null) return false;
        String g = giocata.trim().toLowerCase();
        boolean giocataOk = g.equals("pari") || g.equals("dispari");
        boolean numeroOk = numero >= 0 && numero <= 36;
        return giocataOk && numeroOk;
    }
}