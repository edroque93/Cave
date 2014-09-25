package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ThePirateCat
 */
public class FolderNode implements NodeContainer {

    private String nodeName;
    private List<Node> list;
    private final long startAddress;
    private final FolderNodeHeader header;

    public FolderNode(String name, long startAddress) {
        this.nodeName = name;
        this.startAddress = startAddress;

        list = new ArrayList<>();
        header = new FolderNodeHeader(this);
    }

    @Override
    public void addNode(Node node) {
        list.add(node);
    }

    @Override
    public List<Node> getList() {
        return list;
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
        long nodeSize = 0;

        for (Node node : list) {
            nodeSize += node.getEndAddress() - node.getStartAddress();
        }
        return startAddress + nodeSize + header.getHeaderSize();
    }

    @Override
    public NodeHeader getNodeHeader() {
        return header;
    }

}
