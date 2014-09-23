package cave;

import model.FileHolder;

/**
 * @author Enrique
 */
public class Cave {

    public static void main(String[] args) throws Exception {
        FileHolder test = new FileHolder("D:\\c.avi");
        test.loadIntoMem();
    }
    
}
