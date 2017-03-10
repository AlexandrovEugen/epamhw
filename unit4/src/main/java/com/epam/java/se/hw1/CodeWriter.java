package com.epam.java.se.hw1;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class CodeWriter {

    private final ResourceBundle keyWordsFromProperties;
    private final StringBuilder bitesToString;
    private final Map<String, Integer> keyWords;

    public CodeWriter(CodeReader reader) {
        Objects.requireNonNull(reader);
        bitesToString = reader.getBitesToString();
        keyWordsFromProperties = ResourceBundle.getBundle("keyWords");
        keyWords = new HashMap<>();

        fillMapFromResourceBundle();
    }

    public Map<String, Integer> getKeyWords() {
        findAndCountKeyWords();
        return keyWords.entrySet().stream().filter(o -> o.getValue() > 0).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private void fillMapFromResourceBundle(){
        for (String keyWord: keyWordsFromProperties.keySet()) {
            keyWords.put(keyWord, Integer.parseInt(keyWordsFromProperties.getString(keyWord)));
        }
    }

    private void findAndCountKeyWords(){
        String[] splitByWords = bitesToString.toString().split("\\s+");
        for (String word: splitByWords) {
            String changed = word.replaceAll("[}|{|)|(|;|,|.]+", "");
            if (keyWordsFromProperties.containsKey(changed)){
                keyWords.computeIfPresent(changed, (k, v) -> v + 1);
            }
        }
    }

    public void ouputFile(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            Map<String, Integer> keyWords = getKeyWords();
            for (String keyWord: keyWords.keySet()) {
                bw.write(keyWord + " = " + keyWords.get(keyWord) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
