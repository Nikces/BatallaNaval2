
/**
 * Created by Maurich on 27/09/16.
 */
public class Barco {

    private boolean estado;//   flotar o undido
    private String cordenada;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Barco() {
    }

    public Barco(boolean estado, String cordenada) {
        this.estado = estado;
        this.cordenada = cordenada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getCordenada() {
        return cordenada;
    }

    public void setCordenada(String cordenada) {
        this.cordenada = cordenada;
    }

    @Override
    public String toString() {
        return "";
    }
}
