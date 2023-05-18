package Tests;

import org.junit.jupiter.api.Test;
import src.Modelo.Floyd;

import static org.junit.jupiter.api.Assertions.*;

class FloydTest {

    @Test
    public void FloydTest(){
        long matrizAdyacencia[][]={{0,3,4,999999999,3,999999999},
                {3,0,999999999,999999999,5,999999999},
                {999999999,999999999,0,999999999,3,999999999},
                {999999999,999999999,999999999,0,999999999,999999999},
                {999999999,999999999,999999999,7,0,3},
                {999999999,999999999,999999999,2,999999999,0}};

        Floyd floyd = new Floyd();
        System.out.println(floyd.algoritmoDeFloyd(matrizAdyacencia,0,1));
        System.out.println(floyd.CentroDelGrafo(matrizAdyacencia));
    }
}