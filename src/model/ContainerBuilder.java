package model;

/**
 * @author ThePirateCat
 */
public class ContainerBuilder {
    
    private RootNode node;

    public ContainerBuilder(RootNode node) {
        this.node = node;
    }

    public void build() {
        // Pre -> El tamaño del fichero es 0..Root->EndAddress() (en bytes)
        
        // Escribir root header
        // Iterar todos los nodos (deep) {
        //   Escribir cabecera de nodo
        //   Escribir contenido de nodo si fichero
        // }
    }
}
