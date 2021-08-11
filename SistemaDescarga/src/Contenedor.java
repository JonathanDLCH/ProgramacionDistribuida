
public class Contenedor {
	//Atributos
	int id;
	int piezas;
	
	 
	//Constructor
	public Contenedor(int id, int piezas) {
            this.id=id;
            this.piezas=piezas;
	}
	
	//Metodo
	public int descargarUnaPieza() {
            if(piezas>0) {
		piezas--;
            }
		
            return piezas;
	}
        
        public int descargarPiezas(int nPiezas){
            if(this.piezas>0){
                piezas-=nPiezas;
            }
            return piezas;
        }

}