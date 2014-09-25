package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ThePirateCat
 */
public class RootNode implements Node {

    private final String nodeName = "Root";
    private final long startAddress = 0;
    private List<Node> list;
    private NodeHeader header;

    public RootNode() {
        list = new ArrayList<>();
        header = new RootNodeHeader(this);
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
        return nodeSize;
    }

    @Override
    public NodeHeader getNodeHeader() {
        return header;
    }

}
