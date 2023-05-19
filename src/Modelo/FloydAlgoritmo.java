package src.Modelo;

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




}
