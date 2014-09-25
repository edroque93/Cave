package model;

/**
 * @author ThePirateCat
 */
public class ContainerBuilder {
    
    private RootNode root;

    public ContainerBuilder(RootNode node) {
        this.root = node;
    }

    public void build(String path) {
        generateHeaders();
        // Pre -> El tamaño del fichero es 0..Root->EndAddress() (en bytes)
        
        // Escribir root header
        // Iterar todos los nodos (deep) {
        //   Escribir cabecera de nodo
        //   Escribir contenido de nodo si fichero
        // }
    }

    private void generateHeaders() {
        long pointer = root.getNodeHeader().getHeaderSize();
        // wooops again, fail hard
        System.out.println("END BY NOW IS " + pointer);
        for (Node node : root.getList()) {
        }
    }
}
