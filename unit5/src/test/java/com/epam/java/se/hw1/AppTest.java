package com.epam.java.se.hw1;


//import org.junit.Before;
//import org.junit.Ignore;
//import org.junit.Test;
//
//import static org.junit.Assert.assertTrue;
//
//public class AppTest {
//
//    private  App app;
//
//
//    @Before
//    public void init(){
//        app = new App();
//    }
//
//
//    @Ignore
//    @Test
//    public void testThatMethodGoToWorksRight(){
//        assertTrue(app.contains("unit1"));
//            app.cd("unit5");
//        assertTrue(app.contains("src"));
//            app.cd("unit5\\main\\java");
//        assertTrue(app.contains("com"));
//            app.cd("..");
//        assertTrue(app.contains("unit1"));
//    }
//
//    @Ignore
//    @Test(expected = FileNotFoundException.class)
//    public void testThatAppCantDeleteNonExistingFile(){
//        app.rm("customDir");
//    }
//
//    @Ignore
//    @Test(expected = FileAlreadyExistsException.class)
//    public void testThatAppCantCreateAnExitingFile(){
//        app.mkdir("customDir");
//        app.mkdir("customDir");
//    }
//
//    @Ignore
//    @Test
//    public void testThatMethodContainsWorksRight(){
//        app.mkdir("customDir");
//        app.touch("customFile");
//        assertTrue(app.contains("customDir"));
//        assertTrue(app.contains("customFile"));
//    }
//
//    @Ignore
//    @Test
//    public void testThatMethodDeleteWorksRight(){
//        app.mkdir("customDir");
//        assertTrue(app.contains("customDir"));
//        app.rm("customDir");
//        assertFalse(app.contains("customDir"));
//    }
//
//    @Ignore
//    @Test
//    public void testThatMethodWriteToFileWorksRight(){
//        app.writeToFile("unit5\\src\\main\\resources\\customFile.txt", "Hello, World!");
//        String textFromFile = app.readFromFile("unit5\\src\\main\\resources\\customFile.txt");
//        String benchmark = "Hello, Word!";
//        assertEquals(benchmark, textFromFile);
//    }

//}