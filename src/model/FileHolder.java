package model;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author ThePirateCat
 */
public class FileHolder {

    private final String fileName;
    private final int CHUNK_SIZE = 4096;

    public FileHolder(String fileName) throws Exception {
        this.fileName = fileName;
        
//        RandomAccessFile file = new RandomAccessFile(fileName, "r");
//        FileChannel channel = file.getChannel();
//        ByteBuffer buffer = ByteBuffer.allocate(CHUNK_SIZE);
//        
//        while (channel.read(buffer) > 0) {
//            buffer.flip();
//            
//            for (int i = 0; i < buffer.limit(); i++) {
//                               
//            }
//            
//            buffer.clear();
//        }
//        file.close();
    }

    public void loadIntoMem() {
    }
}
