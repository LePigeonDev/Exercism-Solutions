public class LogLine {

    private final String logLine;

    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    public LogLevel getLogLevel() {

            switch (getParseLog(logLine)) {
                case "TRC":
                    return LogLevel.TRACE;
                case "DBG":
                    return LogLevel.DEBUG;
                case "INF":
                    return LogLevel.INFO;
                case "WRN":
                    return LogLevel.WARNING;
                case "ERR":
                    return LogLevel.ERROR;
                case "FTL":
                    return LogLevel.FATAL;
                default:
                    return LogLevel.UNKNOWN;
        }
    }

    public String getOutputForShortLog() {
        int shortLog = 0;
            switch (getParseLog(logLine)) {
                case "TRC":
                    shortLog = 1;
                    break;
                case "DBG":
                    shortLog = 2;
                    break;
                case "INF":
                    shortLog = 4;
                    break;
                case "WRN":
                    shortLog = 5;
                    break;
                case "ERR":
                    shortLog = 6;
                    break;
                case "FTL":
                    shortLog = 42;
                    break;
                default:
                    shortLog = 0;

        }
        return shortLog + ":" + logLine.substring(6).trim();
    }

    public String getParseLog(String logLine) {
        int start = logLine.indexOf('[');
        int end = logLine.indexOf(']');

        return logLine.substring(start + 1, end);
    }
}
