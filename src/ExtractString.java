
import javax.xml.bind.JAXBContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractString {

    public static void extractString() {
        Path path = Paths.get("data/string");
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        Map<String, Integer> map = new HashMap<>();
        try {
            List<String> allLines = Files.readAllLines(path);
            Pattern pattern = Pattern.compile("\\\"adId\\\":\\\"\\d+\\\"");

            outer:
            for (String line : allLines) {
                Matcher matcher = pattern.matcher(line);
                if (line.length() < 10) continue;
                //System.out.println(matcher.find(0));
                while (matcher.find()) {
                    String string = matcher.group(0);
                    System.out.println("found: " + matcher.group(0));

                    String[] strings = string.split(":");
                    String key = strings[1].trim();
                    map.put(key, map.getOrDefault(key, 0) + 1);
                    continue outer;
                }
                System.out.print("\n");
            }
            System.out.println(map);
            for(Map.Entry entry: map.entrySet()) {
                System.out.println(entry.getKey().toString().replace("\"", "") +" : "+ entry.getValue());
            }
            for(Map.Entry entry: map.entrySet()) {
                System.out.println( entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
