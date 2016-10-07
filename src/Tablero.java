
import java.util.*;

/**
 * Created by trox on 29/09/16.
 */
public class Tablero {

    private int tamanioTablero;
    private int cantidadDeBarcos;
    private Map<String, Barco> listaBarcoJugadorUno;
    private StringBuilder tableroOponente;


    static Scanner sc = new Scanner(System.in);

    public Tablero() {
        tamanioTablero=100;
        cantidadDeBarcos=5;
        listaBarcoJugadorUno = new HashMap<String,Barco>();
        tableroOponente = new StringBuilder();
    }


    public int getTamanioTablero() {
        return tamanioTablero;
    }

    public int getCantidadDeBarcos() {
        return cantidadDeBarcos;
    }

    public Map<String,Barco> getListaBarcoJugadorUno(){
        return listaBarcoJugadorUno;
    }

    public void setTamanioTablero(int tamanioTablero) {
        this.tamanioTablero = tamanioTablero;
    }

    public void setListaBarcoJugadorUno(Barco barco){
        this.listaBarcoJugadorUno.put(barco.getCordenada(), barco);
    }

    public Barco crearBarcos(boolean estado, String cordenada){
        //for (int i=0;i<cantidadDeBarcos;i++) {
        return   new Barco(estado, cordenada);

    }

    public static boolean validarEntrada(String entrada){//Sin Espacios
        return  ((entrada.matches("[A-Ja-j]+([1-9])+[A-Ja-j]+([1-9])"))) ;
    }
    public static boolean validarEntrada2(String entrada){//Sin Espacios
        return ((entrada.matches("[A-Ja-j]+([1-9])")));
    }

    public String ingresarBarco(int n){
        String s="";
        System.out.println("Ingrese  las coordenadas del barco: "+n);
        s=sc.next();

        return s;
    }

    public static boolean verificadorCordenadadContigua(int a, int b, int c, int d, int tamanioTablero ){
        boolean var=false;


        if(a==1 && b==1){//VERIFIVO ESQUINA SUPERIOR IZQUIERDA

            if((c==(a+1) && d==b) || (d==(b+1) && c==a)){
                var=true;
            }
        }else
        if(a==1 && b==tamanioTablero){//VERIFICO ESQUINA INFERIOR IZQUIERDA
            if((c==a+1 && d==b) || (d==b-1 && c==a)){
                var=true;
            }
        }else
        if(a==tamanioTablero && b==1){//VERIFICO ESQUINA SUPERIOR DERECHA
            if((c==a-1 && d==b) || (d==b+1 && c==a)){
                var=true;
            }
        }
        else
        if((a>1 && a<tamanioTablero) && (b>1 && b<tamanioTablero)){//VERIFICO COORDENADAS DEL CENTRO
            if((c==a+1 && d==b) || (c==a-1 && d==b) || (d==b-1 && c==a) || (d==b+1 && c==a)){
                var=true;
            }
        }else
        if(a==tamanioTablero && b==tamanioTablero){//VERIFICO ESQUINA INFERIOR DERECHA
            if((c==a-1 && d==b) || (d==b-1 && c==a)){
                var=true;
            }
        }else
        if((a>1 && a<tamanioTablero) && b==tamanioTablero){//VERIFICO CENTRO INFERIOR
            if((c==a+1 && d==b) || (c==a-1 && d==b) || (d==b-1 && c==a)){
                var=true;
            }
        }else
        if(a==1 && (b>1 && b<tamanioTablero)){//VERIFICO CENTRO IZQUIERDO
            if((d==b+1 && c==a) || (d==b-1 && c==a) || (c==a+a && d==b)){
                var=true;
            }
        }else
        if(b==1 && (a>1 && a<tamanioTablero)){//VRIFICO CENTRO SUPERIOR
            if((c==a+1 && d==b) || (c==a-1 && d==b) || (d==b+1 && c==a)){
                var=true;
            }
        }else
        if(a==tamanioTablero && (b>1 && b<tamanioTablero)){//VERIFICO CENTRO DERECHO
            if((d==b+1 && c==a) || (d==b-1 && c==a) || (c==a-1 && d==b)){
                var=true;
            }
        }
        return var;
    }
    public boolean verificoCordenadaEnElTablero(String cadena){

        boolean v2=false;
        char a1=cadena.charAt(0);
        char b1=cadena.charAt(1);
        char c1=cadena.charAt(2);
        char d1=cadena.charAt(3);

        //PROCESO LOS CHAR
        int a=(Character.digit(a1, 32)-9);
        int b=(Character.digit(b1, 16));
        int c=(Character.digit(c1, 32)-9);
        int d=(Character.digit(d1, 16));

        v2=verificadorCordenadadContigua(a, b, c, d, tamanioTablero);

        if(v2){

        }
        return v2;
    }
    public boolean buscaDuplicado(List<Barco> barcoLista, String cordenadaBarco){
        boolean var=false;
        var=barcoLista.contains(cordenadaBarco);
        boolean b;
        return  var;
    }
    public boolean claveValida(String clave){
        boolean var=false;

        if(listaBarcoJugadorUno.containsKey(clave))var=true;

        return var;
    }
    public boolean eliminarBarcoLista(String claveBarco){
        boolean valor=false;
        String s;

        if(claveBarco.length()>2) {
            if (claveValida(claveBarco)) {
                listaBarcoJugadorUno.remove(claveBarco);
                valor=true;
            } else {
                System.out.println("No ha acertado");
            }
        }else{
            StringTokenizer tokens=new StringTokenizer(listaBarcoJugadorUno.toString());
            while (tokens.hasMoreTokens()){

                s=tokens.nextToken("[ { = , } ]");
                if(s.regionMatches(true,0,claveBarco,0,2)){
                    claveBarco=s;
                }else
                if (s.regionMatches(true,2,claveBarco,0,2)){
                    claveBarco=s;
                }
            }
            if (claveValida(claveBarco)) {
                listaBarcoJugadorUno.remove(claveBarco);
                valor=true;
            } else {
                System.out.println("No ha acertado");
            }
        }return valor;

    }
    public int barcosRestates(){
        return listaBarcoJugadorUno.size();
    }
    public int getIDBarco(String s){
        int n=0;
        String cadena;
        cadena=(""+s.charAt(0)+s.charAt(1)+s.charAt(2)+s.charAt(3));

        return (n);
    }

    public static boolean esToken(int i, int j,int[] arr) {// Metodo que compara las cordenadas del tablero con las
        int nn;                                             // que le pasa el arreglo retornando true en caso afirmativo.
        boolean var = false;


        for (int n=0;n<arr.length;n++){
            nn=arr[n];
            if (nn>2) {
                if (((nn / 1000) == j && ((nn / 100) % 10) == i) || (((nn % 100) / 10) == j && (nn % 10) == i)) {
                    var = true;
                }
            }else
            if ((((nn % 100) / 10) == j && (nn % 10) == i)) {
                var = true;
            }

        }//fin for
        return var;
    }//Fin del metodo esToken

    public void mostrarTablero(String lista, int ide) {
        String salida="";

        StringTokenizer tokens = new StringTokenizer(lista.length() > 0 ? lista : "zzzz");

        int n = tokens.countTokens();                                                    //  * convierte el string en
        int[] arreglo = new int[n];                                                      //  tokens (lo divide en segmentos)
        int cont = 0;                                                                    //   y los agrega a un arreglo
        while (tokens.hasMoreElements()) {                                               //
            if (cont <= n) {                                                             //
                arreglo[cont] = (extraerCordenada(tokens.nextToken("[ { = , } ]")));     //
                cont++;                                                                  //
            }                                                                            //
        }//fin while

        if (ide==1){ //Verifico si es jugador uno o dos
            salida="[#]";
        }else
        if (ide==2){salida=" x ";
        }//fin if else

        System.out.println("\t\t\t\t\t\t\t\t  >>TABLERO JUGADOR: "+ide+"<<");   //
        System.out.println("\t\t\t\t\t\t\t\tA  B  C  D  E  F  G  H  I ");    //
        for (int i = 1; i < 10; i++) {                                         //  *Imprimo por pantalla las lineas
            if (i < 10) System.out.print("\t\t\t\t\t\t\t " + i + " ");          //  del tablero.
                //
            else System.out.print("\t\t\t\t\t\t\t"+i + " ");                    //
            //
            for (int j = 1; j < 10; j++) {                                     //
                //
                if (esToken(i, j, arreglo)) {                                   //<<linea en donde se verifica e
                    System.out.print(salida);                                    //  imprime un barco " [#] "
                } else                                                          //     o
                    System.out.print(" : ");                                    //  " : "
            }//Fin for int j
            System.out.println();
        }//Fin for int i

    }//Fin del metodo mostrarTablero.

    public static int extraerCordenada(String cadena){//Metodo para convertir cordenada_String a cordenada_INT (1234).
        int nn;
        if (cadena.length()==4) {
            char a1 = cadena.charAt(0);
            char b1 = cadena.charAt(1);
            char c1 = cadena.charAt(2);
            char d1 = cadena.charAt(3);
            int a = (Character.digit(a1, 32) - 9);
            int b = (Character.digit(b1, 16));
            int c = (Character.digit(c1, 32) - 9);
            int d = (Character.digit(d1, 16));
            nn = (a * 1000 + b * 100 + c * 10 + d);
        }else{
            char a1 = cadena.charAt(0);
            char b1 = cadena.charAt(1);
            int a = (Character.digit(a1, 32) - 9);
            int b = (Character.digit(b1, 16));

            nn = (a * 10 + b);
        }

        return  nn;
    }//Fin del metodo extraerCordenada
    public void setListaTableroOponente(String cadena){
        tableroOponente.append(cadena);
    }

    public StringBuilder getListaTableroOponente(){
        return tableroOponente;
    }
    public boolean buscarElementoListaOponente(String s){

        return tableroOponente.indexOf(s)==-1;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tablero tablero = (Tablero) o;

        return getListaBarcoJugadorUno().equals(tablero.getListaBarcoJugadorUno());

    }

    @Override
    public int hashCode() {
        return getListaBarcoJugadorUno().hashCode();
    }
}
