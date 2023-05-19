package src.Controlador;

import src.Modelo.FloydAlgoritmo;
import src.Modelo.Reader;

import java.util.Set;

public class Controlador {
    Reader r = new Reader();
    Set<String> keys = r.getKeys(); // ciudades
    String[] ciudades = new String[keys.size()];
    FloydAlgoritmo f = new FloydAlgoritmo();
    Integer[][] graph;


    /**
     * Muestra las ciudades para el menu
     * @return String con las opciones
     */
    public String mostrarCiudades(){
        String ciudades = "";
        int i = 1;
        keys = r.getKeys();
        for (String key : keys) {
            this.ciudades[i-1] = key;
            ciudades += i+") "+key+"\n";
            i ++;
        }
        return ciudades;
    }

    int INF = 999999999;

    /**
     * Visualizar la matriz de caminos mas cortos
     * Visualizar matrices en general
     * @param dist (matriz a mostrar)
     */
    public void printSolution(int[][] dist) {
        int n = dist.length;
        System.out.println("Matriz de distancias mínimas:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Muestra el camino mas corto de una ciudad a otra
     * @param clima
     * @param c1
     * @param c2
     * @return String con el camino corto
     */
    public String caminoCorto(int clima, int c1, int c2){
        f.floyd(r.makeMatrix(clima));
        return f.printShortestPath(ciudades,c1, c2);
    }


}
