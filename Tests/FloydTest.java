package Tests;

import org.junit.jupiter.api.Test;
import src.Modelo.Floyd;

import static org.junit.jupiter.api.Assertions.*;

class FloydTest {

    @Test
    public void FloydTest(){
        long matrizAdyacencia[][]={{0, 30, 50, 10, 10}
                ,{15, 0, 999999999, 10, 999999999}
                ,{999999999, 50, 0, 999999999, 999999999}
                ,{15, 999999999, 999999999, 0, 999999999}
                ,{999999999, 999999999, 30, 30, 0 }};

        long matrizAdyacencia2[][]={{0,3,4,999999999,8,999999999},
                {999999999,0,999999999,999999999,5,999999999},
                {999999999,999999999,0,999999999,3,999999999},
                {999999999,999999999,999999999,0,999999999,999999999},
                {999999999,999999999,999999999,7,0,3},
                {999999999,999999999,999999999,2,999999999,0}};

        Floyd floyd = new Floyd();
        System.out.println(floyd.algoritmoDeFloyd(matrizAdyacencia2,0,1));
        System.out.println(floyd.CentroDelGrafo(matrizAdyacencia2));
    }
}