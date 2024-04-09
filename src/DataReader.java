import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    public static DataEntry readLanguageFile(File file, String language){
        double[] lettersProportions = new double[26];
        StringBuilder sb = new StringBuilder();
        String formattedText = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            while ((line = br.readLine()) != null){
                line = line.toLowerCase().replaceAll("[^a-z]", "");
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        formattedText = sb.toString();

        for (char i = 'a'; i < 'z' + 1; i++) {
            int index = i - 'a';
            lettersProportions[index] = 0.0;

            for (int j = 0; j < formattedText.length(); j++) {
                if (formattedText.charAt(j) == i){
                    lettersProportions[index]++;
                }
            }
            lettersProportions[index] /= formattedText.length();
        }

         return new DataEntry(language, lettersProportions);
    }


    public static List<DataEntry> readFile(String path){
        List<DataEntry> inputs = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));

            String line;
            while ((line = br.readLine()) != null) {
                line = line.replaceAll(",", ".").replaceAll(" ", "");

                String[] data = line.split("\t");
                double[] attributes = new double[data.length-1];
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
