
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan
 */
public class Brazo implements Runnable {

    //Atributos
    private int idBrazo, nObjetos,nPiezasA,nPiezasB;
    private Contenedor containerA,containerB;
    public boolean flag[] = {false, false};
    public int turno = 0,sigContenedor;

    //Constructor
    public Brazo(int idBrazo, int nObjetos, Contenedor containerA,Contenedor containerB){
        this.idBrazo = idBrazo;
        this.nPiezasA = nObjetos;
        this.nPiezasB = nObjetos;
        this.nObjetos = nObjetos;
        this.containerA = containerA;
        this.containerB = containerB;
        sigContenedor= idBrazo;
    }

    //Metodo
    @Override
    public void run() {
        while (containerA.piezas > 0 && containerB.piezas > 0) {
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
            if(this.nObjetos>0 && (containerA.piezas!=0 || containerB.piezas!=0)){
            //Sección crítica
            switch(sigContenedor){
                case 0:
                    containerA.descargarUnaPieza();
                    this.nPiezasA--;
                    System.out.println("Brazo " + idBrazo + " descarga 1/"+ (this.containerA.piezas + 1) + " del contenedor A");
                    sigContenedor= sigContenedor==0 ? 1:0;
                    break;
                case 1:
                    containerB.descargarUnaPieza();
                    this.nPiezasB--;
                    System.out.println("Brazo " + idBrazo + " descarga 1/"+ (this.containerB.piezas + 1) + " del contenedor B");
                    sigContenedor= sigContenedor==0 ? 1:0;
                    break;
                default: System.out.println("Ocurrio un error");
            }
            
            }
            if(this.nPiezasA==this.nPiezasB){
                System.out.println("Brazo "+idBrazo+" armo 1 objeto de "+this.nObjetos);
                this.nObjetos--;
            }
            flag[idBrazo] = false;
        }
        System.out.println("Se ha terminado de descargar");
    }

}
