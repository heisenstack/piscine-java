import java.io.File;

public class FileSearch {

    public static String searchFile(String fileName) {
        File startDirectory = new File("documents");
        return findTheFile(startDirectory, fileName);
    }

    private static String findTheFile(File currentDir, String fileNameToFind) {
        File[] entries = currentDir.listFiles();

        if (entries != null) {
            for (File entry : entries) {
                if (entry.isDirectory()) {
                    String result = findTheFile(entry, fileNameToFind);
                    if (result != null) {
                        return result;
                    }
                } else {
                    if (entry.getName().equals(fileNameToFind)) {
                        return entry.getPath().replace(File.separator, "/");
                    }
                }
            }
        }
        return null;
    }
}
