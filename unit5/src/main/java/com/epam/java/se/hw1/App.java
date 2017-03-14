package com.epam.java.se.hw1;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class App {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isRunning = true;
        System.out.println("Shell command line is greeting you!!!");
        System.out.println(System.getProperty("user.dir"));
        while (isRunning){
            try {
                isRunning = handler(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean handler(String clientQuery){

        boolean isRunning = true;

        List<String> parse = parse(clientQuery);
        String command = parse.get(0);
        switch (command){
            case "cd":{
                String directory = parse.get(1);
                File file = new File(directory).getAbsoluteFile();
                if (file.exists() || file.mkdir()){
                    boolean result;
                    result = System.setProperty("user.dir", file.getAbsolutePath()) != null;
                    System.out.println(System.setProperty("user.dir", file.getAbsolutePath()));
                }
            }

            break;

            case "mkdir":{
                String directory = parse.get(1);
            }

            break;

            case "touch":{
                String fileName = parse.get(1);
            }

            break;

            case "rm":{
                String name = parse.get(1);
            }

            break;

            case "rmdir":{
                String name = parse.get(1);
            }

            break;

            case "ls":{
                showContent();
            }

            break;

            case "echo":{

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

    private static void showContent() {
    }

    private  static String shellCommands() {
        StringBuilder commands  = new StringBuilder();
        commands.append("cd: -- Change directory: cd directory_name").append("\n").
                 append("mkdir -- Create new folder in current directory: mkdir directory_name").append("\n").
                 append("touch -- Create file in current directory: touch file_name").append("\n").
                 append("rm -- remove file form current directory: rm file_name").append("\n").
                 append("rmdir -- remove folder from current directory: rmdir directory_name").append("\n").
                 append("ls -- List information about current directory: ls").append("\n").
                 append("echo -- Write to the file file_name message").append("\n").
                 append("exit");
        return commands.toString();
    }

    private  static List<String> parse(String clientQuery) {
        Objects.requireNonNull(clientQuery);
        return Arrays.asList(clientQuery.split(" "));
    }
}
