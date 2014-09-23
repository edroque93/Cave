package model;

import java.util.List;

/**
 * @author ThePirateCat
 */
public class RootNode implements Node {

    private final String nodeName = "Root";
    private List<Node> list;
    private final long startAddress = 0;

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
    
}
