/**
 * TO-DO: rootnode is actually a foldernode in disguise
 * ROOT/FOLDER: ID(1)+HEADERSIZE(4)+LISTOFSTARTADDRESS(8/ea)+RESERVED(8)
 * FILE:        ID(1)+HEADERSIZE(4)+NAME(X)+RESERVED(8)
 */
package model;

/**
 * @author ThePirateCat
 */
public class RootNodeHeader implements NodeHeader {

    private final long size;

    public RootNodeHeader(long size) {
        this.size = size;
    }

    @Override
    public byte[] getAsArray() {
        byte[] array = new byte[getHeaderSize()];
        array[0] = getNodeType().getID();

        for (int i = 1; i < getHeaderSize(); i++) {
            array[i] = (byte) (size >>> 8 * (8 - i));
        }

        return array;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.Root;
    }

    @Override
    public int getHeaderSize() {
        // ID + SIZE
        return 1 + 8;
    }

}
