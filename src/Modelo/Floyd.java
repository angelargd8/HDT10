
/*
 * LA PARTE DEL ALGORITMO DE FLOYD ESTA SACADA DE:
 * https://www.youtube.com/watch?v=YmzLYdILMd4
 *
 * PARA CALCULAR EL CENTRO ESTA BASADO EN:
 * https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/
 *
 *
 */

public class Floyd {
    //metodos para determinar todos los caminos del algoritmo de floyd

    public String algoritmoDeFloyd(long[][] matrizAdyacente){


        int vertices = matrizAdyacente.length;   //para obtener la cantidad de vertices de la matriz
        long matrizAdyacencia[][]=matrizAdyacente; //va a guardar aqui la matriz para verlos como vectores

        //cadena que va a guardar los caminos
        String Caminos[][]= new String[vertices][vertices];
        //cadena de caminos auxiliares
        String CaminosAuxiliares[][]=new String[vertices][vertices];

        String CaminoRecorrido ="", cadena= "", TodosLosCaminos= "", StringMinimo="";


        int i, j,k; //indices

        float temp1, temp2, temp3,temp4, minimo;

        //inicializo la matriz

        for ( i = 0; i<vertices; i++){
            for ( j = 0; j<vertices; j++){
                Caminos[i][j] = "";
                CaminosAuxiliares[i][j] = "";

            }
        }

        //recorrer
        for ( k = 0; k<vertices; k++){
            for ( i = 0; i<vertices; i++){
                for ( j = 0; j<vertices; j++){
                    temp1= matrizAdyacencia[i][j];
                    temp2= matrizAdyacencia[i][k];
                    temp3= matrizAdyacencia[k][j];
                    temp4= temp2 + temp3;

                    //encontrar el minimo
                    minimo = Math.min(temp1, temp4);

                    //condiciones
                    if (temp1!= temp4){ //validando lo de los 0's

                        if (minimo==temp4){ //camino + corto
                            CaminoRecorrido="";
                            CaminosAuxiliares[i][j]= k +"";
                            Caminos[i][j] = CaminosR(i, k, CaminosAuxiliares, CaminoRecorrido, (k+1));

                        }

                    }
                    //cuando ya regrese hace un casta para que que soporte el numero
                    //pasa de int a long
                    matrizAdyacencia[i][j]= (long) minimo;
                }


            }
        }
        //agregar el camino minimo a la cadena
        for (i = 0; i< vertices; i++) {
            //recorrer la matriz
            for (j = 0; j< vertices; j++) {
                //matriz de los minimos
                //para ver la matriz que le estamos pasando
                cadena = cadena + "["+ matrizAdyacencia[i][j]+"]";
            }
            //concatenar la cadena
            cadena += "\n";
        }

        //////

        //mostrar los caminos
        for (i = 0; i< vertices; i++) {
            //recorrer la matriz
            for (j = 0; j< vertices; j++) {
                //si el valor es INF
                //se pone un valor que represente infinito
                if (matrizAdyacencia[i][j] != 1000000000){
                    //validar que no sea el mismo
                    // (es decir que no sea 0)
                    //que a no se este señalando a si misma
                    if(i != j){
                        if (Caminos[i][j].equals("")){
                            TodosLosCaminos += " De ("+ (i+1) + " --> "+(j+1)+") ir por: ("+(i+1)+" , "+ (j+1)+")\n";



                        }else{
                            //esta parte es innecesaria porque no se tienen que mostrar todos los caminos
                            String NoEsNecesarioMostrarTodosLosCaminosEntoncesMeCuido="";
                            ///TodosLosCaminos += " De ("+ (i+1) + " --> "+(j+1)+") ir por: ("+(i+1)+" , "+ Caminos[i][j]+ ","+ (j+1)+ ")\n";

                        }

                    }
                }
            }
        }


        return " la matriz del camino más corto es: \n"+cadena+" \n Los caminos más cortos son : \n"+TodosLosCaminos;

    }

    private void MostrarCaminos(long[][] matrizAdyacente){
        int vertices = matrizAdyacente.length;
        //cadena que va a guardar los caminos
        int Caminos[][]= new int[vertices][vertices];

    }



    private String CaminosR(int i, int k, String[][] caminosAuxiliares, String caminoRecorrido, int jota) {

        if (caminosAuxiliares[i][k]==""){
            return "";
        }else{
            //recursividad
            caminoRecorrido+= CaminosR(i, Integer.parseInt(caminosAuxiliares[i][k].toString()), caminosAuxiliares, caminoRecorrido+(Integer.parseInt(caminosAuxiliares[i][k].toString()+1)), jota)+", ";
            //caminoRecorrido[i][k]+= CaminosR(i, Integer.parseInt(caminosAuxiliares[i][k].toString()), caminosAuxiliares, caminoRecorrido+(Integer.parseInt(caminosAuxiliares[i][k].toString()+1)))+", ";

        }
        return caminoRecorrido;
    }


    //////////////
    //////////////
    ///Calcular el centro del grafo
    //1. encontrar las rutas más cortas entre vertices
    //2. para cada vertice encontrar el máximo minimo entre las parejas
    //3. El centro del grafo es el vértice con la menor excentricidad.

    public static int CentroDelGrafo(long[][] matrizAdyacente){
        int vertices = matrizAdyacente.length;

        //cadena que va a guardar los caminos
        int Caminos[][]= new int[vertices][vertices];

        //matriz de distancias
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                //cast de long a int
                Caminos[i][j] = (int) matrizAdyacente[i][j];
            }
        }

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

        System.out.println("el centro esta en: "+ centro);
        return centro;

        //

    }
    
}
