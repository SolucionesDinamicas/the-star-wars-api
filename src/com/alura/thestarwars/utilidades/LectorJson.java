package com.alura.thestarwars.utilidades;

import com.alura.thestarwars.conexion.SwapiConexion;
import com.alura.thestarwars.modelos.Pelicula;
import com.alura.thestarwars.modelos.PeliculaSwapi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LectorJson {

    List<Pelicula> pelicula = new ArrayList<>();
    Scanner lectura = new Scanner(System.in);
    SwapiConexion swapiConexion = new SwapiConexion();


        //Instanciamos el módulo Gson que descargamos de maven
        //Utilizamos el GsonBuilder() para no tener
        // que cambiar la incial de la variable a mayuscula
        Gson gson = new GsonBuilder()
                //.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE) //En este caso no se usa porque el separador es guion bajo
                // por tanto no nos sirve usar CamelCase sino UNDERSCORES
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()//Mejora la visualización de la salida del JSON
                .create();

    public List<Pelicula> LeerJson(){

        while (true) {

            System.out.println("Escriba el id de la película: ");
            var busqueda = lectura.nextLine();

            if (busqueda.equals("salir")) {
                break;
            }

            // Codificamos la búsqueda correctamente para no generar errores con espacios o caracteres especiales
            String busquedaCodificada = URLEncoder.encode(busqueda, StandardCharsets.UTF_8);

            String direccion = "https://swapi.dev/api/films/" + busquedaCodificada;

            String json = swapiConexion.conexionService(direccion);

            System.out.println(json + "\n");

            //Ahora llevamos el String tipo json que creamos de response.body
            //gson.fromJson convierte el json a un objeto tipo peliculaSwapi
            PeliculaSwapi miPeliculaSwapi = gson.fromJson(json, PeliculaSwapi.class);//La respuesta nos debe devolver una pelicula

            Pelicula miPelicula = new Pelicula(miPeliculaSwapi);//La respuesta nos debe devolver un Titulo
            System.out.println("Película ya convertida: " + miPelicula);
            //Va agregando los miPelicula al arreglo pelicula
            pelicula.add(miPelicula);

        }
        return pelicula; //retornamos la lista de objetos

    }
}
