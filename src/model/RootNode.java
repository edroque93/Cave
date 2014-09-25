package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ThePirateCat
 */
public class RootNode implements NodeContainer {

    private String nodeName = "Root";
    private final long startAddress = 0;
    private List<Node> list;
    private NodeHeader header;

    public RootNode() {
        list = new ArrayList<>();
        header = new RootNodeHeader(this);
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
        return nodeSize + header.getHeaderSize();
    }

    @Override
    public NodeHeader getNodeHeader() {
        return header;
    }

}
