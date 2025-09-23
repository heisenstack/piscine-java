public class CleanExtract {
    public static String extract(String s) {
        String[] parts = s.split("\\|");
        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            part = part.trim(); 
            int firstpoint = part.indexOf('.');
            // System.out.println("first dot: " + firstpoint);
            int lastpoint = part.lastIndexOf('.');
            // System.out.println("SECOND dot: " + lastpoint);

            String temp = "";

            if (firstpoint != -1 && lastpoint != -1 && firstpoint < lastpoint) {
                
                temp = part.substring(firstpoint + 1, lastpoint).trim();
            } else if (firstpoint != -1) {
                
                temp = part.substring(firstpoint + 1).trim();
            } else if (firstpoint == -1 && lastpoint == -1) {
                
                temp = part;
            } else {
                
                temp = part.trim();
            }

            if (!temp.isEmpty()) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(temp);
            }
        }

        return result.toString();
    }
}