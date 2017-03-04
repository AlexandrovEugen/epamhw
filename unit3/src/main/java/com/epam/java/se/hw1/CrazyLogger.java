package com.epam.java.se.hw1;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class CrazyLogger {

    private final String toFormat = "dd-mm-YYYY : hh-mm";
    private final String name;
    private StringBuilder logBuilder;

    public CrazyLogger(String name) {
        this.name = name;

        logBuilder = new StringBuilder();
        logBuilder.append(Level.INFO.toString()).append(":").append(name).append(":").append("has been initialized at").
                append(LocalDateTime.now().format(DateTimeFormatter.ofPattern(toFormat))).append("\n");
    }

    public void log(String msg){

        Objects.requireNonNull(msg, "Error: message parameter can't be a null");
        logBuilder.append(name).append(":").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern(toFormat))).append(":").append(msg).append("\n");
    }

    public void log(Level level, String msg){
        Objects.requireNonNull(level, "Error: level parameter can't be a null");

        logBuilder.append(level.toString()).append(":").append(name).append(":").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern(toFormat))).
                append(" : ").append(msg).append("\n");
    }

    public void log(String msg, Throwable e) {
        Objects.requireNonNull(msg, "Error: parameter - message can't be a null");
        Objects.requireNonNull(e, "Error: parameter - exception can't be a null");

        logBuilder.append(Level.WARNING.toString()).append(":").append(name).append(":").append(LocalDateTime.now().
                format(DateTimeFormatter.ofPattern(toFormat))).append(":").append(msg).append(":").append(e).append("\n");
    }

    public String findByMsg(String msg){
        String log;
        String[] split = logBuilder.toString().split("\\n");
        for (String aSplit : split) {
            log = aSplit;
            String[] str = log.split(":");
            if (str[str.length - 1].equals(msg)) {
                return log;
            } else if (str[str.length - 2].equals(msg)) {
                return log;
            }
        }
        return "This log doesn't exists";
    }

    public String info(){
        return logBuilder.toString();
    }
    /**
     * types of logging
     */
    enum Level{

        INFO("INFO"), WARNING("WARNING");

        private final String levelName;

        Level(String name) {
            this.levelName = name;
        }

        @Override
        public String toString(){
            return levelName;
        }
    }
}
