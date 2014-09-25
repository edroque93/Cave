/**
 * TO-DO: rootnode is actually a foldernode in disguise ROOT/FOLDER:
 * ID(1)+HEADERSIZE(4)+NAMELENGTH(4)+NAME(X)+LISTOFSTARTADDRESS(8/ea)+RESERVED(8)
 * FILE: ID(1)+HEADERSIZE(4)+NAME(X)+ENDADDRESS(8)+RESERVED(8)
 */
package model;

/**
 * @author ThePirateCat
 */
public class RootNodeHeader implements NodeHeader {

    private RootNode node;

    public RootNodeHeader(RootNode node) {
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

        byte[] arrayName = node.getName().getBytes();
        
        for (int i = 1; i < 5; i++) {
            array[pointer++] = (byte) (arrayName.length >>> 8 * (4 - i));
        }
        
        for (int i = 0; i < arrayName.length; i++) {
            array[pointer++] = arrayName[i];
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
        return NodeType.Root;
    }

    @Override
    public int getHeaderSize() { // FIX THIS SHIT
        return 1 + 4 + node.getList().size() * 8 + 8;
    }

}
