package com.epam.java.se.hw2;


import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class Quiz {

    private Locale locale;
    private ResourceBundle questions;
    private ResourceBundle answers;
    private ResourceBundle conversation;
    private Enumeration queKeys;
    private Enumeration ansKeys;

    public void setLocale(String locale){
        this.locale = new Locale(locale);
    }

    public Locale getLocale() {
        if (this.locale == null){
            this.locale = new Locale("en");
        }
        return locale;
    }

    public ResourceBundle getQuestions() {
        loadQuestions();
        return questions;
    }

    public ResourceBundle getAnswers() {
        loadAnswers();
        return answers;
    }

    private void loadQuestions(){
        questions = ResourceBundle.getBundle("questions", locale);
        this.queKeys = questions.getKeys();
    }

    private void loadAnswers(){
        answers = ResourceBundle.getBundle("answers", locale);
        this.ansKeys = answers.getKeys();
    }

    private String takeQuestion(String key){
        return  questions.getString(key);
    }

    private String getAnswer(String key){
        return answers.getString(key);
    }
}

