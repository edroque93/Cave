package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ThePirateCat
 */
public class FolderNode implements Node {

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

    public List<Node> getList() {
        return list;
    }

    public void addNode(Node node) {
        list.add(node);
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
        long nodeSize = 0;

        for (Node node : list) {
            nodeSize += node.getEndAddress() - node.getStartAddress();
        }
        return startAddress + nodeSize;
    }

    @Override
    public NodeHeader getNodeHeader() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
