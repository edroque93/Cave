package model;

/**
 * @author ThePirateCat
 */
public enum NodeType {
    Root((byte) 0),
    Folder((byte) 1),
    File((byte) 2);
    
    private final byte id;
    
    private NodeType(byte id) {
        this.id = id;
    }
    
    public byte getID() {
        return id;
    }
}
