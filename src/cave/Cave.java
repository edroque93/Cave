package cave;

import model.FileNode;

/**
 * @author Enrique
 */
public class Cave {

    public static void main(String[] args) throws Exception {
        FileNode file = new FileNode("pepe.txt", 100, 109);

        for (int i = 0; i < file.getNodeHeader().getAsArray().length; i++) {
            System.out.print((file.getNodeHeader().getAsArray()[i] & 0xFF) + ",");
        }

        System.out.println("");
    }

}
