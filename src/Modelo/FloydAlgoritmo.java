package src.Modelo;

/*
 * LA PARTE DEL ALGORITMO DE FLOYD ESTA SACADA DE:
 * https://www.youtube.com/watch?v=YmzLYdILMd4
 *
 * PARA CALCULAR EL CENTRO ESTA BASADO EN:
 * https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/
 *
 *
 */

public class FloydAlgoritmo {

    private int[][] caminos;
    private int[][] dist;

    /**
     * Algoritmo de floyd para obtener los caminos mas cortos
     * Matriz de caminos, por donde debe de pasar
     * @param graph grafo (matriz de adyacencia)
     */
    public void floyd(Integer[][] graph) {

        int n = graph.length;
        dist = new int[n][n];
        caminos = new int[n][n];
        int i, j, k;

        // Inicializar la matriz de distancias
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
            }
        }
        //printSolution(dist);

        // Inicializar la matriz de caminos
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                caminos[i][j] = j;
            }
        }

        // Calcular las distancias mínimas
        for (k = 0; k < n; k++) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        caminos[i][j] = k; // remplaza los caminos
                    }
                }
            }
        }

        // ESTAS SON TESTS
        // Mostrar la matriz de distancias mínimas
        //printSolution(dist);
        //printSolution(caminos);
        //recorrer(1, 2);
        //printShortestPath(ciudades,caminos, 3, 0);
    }

    /**
     * Encuentra la ruta mas corta de un nodo especifico a otro
     * Ruta mas corta de una ciudad a otra y su camino
     * @param source ciudad de origen
     * @param destination ciudad de destino
     * @return String con la expresion de camino
     */
    public String printShortestPath(String[] ciudades,  int source, int destination) {
        int[][] path = caminos;
        String caminito = "Camino más corto de " + ciudades[source] + " a " + ciudades[destination] + ": ";

        int intermediateNode = source;
        StringBuilder pathBuilder = new StringBuilder();
        //pathBuilder.insert(0,source);
        pathBuilder.insert(0,ciudades[source]);

        while (intermediateNode != destination) {
            intermediateNode = path[intermediateNode][destination];
            pathBuilder.append( " -> ");
            //pathBuilder.append(intermediateNode);
            pathBuilder.append(ciudades[intermediateNode]);
        }
        int peso = dist[source][destination];
        String pesoR = "\n El peso de la ruta es: " + peso;


        //System.out.println(caminito + pathBuilder.toString());
        return caminito + pathBuilder.toString()  + pesoR;

    }

    public int[][] getCaminos(){
        return caminos;
    }

    public static String CentroDelGrafo(String[] ciudades, int[][] Caminos){
        int vertices = Caminos.length;

        float temp1Caminos, temp2Caminos, temp3Caminos;

        //recorrer a base del algoritmo de floyd
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    temp1Caminos= Caminos[i][k];
                    temp2Caminos= Caminos[k][j];
                    temp3Caminos= Caminos[i][j];

                    if (temp1Caminos != 1000000000 && temp2Caminos != 1000000000 && temp1Caminos + temp2Caminos < temp3Caminos) {
                        temp3Caminos = temp1Caminos + temp2Caminos;
                    }
                }

            }
        }

        //encontrar la distancia max de los vertices
        int[] DistanciasMaximasVertices = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            int DistanciasMaxima= 0;

            for (int j = 0; j < vertices; j++) {
                if (Caminos[i][j] > DistanciasMaxima && Caminos[i][j] != 1000000000) {
                    DistanciasMaxima = Caminos[i][j];
                }

            }
            DistanciasMaximasVertices[i] = DistanciasMaxima;
        }


        // Encontrar el vértice con la distancia máxima mínima
        int centro = 0;
        long VerticeDistanciaMaximaMinima = 1000000000;

        //3. El centro del grafo es el vértice con la menor excentricidad.

        for (int i = 0; i < vertices; i++) {

            if (DistanciasMaximasVertices[i] < VerticeDistanciaMaximaMinima) {
                VerticeDistanciaMaximaMinima = DistanciasMaximasVertices[i];
                centro = i;
            }

        }

        return "\nEl centro esta en: "+ ciudades[centro];
    }




}