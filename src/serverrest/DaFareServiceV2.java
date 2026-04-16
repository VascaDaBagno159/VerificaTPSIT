/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverrest;

import java.util.Set;

public class DaFareServiceV2 {

    private static final Set<Integer> ROSSI = Set.of(
        1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36
    );
    private static final Set<Integer> NERI = Set.of(
        2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35
    );

    /**
     * Determina se la giocata "ROSSO"/"NERO" vince sul numero dato.
     */
    public static boolean logicaDiCalcolo(String giocata, int numero, float importo) throws IllegalArgumentException {
        if (!parametriValidi(giocata, numero, importo)) {
            throw new IllegalArgumentException("Parametri non validi: giocata deve essere 'ROSSO' o 'NERO', numero 0-36, importo >= 20.00");
        }

        if (numero == 0) return false;

        boolean puntataRosso = giocata.equalsIgnoreCase("rosso");
        boolean numeroRosso = ROSSI.contains(numero);
        boolean numeroNero = NERI.contains(numero);

        return puntataRosso ? numeroRosso : numeroNero; //condizione ? cosa_fare_se_vero : cosa_fare_se_falso;
    }

    private static boolean parametriValidi(String giocata, int numero, float importo) {
        if (giocata == null) return false;
        String g = giocata.trim().toLowerCase();
        boolean giocataOk = g.equals("rosso") || g.equals("nero");
        boolean numeroOk = numero >= 0 && numero <= 36;
        boolean importoOk = importo >= 20.00f;
        return giocataOk && numeroOk && importoOk;
    }
}