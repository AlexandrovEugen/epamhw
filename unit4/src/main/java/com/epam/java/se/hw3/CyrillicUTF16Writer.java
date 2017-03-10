package com.epam.java.se.hw3;


import java.util.Objects;

public class CyrillicUTF16Writer {

    private final StringBuilder utf8Text;

    public CyrillicUTF16Writer(CyrillicInUTF8Reader reader) {
        Objects.requireNonNull(reader);
        utf8Text = reader.getUtf8Text();
    }

    public void writeToFile() {

    }
}
