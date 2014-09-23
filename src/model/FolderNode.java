package model;

import java.util.List;

/**
 * @author ThePirateCat
 */
public class FolderNode implements Node {

    private String nodeName;
    private List<Node> list;
    private final long startAddress;

    public FolderNode(String name, long startAddress) {
        this.nodeName = name;
        this.startAddress = startAddress;
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
}
