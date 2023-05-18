package Tests;

import org.junit.jupiter.api.Test;
import src.Modelo.Reader;

import java.util.ArrayList;
import java.util.HashMap;

class ReaderTest {
    Reader reader = new Reader();

    /*
    @Test
    public void readFileTest(){
        ArrayList<String[]> array = reader.readFile();
        for (String element[]: array) {
            for (String nodeElements: element) {
                System.out.print(nodeElements + " ");
            }
            System.out.println();
        }
    }
    */



    @Test
    public void makeMatrixTest(){
        Integer[][] matrix = reader.makeMatrix(2);
        for (Integer[] array: matrix) {
            for (Integer weight: array) {
                System.out.print(weight + ", ");
            }
            System.out.println();
        }
    }


}