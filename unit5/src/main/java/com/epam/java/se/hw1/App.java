package com.epam.java.se.hw1;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class App {

    private static String currentDir = "user.dir";

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Shell command line is greeting you!!!");
        System.out.println(System.getProperty(currentDir));
        boolean isRunning = true;
        while (isRunning){
            try {
                isRunning = handler(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean handler(String clientQuery){

        final List<String> parse = parse(clientQuery);
        final String command = getCommand(parse);
        boolean isRunning = true;

        switch (command){
            case "cd":{
                String directory = getFileOrDirName(parse);
                changeCurrentDirectory(directory);
            }
            break;

            case "mkdir":{
                String directory = getFileOrDirName(parse);
                mkdir(directory);
            }

            break;

            case "touch":{
                String fileName = getFileOrDirName(parse);
                touch(fileName);
            }

            break;

            case "rm":{
                String fileName = getFileOrDirName(parse);
                rm(fileName);
            }

            break;

            case "rmdir":{
                String directory = getFileOrDirName(parse);
                rmdir(directory);
            }

            break;

            case "ls":{
                showContent();
            }

            break;

            case "cat":{
                List<String> attributes = Arrays.stream(clientQuery.split(" ")).collect(Collectors.toList());
                cat(attributes);
            }

            break;

            case "help":{
                System.out.println(shellCommands());
            }

            break;

            case "exit":{
                isRunning  = false;
            }

            break;

            default:
                System.out.println("Unexpected command");
        }
        return isRunning;
    }

    private static void cat(List<String> attributes) {
        Objects.requireNonNull(attributes);

        if (attributes.get(1).equals(">")){
            writeToTheEndOfFile(attributes);
        }
        else if(attributes.get(1).equals(">>")){
            rewriteFile(attributes);
        }
        else {
            readFromFile(attributes);
        }
    }

    private static void readFromFile(List<String> attributes) {
        Path file = Paths.get(getFileOrDirName(attributes));
        try {
            Files.readAllLines(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToTheEndOfFile(List<String> attributes) {
        Path file = Paths.get(attributes.get(2)).toAbsolutePath();
        try {
            Files.write(file,attributes.stream().skip(3).collect(Collectors.toList()), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void rewriteFile(List<String> attributes) {
        Path file = Paths.get(attributes.get(2)).toAbsolutePath();
        try {
            Files.write(file, attributes.stream().skip(3).collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFileOrDirName(List<String> parse) {

        return parse.get(1);
    }

    private static String getCommand(List<String> parse) {
        return parse.get(0);
    }

    private static void mkdir(String directory) {
        Path file = Paths.get(directory).toAbsolutePath();
        try {
            Files.createDirectory(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void touch(String fileName) {
        Path file = Paths.get(fileName).toAbsolutePath();
        try {
            Files.createFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void rm(String fileName) {
        File file = new File(fileName).getAbsoluteFile();
        if (file.isFile()){
            boolean delete = file.delete();
            System.out.println(delete);
        }
    }

    private static void rmdir(String directory) {
        Path path = Paths.get(directory).toAbsolutePath();
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void changeCurrentDirectory(String directory) {
        Objects.requireNonNull(directory);
        switch (directory) {
            case " ":
                changeCurrentDirectory("C:\\Users\\Евгений\\IdeaProjects\\epamhw");
                break;
            case "..": {
                File file = new File(System.getProperty("user.dir"));
                String string = file.getParent();
                Objects.requireNonNull(string);
                changeCurrentDirectory(string);
                break;
            }
            default: {
                File file = new File(directory).getAbsoluteFile();
                if (file.exists()) {
                    boolean b = System.setProperty("user.dir", file.getAbsolutePath()) != null;
                    System.out.println(System.setProperty("user.dir", file.getAbsolutePath()));
                }
                currentDir = directory;
                break;
            }
        }
    }

    private static void showContent() {
        File file = new File(System.getProperty("user.dir"));
        changeCurrentDirectory(currentDir);
        File[] files = file.listFiles();
        if (files != null) {
            for (File aFile: files) {
                System.out.println(aFile.getName());
            }
        }
        else {
            throw new NullPointerException();
        }
    }

    private  static String shellCommands() {
        StringBuilder commands  = new StringBuilder();
        commands.append("cd: -- Change directory: cd directory_name").append("\n").
                 append("cd   -- Go to home directory: cd   ").append("\n").append("\n").
                 append("cd .. -- Go to parent directory: cd ..").append("\n").
                 append("mkdir -- Create new folder in current directory: mkdir directory_name").append("\n").
                 append("touch -- Create file in current directory: touch file_name").append("\n").
                 append("rm -- remove file form current directory: rm file_name").append("\n").
                 append("rmdir -- remove folder from current directory: rmdir directory_name").append("\n").
                 append("ls -- List information about current directory: ls").append("\n").
                 append("cat -- Read text from file: cat file_name").append("\n").
                 append("cat > -- Write to the end of file: cat > file_name").append("\n").
                 append("cat >> -- Rewrite file: cat >>  file_name").append("\n").
                 append("exit");
        return commands.toString();
    }

    private  static List<String> parse(String clientQuery) {
        Objects.requireNonNull(clientQuery);
        List<String> strings = Arrays.asList(clientQuery.split(" "));
        if (strings.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return strings;
    }
}
