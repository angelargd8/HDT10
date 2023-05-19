package src.Vista;
import src.Vista.Teclado;


//package CVista;
import java.util.Scanner;
//import CControlador.Controlador;

public class Vista {
    Scanner leer; 
    //para validar los espacios 
    Teclado in;
    //Controlador controlador;

    public Vista(){
        leer = new Scanner(System.in);
        //para validar los espacios 
        in = new Teclado();
        //controlador= new Controlador();
    }

    public void Mensaje(String m){
        System.out.println(m);
    }

    /** 
     * @param Seleccion
     * @return int
     */
    public int SeleccioneMenu(String Seleccion){
        int opcion;
        System.out.println(Seleccion);
        opcion= leer.nextInt();
        return opcion; 
    }

    
    /** 
     * @param Seleccion
     * @return String
     */
    public String SeleccioneMenuString(String Seleccion){
        String respuesta;
        respuesta= in.getString(Seleccion);
        return respuesta; 
    }

    public void validacion(){
        System.out.println("\n- Opción no válida vuelva a intentarlo de nuevo -");
    }

    public void validacion2(){
        System.out.println("\n- Primero debe de encender su radio-");
    }


}

