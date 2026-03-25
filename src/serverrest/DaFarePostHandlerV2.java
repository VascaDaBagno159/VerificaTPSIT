/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package serverrest;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class DaFarePostHandlerV2 extends DaFarePostHandler implements HttpHandler {
    
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equalsIgnoreCase("POST")) {
            inviaErrore(exchange, 405, "Metodo non consentito. Usa POST");
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8))) {
            
            DaFareRequestV2 request = gson.fromJson(reader, DaFareRequestV2.class);

            if (!validazioneParametri(request)) {
                inviaErrore(exchange, 400, "Parametri non validi");
                return;
            }
            
            boolean vittoria = DaFareServiceV2.logicaDiCalcolo(
                request.getGiocata(),
                request.getNumero(),
                request.getImporto()
            );

            float importoGiocato = request.getImporto();
            
            DaFareResponseV2 response = new DaFareResponseV2(
                request.getGiocata(),
                request.getNumero(),
                vittoria,
                importoGiocato
            );
            
            String jsonRisposta = gson.toJson(response);
            inviaRisposta(exchange, 200, jsonRisposta);
            
        } catch (JsonSyntaxException e) {
            inviaErrore(exchange, 400, "JSON non valido: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            inviaErrore(exchange, 400, e.getMessage());
        } catch (Exception e) {
            inviaErrore(exchange, 500, "Errore interno del server: " + e.getMessage());
        }
    }
    
    private boolean validazioneParametri(DaFareRequestV2 request) {
        if (request == null || request.getGiocata() == null) return false;
        String g = request.getGiocata().trim().toLowerCase();
        boolean giocataOk = g.equals("rosso") || g.equals("nero");
        boolean numeroOk = request.getNumero() >= 0 && request.getNumero() <= 36;
        boolean importoOk = request.getImporto() >= 20.00f;
        return giocataOk && numeroOk && importoOk;
    }

    private void inviaRisposta(HttpExchange exchange, int codice, String jsonRisposta) 
            throws IOException {
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
        exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        byte[] bytes = jsonRisposta.getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(codice, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }
    
    private void inviaErrore(HttpExchange exchange, int codice, String messaggio) 
            throws IOException {
        Map errore = new HashMap<>();
        errore.put("errore", messaggio);
        errore.put("status", codice);
        String jsonErrore = gson.toJson(errore);
        inviaRisposta(exchange, codice, jsonErrore);
    }
}