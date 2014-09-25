/**
 * FILE: ID(1)+HEADERSIZE(4)+NAME(X)+ENDADDRESS(8)+RESERVED(8)
 */
package model;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ThePirateCat
 */
public class FileNodeHeader implements NodeHeader {

    private FileNode node;

    public FileNodeHeader(FileNode node) {
        this.node = node;
    }

    @Override
    public byte[] getAsArray() {
        int size = getHeaderSize();
        byte[] array = new byte[size];
        int pointer = 0;

        array[pointer++] = getNodeType().getID();

        for (int i = 1; i < 5; i++) {
            array[pointer++] = (byte) (size >>> 8 * (4 - i));
        }

        try {
            byte[] arrayName = node.getName().getBytes("utf-8");
            for (int i = 0; i < arrayName.length; i++) {
                array[pointer++] = arrayName[i];
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FileNodeHeader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        long endAddr = node.getEndAddress();
        for (int i = 1; i < 9; i++) {
            array[pointer++] = (byte) (endAddr >>> 8 * (8 - i));
        } 

        return array;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.File;
    }

    @Override
    public int getHeaderSize() {
        try {
            return 1 + 4 + node.getName().getBytes("utf-8").length + 8 + 8;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FileNodeHeader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }

}
