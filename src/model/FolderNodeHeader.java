/**
 * ID(1)+HEADERSIZE(4)+NAMELENGTH(4)+NAME(X)+LISTOFSTARTADDRESS(8/ea)+RESERVED(8)
 */
package model;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ThePirateCat
 */
public class FolderNodeHeader implements NodeHeader {

    private final FolderNode node;

    public FolderNodeHeader(FolderNode node) {
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

            for (int i = 1; i < 5; i++) {
                array[pointer++] = (byte) (arrayName.length >>> 8 * (4 - i));
            }

            for (int i = 0; i < arrayName.length; i++) {
                array[pointer++] = arrayName[i];
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(RootNodeHeader.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Node node : node.getList()) {
            long addr = node.getStartAddress();

            int maxPointer = pointer + 8;
            int offset = 1;
            for (; pointer < maxPointer; pointer++) {
                array[pointer] = (byte) (addr >>> 8 * (8 - offset++));
            }
        }

        return array;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.Folder;
    }

    @Override
    public int getHeaderSize() {
        try {
            return 1 + 4 + 4 + node.getName().getBytes("utf-8").length + node.getList().size() * 8 + 8;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(RootNodeHeader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

}
