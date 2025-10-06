import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogLevels {
    
    public static String message(String logLine) {
        return logLine.replaceAll("\\[.*?\\:", "").trim();
    }

    public static String logLevel(String logLine) {
        return getBetweenRegex(logLine, "\\[(.*?)\\]");
    }

    public static String reformat(String logLine) {
        String brackets = logLevel(logLine);
        String info = message(logLine);
        return info + " (" + brackets + ")";
    }

    private static String getBetweenRegex(String logLine, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(logLine);
        if(matcher.find()) {
            return matcher.group(1).toLowerCase();
        }
        return null;
    }
}
