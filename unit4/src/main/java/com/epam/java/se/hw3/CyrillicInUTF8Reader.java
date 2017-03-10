package com.epam.java.se.hw3;


import java.io.*;

public class CyrillicInUTF8Reader {
    private final String fileName;

    private final StringBuilder utf8Text;

    public CyrillicInUTF8Reader(String fileName) {
        this.fileName = fileName;
        utf8Text = new StringBuilder();
    }

    public void utf8Read(){

        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
            while (br.ready()){
                utf8Text.append(br.readLine());
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public StringBuilder getUtf8Text() {
        return utf8Text;
    }
}
