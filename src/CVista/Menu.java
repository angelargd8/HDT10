package CVista;

import src.Controlador.Controlador;

import java.util.ArrayList;

public class Menu {
    Vista vista;
    Controlador controlador;
    int opcion = 0;

    public Menu(){
        vista = new Vista();
        controlador= new Controlador();
    }
    public void MostrarPrograma(){
        while(true) {
            vista.Mensaje("Bienvenido al programa \n Elija la ciudad de origen: ");
            vista.Mensaje(controlador.mostrarCiudades());
            int opi = vista.SeleccioneMenu("Opcion: ");
            vista.Mensaje("Elija la ciudad destino: ");
            vista.Mensaje(controlador.mostrarCiudades());
            int opi2 = vista.SeleccioneMenu("Opcion: ");
            vista.Mensaje("Cual es el clima: \n 1) Normal \n 2) Lluvia \n 3) Nieve \n 4) Tormenta ");
            int opiclima = vista.SeleccioneMenu("Opcion: ");
            vista.Mensaje(controlador.caminoCorto(opiclima, opi - 1, opi2 - 1));
            int p = vista.SeleccioneMenu("Desea salir ? 1) si 2) no");
            if (p == 1){
                vista.Mensaje("Adios!");
                break;
            }
        }
    }











}
