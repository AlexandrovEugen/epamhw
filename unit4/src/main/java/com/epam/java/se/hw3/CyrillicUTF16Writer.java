package com.epam.java.se.hw3;


import java.io.*;
import java.util.Objects;

public class CyrillicUTF16Writer {

    private final StringBuilder utf8Text;

    public CyrillicUTF16Writer(CyrillicInUTF8Reader reader) {
        Objects.requireNonNull(reader);
        utf8Text = reader.getUtf8Text();
    }

    public void writeToFile() {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("UTF-16Output.txt")))) {
            for (String line: utf8Text.toString().split("\n")) {
                byte[] bytes = line.getBytes();
                bw.write(new String(bytes, "UTF-16"));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
