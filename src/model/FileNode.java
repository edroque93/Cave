package model;

/**
 * @author ThePirateCat
 */
public class FileNode implements Node {

    private String nodeName;
    private final long startAddress;
    private final long endAddress;
    private NodeHeader header;

    public FileNode(String name, long startAddress, long endAddress) {
        this.nodeName = name;
        this.startAddress = startAddress;
        header = new FileNodeHeader(this);
        this.endAddress = endAddress + header.getHeaderSize();
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
        return endAddress + header.getHeaderSize();
    }

    @Override
    public NodeHeader getNodeHeader() {
        return header;
    }

}
