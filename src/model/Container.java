package model;

import java.util.List;
import java.util.Stack;

/**
 * @author ThePirateCat
 */
public class Container {

    private RootNode root;
    private Stack<NodeContainer> pwd;

    public Container() {
        root = new RootNode();
        pwd = new Stack<>();
        pwd.push(root);
    }

    public String getCurrentPath() {
        String path = "";

        for (Node node : pwd) {
            path += node.getName() + "/";
        }

        return path;
    }

    public Node[] getNodes() {
        NodeContainer last = pwd.get(pwd.size() - 1);
        List<Node> nodes = last.getList();

        Node[] list = new Node[nodes.size()];

        int pointer = 0;

        for (Node node : nodes) {
            list[pointer++] = node;
        }

        return list;
    }

    public String[] getNodeNames() {
        Node[] nodes = getNodes();
        String[] names = new String[nodes.length];

        int pointer = 0;

        for (Node node : nodes) {
            names[pointer++] = node.getName();
        }

        return names;
    }

    public void addFile(String path) {
        // Actual path
    }

    public void addFolder(String folderName) {
        NodeContainer last = pwd.get(pwd.size() - 1);
        FolderNode folder = new FolderNode(folderName, last.getEndAddress() + 8 + 1);
        last.addNode(folder);
    }

    public boolean changeDirectory(String folder) {
        if (pwd.size() > 1 && folder.equals("..")) {
            pwd.pop();
        }

        Node[] nodes = getNodes();

        for (Node node : nodes) {
            if ((node instanceof NodeContainer) && folder.equals(node.getName())) {
                pwd.push((NodeContainer) node);
                return true;
            }
        }

        return false;
    }

    public boolean rename(String oldName, String newName) {
        NodeContainer last = pwd.get(pwd.size() - 1);

        for (Node node : last.getList()) {
            if (oldName.toLowerCase().equals(node.getName().toLowerCase())) {
                node.setName(newName);
                return true;
            }
        }

        return false;
    }

    public void debug() {
        for (int i = 0; i < root.getNodeHeader().getAsArray().length; i++) {
            System.out.print((root.getNodeHeader().getAsArray()[i] & 0xFF) + ",");
        }
    }
}
