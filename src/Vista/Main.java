package Vista;

public class Main {
    public static void main(String[] args){

        //solo para probar
        long matrizAdyacencia[][]={{0,3,4,999999999,8,999999999},
                {999999999,0,999999999,999999999,5,999999999},
                {999999999,999999999,0,999999999,3,999999999},
                {999999999,999999999,999999999,0,999999999,999999999},
                {999999999,999999999,999999999,7,0,3},
                {999999999,999999999,999999999,2,999999999,0}};

        Floyd floyd = new Floyd();
        System.out.println(floyd.algoritmoDeFloyd(matrizAdyacencia));
        System.out.println(floyd.CentroDelGrafo(matrizAdyacencia));

    }

}
