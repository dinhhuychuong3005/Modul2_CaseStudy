package Filecsv;
import java.io.IOException;
import java.util.List;

public interface WriteReadFile <T>{
    void writeToFile(String path, List<T> list) throws IOException;

    List<T> readFromFile(String path) throws IOException;

}
