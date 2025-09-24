import java.io.*;

public class CatInFile {

    public static void cat(String[] args) throws IOException {
        if (args == null || args.length < 1) {
            System.out.println("Error");
            
        }

        String filePath = args[0];

 
        try (InputStream inputStream = new BufferedInputStream(System.in);
             OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath))) {

            byte[] buffer = new byte[8192]; 
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }
}
