import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    public static DataEntry readLanguageFile(File file, String language){
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

        return new DataEntry(language, calculateLetterProportions(formattedText));
    }

    public static DataEntry readText(String text){
        String formattedText = text.toLowerCase().replaceAll("[^a-z]", "");

        return new DataEntry("empty", calculateLetterProportions(formattedText));
    }

    private static double[] calculateLetterProportions(String formattedText) {
        double[] lettersProportions = new double[26];
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
        return lettersProportions;
    }
}
