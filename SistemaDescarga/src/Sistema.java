/*
El objetivo consiste en implementar un sistema que permita vaciar un contenedor. 
Este sistema presenta un problema de sección crítica, es importante identificarla y utilizar el algoritmo de Peterson para la solución.
El sistema se compone de dos brazos robots y un contenedor con piezas, compartido por ambos.
Cada brazo tiene como propósito tomar una determinada cantidad de piezas del contenedor, de manera que entre los dos brazos robots logren vaciar el contenedor. 
Los brazos pueden tomar la misma o diferente cantidad de piezas.
 */

/**
 *
 * @author Jonathan
 */
public class Sistema {
    public static void main(String[] args) throws InterruptedException{        
        Contenedor contenedor1 = new Contenedor(1,20);
        Contenedor contenedor2 = new Contenedor(2,20);
        
        Brazo brazo1 = new Brazo(0,10,contenedor1,contenedor2);
        Brazo brazo2 = new Brazo(1,10,contenedor1,contenedor2);
        
        Thread h1 = new Thread(brazo1);
        Thread h2 = new Thread(brazo2);
        
        h1.start();
        Thread.sleep(100);
        h2.start();
        Thread.sleep(100);
    }
    
}
