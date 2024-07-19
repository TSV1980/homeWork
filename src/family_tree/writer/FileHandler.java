package family_tree.writer;

import java.io.*;

public class FileHandler implements Writer  {

    private String filePath = "src/family_tree/writer.dat";

    /**
     * @param serializable
     */
    @Override
    public void save(Serializable serializable) {
        try ( ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
                objectOutputStream.writeObject(serializable);
            }
         catch (Exception e) {
             e.printStackTrace();
         }
    }

    /**
     * @return
     */
    @Override
    public Object read() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            Object obj = objectInputStream.readObject();
            return  obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    /**
     * @param path
     */
    @Override
    public void SetPath(String path) {
        filePath = path;
    }
}

