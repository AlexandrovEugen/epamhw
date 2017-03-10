package com.epam.java.se.hw3;


import java.io.*;
import java.nio.charset.Charset;
import java.util.Objects;

public class CyrillicInUTF8Reader {
    private final String fileName;
    private final StringBuilder utf8Text;
    private Charset utf8 = Charset.forName("utf-8");

    public CyrillicInUTF8Reader(String fileName) {
        Objects.requireNonNull(fileName);
        this.fileName = fileName;
        utf8Text = new StringBuilder();
    }

    public void utf8Read(){

        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), utf8))) {
            while (br.ready()){
//                byte[] biteLine = br.readLine().getBytes();
//                String stringLine = new String(biteLine, utf8);
//                utf8Text.append(stringLine).append("\\n");
                utf8Text.append(br.readLine()).append("\n");
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
