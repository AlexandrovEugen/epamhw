package com.epam.java.se.hw3;


import java.io.*;
import java.util.Objects;

public class CyrillicInUTF8Reader {
    private final String fileName;

    private final StringBuilder utf8Text;

    public CyrillicInUTF8Reader(String fileName) {
        Objects.requireNonNull(fileName);
        this.fileName = fileName;
        utf8Text = new StringBuilder();
    }

    public void utf8Read(){

        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            while (br.ready()){
                byte[] biteLine = br.readLine().getBytes();
                String stringLine = new String(biteLine, "UTF-8");
                utf8Text.append(stringLine).append("\\n");
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
