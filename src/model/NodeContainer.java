package model;

import java.util.List;

/**
 * @author ThePirateCat
 */
interface NodeContainer extends Node {
    
    public List<Node> getList();
    
    public void addNode(Node node);
    
}
