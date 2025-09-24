import java.io.*;

public class Cat {
    public static void cat(String[] args) throws IOException {
        if (args.length == 0) {
            return; 
        }

        String filename = args[0];
        try (InputStream in = new FileInputStream(filename)) {
            byte[] buffer = new byte[4096]; 
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                System.out.write(buffer, 0, bytesRead);
            }
        }
    }
}