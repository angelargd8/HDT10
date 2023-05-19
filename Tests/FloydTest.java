package Tests;

import org.junit.jupiter.api.Test;
import src.Modelo.FloydAlgoritmo;

class FloydTest {

    @Test
    public void FloydTest(){
        String[] ciudades = {"Lima", "BuenosAires", "Guatemala", "SaoPaulo","Quito"};
        Integer[][] matrizAdyacencia={{0, 30, 50, 10, 10}
                ,{15, 0, 999999999, 10, 999999999}
                ,{999999999, 50, 0, 999999999, 999999999}
                ,{15, 999999999, 999999999, 0, 999999999}
                ,{999999999, 999999999, 30, 30, 0 }};

        FloydAlgoritmo f = new FloydAlgoritmo();
        f.floyd(matrizAdyacencia);
        System.out.println(f.printShortestPath(ciudades,1, 2));
    }
}