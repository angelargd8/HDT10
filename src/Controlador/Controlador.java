package src.Controlador;

import src.Modelo.Floyd;
import src.Modelo.Reader;

import java.util.Set;

public class Controlador {
    Reader r = new Reader();
    public String mostrarCiudades(){
        String ciudades = "";
        int i = 1;
        Set<String> keys = r.getKeys();
        for (String key : keys) {
            ciudades += i+") "+key+"\n";
            i ++;
        }
        return ciudades;
    }

    public void caminoCorto(Integer opiClima, int c1, int c2){
        Integer [][] integerArray = r.makeMatrix(opiClima);
        long[][] matrizAdyacencia = new long[integerArray.length][];
        for (int i = 0; i < integerArray.length; i++) {
            matrizAdyacencia[i] = new long[integerArray[i].length];
            for (int j = 0; j < integerArray[i].length; j++) {
                matrizAdyacencia[i][j] = integerArray[i][j].longValue();
            }
        }
        Floyd floyd = new Floyd();
        System.out.println(floyd.algoritmoDeFloyd(matrizAdyacencia,c1,c2));
        System.out.println(floyd.CentroDelGrafo(matrizAdyacencia));
    }


}
