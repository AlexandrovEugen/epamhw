package com.epam.java.se.hw2;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;


public class QuizTest {


    @Test
    public void testThatMethodGetLanguageWorksRight(){
        Quiz quiz = new Quiz();
        quiz.setLocale("ru");
        Locale locale = new Locale("ru");
        assertEquals(locale, quiz.getLocale());
    }

    @Test
    public void testThatConversationIsGoingOnChosenLanguage(){
        Quiz quiz = new Quiz();
        quiz.setLocale("ru");
        ResourceBundle ruQuestions = ResourceBundle.getBundle("questions", quiz.getLocale());
        assertEquals(ruQuestions, quiz.getQuestions());
    }

    @Test
    public void testThatQuestionsAndAnswersAreLoadedCorrectly(){
        Quiz quiz = new Quiz();
        quiz.setLocale("ru");
        assertEquals("Столица Турции?",quiz.getQuestions().getString("question1"));
        assertEquals("Анкара",quiz.getAnswers().getString("answer1"));
    }
}