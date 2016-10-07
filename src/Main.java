
import java.util.Scanner;

/**
 * Created by Maurich on 5/10/16.
 */
public class Main {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] ar){

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        introduccion();
        borrarPantalla(0);

        jugador1.mostrarTablero("zzzz",1);
        borrarPantalla(1);

        jugador1.cargarLista();

        int condicion;
        String s2="";

        do {
            condicion=menuJuego();

            switch (condicion) {
                case 1:
                    borrarPantalla(0);
                    boolean valido2 = false;
                    while (!valido2) {//Verifico la cordena ingresada.
                        s2 = jugador2.ingresarBarco(2);

                        valido2 = jugador2.validarEntrada2(s2);//Verifica la sintaxis que sea del tipo: A1.

                        if (valido2){
                            valido2 = jugador2.buscarElementoListaOponente(s2);//Busca en la lista si el barco ya fue ingresado.
                        }else

                        if (!valido2){
                            System.out.println("Entrada no valida");
                        }
                    }//Fin WHILE
                    jugador2.setListaTableroOponente(" " + s2 + " ");
                    int valido3 = 0;
                            while (valido3==0){
                            System.out.println("\tA ACERADO ? S / N ");
                                valido3=validarEntrada2(sc.next());
                            if(valido3==1)jugador1.setContadorDeAciertos(1);

                            else
                                if (valido3==0)System.out.println("Entrada no valida");
                            }

                    break;
                case 2:
                    borrarPantalla(0);

                    if(jugador1.eliminarBarcoLista(jugador1.ingresarBarco(1).toString())){
                        jugador2.setContadorDeAciertos(1);
                        System.out.println("\n\t\t//BARCO UNDIDO\\! \n");
                    }

                    break;
                case 3:
                    borrarPantalla(0);
                    jugador1.mostrarTablero(jugador1.getListaBarcoJugadorUno().toString(), 1);
                    borrarPantalla(1);
                    jugador2.mostrarTablero(jugador2.getListaTableroOponente().toString(), 2);

                    break;
                case 4:
                    borrarPantalla(0);
                    estadoJuego(jugador1.getContadorDeAciertos(), jugador2.getContadorDeAciertos());

                    break;
                case 5:
                    condicion = 0;
                    break;
                default:
                    borrarPantalla(0);

                    System.out.println("\n\t\t! opcion incorrecta.. \n");
                    condicion = 9;
            }

            if(jugador1.getContadorDeAciertos()==jugador1.getCantidadDeBarcos() ||  jugador2.getContadorDeAciertos()==jugador2.getCantidadDeBarcos()){
                condicion=0;
            }

        }while (condicion!=0);
        System.out.println("\n\t\t\t\t\t//***JUEGO TERMINADO***\\ \n");
        estadoJuego(jugador1.getContadorDeAciertos(), jugador2.getContadorDeAciertos());


    }
    public static void borrarPantalla(int n){
        if(n==0) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }else{
            System.out.println("\n\n");
        }
    }
    public static void introduccion(){
        System.out.println("\n\n\n\n\t\t\t\t\t\t***INICIO JUEGO BATALLA NAVAL***\n\n\t\t\t" +
                "[El juego consta de un tablero de 9 por 9 celdas y 5 barcos]\n\n ");
        System.out.println("\t\t\t\t\t\tPresione una tecla para continuar");
        sc.nextLine();
    }

    public static int menuJuego(){
        int s=0;
        String ss;
        boolean v=true;
        System.out.println("\n\t\t\t\t[ELIJA UNA OPCION DEL MENU]\n\n\n");
        System.out.print("\t\t\t[ 1 ]: TURNO JUGADOR 1.\n\t\t\t[ 2 ]: TURNO JUGADOR 2." +
                "\n\t\t\t[ 3 ]: MOSTRAR TABLERO." +
                "\n\t\t\t[ 4 ]: ESTADO DEL JUEGO." +
                "\n\t\t\t[ 5 ]: SALIR\n\n>>");
        while (v) {
            ss = sc.next();
            if(validarEntrada(ss)) {
                char a1 = ss.charAt(0);
                s = (Character.digit(a1, 16));
                v=false;
            }else System.out.println("\n\t\t! opcion incorrecta.. \n");
        }
        return s;
    }
    public static void estadoJuego(int a, int b){

        System.out.println("\nESTADO DE JUEGO..\n\nJUGADOR 1: "+a+"\nJUGADOR 2: "+b);
        if (a==b){
            System.out.println("\nEMPATE");
        }else
        if (a>b){
            System.out.println("\nEL JUGADOR 1 GANA");
        }else {
            System.out.println("\nEL JUGADOR 2 GANA");
        }

    }
    public static boolean validarEntrada(String s){
        return ((s.matches("([1-5])")));
    }
    public static int validarEntrada2(String s){
        int v=0;
        if ((s.equalsIgnoreCase("S")))v=1;

        else
        if ((s.equalsIgnoreCase("N")))v=2;

        return v;
    }

}
