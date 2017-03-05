package com.epam.java.se.hw2;


import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class Quiz {

    private Locale locale;
    private ResourceBundle questions;
    private ResourceBundle answers;
    private ResourceBundle conversation;
    private Enumeration conKeys;
    private Enumeration queKeys;
    private Enumeration ansKeys;

    public void setLocale(String locale) {
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

//    public void play(){
//
//        System.out.println("Please select language");
//        System.out.println("1 : English");
//        System.out.println("2 : Russian");
//        final Scanner s = new Scanner(System.in);
//
//        if (s.hasNextInt()){
//            int i = s.nextInt();
//            if (i == 1){
//                setLocale("en");
//            }
//            else if (i == 2){
//                setLocale("ru");
//            }
//            else {
//                System.out.println("Incorrect input");
//                System.exit(0);
//            }
//        }
//        loadConversation();
//        loadQuestions();
//        loadAnswers();
//
//        while (true){
//
//            if (conKeys.hasMoreElements()){
//                System.out.println(conKeys.nextElement());
//            }
//            if (queKeys.hasMoreElements()){
//                System.out.println(queKeys.nextElement());
//                if (s.hasNext()){
//                    if (answers.containsKey()){
//                        System.out.println(conversation.);
//                    }
//                }
//            }
//            if (ansKeys.hasMoreElements()){
//                System.out.println(ansKeys.hasMoreElements());
//            }
//        }
//    }

    private void loadConversation(){
        if (locale.getLanguage().equals("ru")){
            conversation = ResourceBundle.getBundle("reConversation", locale);
        }
        else {
            conversation = ResourceBundle.getBundle("enConversation", locale);
        }
        this.conKeys = conversation.getKeys();
    }

    private void loadQuestions(){
        if (locale.getLanguage().equals("ru")){
            questions = ResourceBundle.getBundle("ruQuestions", locale);
        }
        else {
            questions = ResourceBundle.getBundle("enQuestions", locale);
        }
        this.queKeys = questions.getKeys();
    }

    private void loadAnswers(){

        if (locale.getLanguage().equals("ru")){
            answers = ResourceBundle.getBundle("ruAnswers", locale);
        }
        else {
            answers = ResourceBundle.getBundle("enAnswers", locale);
        }
        this.ansKeys = answers.getKeys();
    }

    private String takeQuestion(String key){
        return  questions.getString(key);
    }

    private String getAnswer(String key){
        return answers.getString(key);
    }
}

