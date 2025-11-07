package com.alura.thestarwars.conexion;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class SwapiConexion  {

   private String json;

//    Método para la establecer la conexión con la API
    public String conexionService(String direccion){

            //Conexión
            try {
                //Nosotros somos el cliente que hace la solicitud
                HttpClient client = HttpClient.newHttpClient();
                //Requerimiento al servidor
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build(); //Patron de diseño llamado builder forma de construir algo

                //Obtenemos la respuesta
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                //Levamos la salida json a un String
                 json = response.body();

            } catch (NumberFormatException e) {
                System.out.println("Ocurrio un error: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la URI, verifique la dirección.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        return json; //Retornamos un string del json

    }

}
