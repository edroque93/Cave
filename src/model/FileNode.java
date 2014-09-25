package model;

/**
 * @author ThePirateCat
 */
public class FileNode implements Node {

    private String nodeName;
    private long startAddress;
    private long size;
    private NodeHeader header;

    public FileNode(String name, long size) {
        this.nodeName = name;
        this.size = size;

        header = new FileNodeHeader(this);
    }

    @Override
    public String getName() {
        return nodeName;
    }

    @Override
    public void setName(String newName) {
        nodeName = newName;
    }

    @Override
    public long getStartAddress() {
        return startAddress;
    }

    @Override
    public long getEndAddress() {
        return startAddress + size + header.getHeaderSize();
    }

    @Override
    public NodeHeader getNodeHeader() {
        return header;
    }

    @Override
    public void setStartAddress(long startAddress) {
        this.startAddress = startAddress;
    }

}
