package com.epam.java.se.hw3;


import java.io.*;
import java.nio.charset.Charset;
import java.util.Objects;

public class CyrillicUTF16Writer {

    private final StringBuilder utf8Text;
    private Charset utf16 = Charset.forName("utf-16");

    public CyrillicUTF16Writer(CyrillicInUTF8Reader reader) {
        Objects.requireNonNull(reader);
        utf8Text = reader.getUtf8Text();
    }

    public void writeToFile() {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("UTF-16Output.txt"), utf16))) {
            for (String line: utf8Text.toString().split("\n")) {
//                byte[] bytes = line.getBytes();
//                bw.write(new String(bytes, utf16));
                bw.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
