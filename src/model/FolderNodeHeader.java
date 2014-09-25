package model;

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
        array[0] = getNodeType().getID();

        for (int i = 1; i < 5; i++) {
            array[i] = (byte) (size >>> 8 * (8 - i));
        }

        int pointer = 5;

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
    public int getHeaderSize() {
        return 1 + 4 + node.getList().size() * 8 + 8;
    }

}
