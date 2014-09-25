package cave;

import model.Container;
import model.FileNode;
import model.FolderNode;
import model.RootNode;

/**
 * @author Enrique
 */
public class Cave {

    public static void main(String[] args) throws Exception {
        Container c = new Container();
        c.addFolder("Textos");
        c.addFolder("Imágenes");
        
        c.debug();
        
//        /*
//        Example:
//        
//        \
//            Textos\
//                pepe.txt
//                pepa.txt
//        
//        
//        */
//        RootNode root = new RootNode();
//        FolderNode folder = new FolderNode("Textos", root.getEndAddress()+8+1);
//        FileNode file = new FileNode("pepe.txt", folder.getEndAddress()+8+1, folder.getEndAddress()+8+1+10);
//        folder.addNode(file);
//        FileNode file2 = new FileNode("pepa.txt", folder.getEndAddress()+8+1, folder.getEndAddress()+8+1+10);
//        folder.addNode(file2);
//        
//        root.addNode(folder);
//
//        for (int i = 0; i < file2.getNodeHeader().getAsArray().length; i++) {
//            System.out.print((file2.getNodeHeader().getAsArray()[i] & 0xFF) + ",");
//        }
//
//        System.out.println("");
    }

}
