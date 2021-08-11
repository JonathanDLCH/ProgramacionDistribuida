
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan
 */
public class Brazo implements Runnable {

    //Atributos
    private int idBrazo, nPiezas;
    private Contenedor container;
    public boolean flag[] = {false, false};
    public int turno = 0;

    //Constructor
    public Brazo(int idBrazo, int nPiezas, Contenedor container) {
        this.idBrazo = idBrazo;
        this.nPiezas = nPiezas;
        this.container = container;
    }

    //Metodo
    @Override
    public void run() {
        while (container.piezas > 0) {
            int otherId = idBrazo == 0 ? 1 : 0;
            flag[idBrazo] = true; //flag[0]=true   flag[1]=true
            turno = otherId;
            //System.out.println("[0]"+flag[0]+" [1]"+flag[1]+" turno"+turno);
            while (flag[otherId] == true && turno == otherId) {
            }//flag[0]=true flag[1]=true
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Brazo.class.getName()).log(Level.SEVERE, null, ex);
            }
            //while(container.piezas>0){
            //Sección crítica
            container.descargarPiezas(this.nPiezas);
            System.out.println("Brazo " + idBrazo + "descarga " + nPiezas + " piezas de " + (this.container.piezas + 1) + " del contenedor");
            //}

            flag[idBrazo] = false;
        }
    }

}
