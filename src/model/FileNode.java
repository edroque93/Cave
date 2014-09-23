package model;

/**
 * @author ThePirateCat
 */
public class FileNode implements Node {

    private String nodeName;
    private final long startAddress;
    private final long endAddress;

    public FileNode(String name, long startAddress, long endAddress) {
        this.nodeName = name;
        this.startAddress = startAddress;
        this.endAddress = endAddress;
    }

    @Override
    public String getName() {
        return nodeName;
    }

    @Override
    public long getStartAddress() {
        return startAddress;
    }

    @Override
    public long getEndAddress() {
        return endAddress;
    }
}
