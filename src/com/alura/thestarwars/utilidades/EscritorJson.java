package com.alura.thestarwars.utilidades;

import com.alura.thestarwars.modelos.Pelicula;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EscritorJson {
    public void escribirJson(List<Pelicula> pelicula) throws IOException {

        //Implementa el Gson
        Gson gson = new GsonBuilder()
                //.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE) //
                // En este caso no se usa porque el separador es guion bajo
                //y por lo tanto no nos sirve usar CamelCase sino UNDERSCORES
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()//Mejora la visualización de la salida del JSON
                .create();

        //Crea el archivo con extensión json
        FileWriter escritura = new FileWriter("peliculas.json");
        //Convierte lo que tenemos en el arreglo a un tipo json
        escritura.write(gson.toJson(pelicula));//Convertimos el título a un archivo .JSON
        escritura.close();

        System.out.println("Se creo el archivo: 'películas.json' ");

    }
}
