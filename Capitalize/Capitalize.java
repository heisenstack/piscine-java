import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileWriter;


public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
            if (args.length == 0) return;

            byte[] cont = Files.readAllBytes(Paths.get(args[0]));
            var str = new String(cont).split(" ");
            String capstr;
            if (str == null || str.length == 0) capstr = "";
            else {
                String[] res = new String[str.length];
                int i = 0;
                for (String elem : str) {
                    if (elem.isEmpty() || elem == null) {
                        res[i] = " ";
                        i++;
                        continue;
                    }
                    String firstL = elem.substring(0, 1).toUpperCase();
                    String scendstr = elem.substring(1).toLowerCase();
                    res[i] = (firstL + scendstr);
                    i++;
                }
                capstr = String.join(" ", res).trim();
            }
            try (FileWriter W = new FileWriter(args[1])) {
                W.write(capstr.replaceAll("\s+", " "));
                W.close();
            }

        }
}