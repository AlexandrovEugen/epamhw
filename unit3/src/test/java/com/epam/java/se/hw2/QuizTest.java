package com.epam.java.se.hw2;

import org.junit.Test;

import java.util.Locale;
import java.util.MissingResourceException;
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
        ResourceBundle ruQuestions = ResourceBundle.getBundle("ruQuestions" , quiz.getLocale());
        assertEquals(ruQuestions, quiz.getQuestions());
    }

    @Test(expected = MissingResourceException.class)
    public void testThatQuizWillHasFailedWithIncorrectInput(){
        Quiz quiz = new Quiz();
        quiz.setLocale("fr");
        quiz.getQuestions();
    }
}