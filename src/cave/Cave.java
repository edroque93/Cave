package cave;

import model.RootNodeHeader;

/**
 * @author Enrique
 */
public class Cave {

    public static void main(String[] args) throws Exception {
        RootNodeHeader root = new RootNodeHeader(256);
        
        for (int i = 0; i < root.getAsArray().length; i++) {
            System.out.print(root.getAsArray()[i] + ",");
        }
        
        System.out.println("");
    }

}
