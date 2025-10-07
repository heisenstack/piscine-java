import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.List;

public class RegexReplace {

    public static String removeUnits(String s) {
        return s.replaceAll("(\\d+)(cm|€)(?=\\s|$)", "$1");
    }

    public static String obfuscateEmail(String s) {
        String[] parts = s.split("@");
        if (parts.length != 2) {
            return s; 
        }
        String username = parts[0];
        String domain = parts[1];

        String obfuscatedUsername;
        Pattern userPattern = Pattern.compile(".*[-._]");
        Matcher userMatcher = userPattern.matcher(username);
        if (userMatcher.find()) {
            int lastIndex = username.lastIndexOf(username.substring(userMatcher.end() - 1));
            System.out.println("Last Index: " + lastIndex);

            String prefix = username.substring(0, lastIndex + 1);
            System.out.println("Prefix: " + prefix);
            String suffix = username.substring(lastIndex + 1);
            System.out.println("Suffix: " + suffix);

            obfuscatedUsername = prefix + "*".repeat(suffix.length());
        } else if (username.length() > 3) {
            obfuscatedUsername = username.substring(0, 3) + "*".repeat(username.length() - 3);
        } else {
            obfuscatedUsername = username;
        }

        String obfuscatedDomain;
        String[] domainParts = domain.split("\\.");
        List<String> safeTlds = Arrays.asList("com", "org", "net");

        if (domainParts.length == 3) {
            obfuscatedDomain = "*".repeat(domainParts[0].length()) + "." + domainParts[1] + "." + "*".repeat(domainParts[2].length());
        } else if (domainParts.length == 2) {
            String second = "*".repeat(domainParts[0].length());
            String top = domainParts[1];
            if (!safeTlds.contains(top)) {
                top = "*".repeat(top.length());
            }
            obfuscatedDomain = second + "." + top;
        } else {
            obfuscatedDomain = "*".repeat(domain.length());
        }

        return obfuscatedUsername + "@" + obfuscatedDomain;
    }
}