
/**
 * Created by trox on 5/10/16.
 */
public class Jugador extends Tablero {

    private  int contadorDeAciertos;

    public Jugador() {
        super();
        contadorDeAciertos=0;
    }

    public int getContadorDeAciertos() {
        return contadorDeAciertos;
    }

    public void setContadorDeAciertos(int contadorDeAciertos) {
        this.contadorDeAciertos += contadorDeAciertos;
    }
    public void cargarLista(){
        // Tablero tablero1=new Tablero();
        // int barcos=2;
        String s="";

        for (int i=0;i<getCantidadDeBarcos();i++) {

            Boolean valido = false;

            // String s="";
            while (!valido) {//Verifico la cordena ingresada.
                s=ingresarBarco(1);
                valido = validarEntrada(s);//Verifica la sintaxis que sea del tipo: A1B2.
                if (valido) valido = !claveValida(s);//Busca en la lista si el barco ya fue ingresado.

                if (valido) valido = verificoCordenadaEnElTablero(s);//Verifica que las cordenadas sean contiguas.

                if (!valido) System.out.println("Entrada no valida");
            }//Fin WHILE
            setListaBarcoJugadorUno(crearBarcos(valido,s));


            // System.out.println(tablero1.crearBarcos(valido,s));
            //System.out.println(tablero1.getListaBarcoJugadorUno());

        }//Fin del FOR
    }
}
