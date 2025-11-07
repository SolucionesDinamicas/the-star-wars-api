package com.alura.thestarwars.principal;

import com.alura.thestarwars.conexion.SwapiConexion;
import com.alura.thestarwars.utilidades.EscritorJson;
import com.alura.thestarwars.utilidades.LectorJson;
import java.io.IOException;


public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException {

       //Instanciamos las clases
        LectorJson lectorJson = new LectorJson(); // Buscamos las películas con el id
        EscritorJson escritorJson = new EscritorJson();//Escribimos en el archivo json

        //Llamamos los dos métodos escribir llama a leer y este le devuelve un arreglo con objetos
        escritorJson.escribirJson(lectorJson.LeerJson());










    }
}
