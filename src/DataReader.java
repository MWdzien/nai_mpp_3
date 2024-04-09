import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    public static List<DataEntry> readFile(String path){
        List<DataEntry> inputs = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));

            String line;
            while ((line = br.readLine()) != null) {
                line = line.replaceAll(",", ".").replaceAll(" ", "");

                String[] data = line.split("\t");
                Double[] attributes = new Double[data.length-1];
                for (int i = 0; i < attributes.length; i++) {
                    attributes[i] = Double.parseDouble(data[i]);
                }

                DataEntry entry = new DataEntry(data[data.length-1], attributes);

                inputs.add(entry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputs;
    }
}
