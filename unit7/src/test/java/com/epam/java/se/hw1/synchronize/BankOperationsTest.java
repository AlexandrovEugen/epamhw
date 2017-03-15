package com.epam.java.se.hw1.synchronize;


import com.epam.java.se.hw1.XMLLoader;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class BankOperationsTest {


    @Before
    public void load(){
        XMLLoader loader = new XMLLoader();
                loader.load("C:\\Users\\Евгений\\IdeaProjects\\epamhw\\unit7\\src\\main\\resources\\client_operations.xml");
        Map<String,Long> opearions = loader.parseOperationsToMap();
    }

    @Test
    public void test(){

    }

}