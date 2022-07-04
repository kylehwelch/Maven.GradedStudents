package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;


public class StudentTest {

    @Test
    public void testName () {
        Student student = new Student();
        //Given
        String expectedFirstName = "Leroy";
        String expectedLastName = "Jenkins";

        //When
        student.setFirstName(expectedFirstName);
        student.setLastName(expectedLastName);

        //Then
        String actualFirstName = student.getFirstName();
        String actualLastName = student.getLastName();

        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
    }

    @Test
    public void testGetNumberOfExamsTaken() {
        Student student = new Student();
        //Given
        int exam1 = 50;
        int exam2 = 75;
        int exam3 = 50;
        int exam4 = 99;

        //When
        student.addExamScore(exam1);
        student.addExamScore(exam2);
        student.addExamScore(exam3);
        student.addExamScore(exam4);
        int expectedExamNumber = student.getNumberOfExamsTaken();

        //Then
        int actualExamNumber = 4;
        Assert.assertEquals(expectedExamNumber, actualExamNumber);
    }

    @Test
    public void testGetExamScores() {
        Student student = new Student();
        //Given
        int exam1 = 50;
        int exam2 = 51;
        int exam3 = 50;
        int exam4 = 50;
        //When
        student.addExamScore(exam1);
        student.addExamScore(exam2);
        student.addExamScore(exam3);
        student.addExamScore(exam4);
        String expectedGetExam = "Exam 1 --> 50.0\nExam 2 --> 51.0\nExam 3 --> 50.0\nExam 4 --> 50.0";
        //Then
        String actualGetExam = student.getExamScores();
        Assert.assertEquals(expectedGetExam, actualGetExam);
    }

    @Test
    public void testSetExamScore() {
        Student student = new Student();
        //Given
        int exam1 = 50;
        int exam2 = 51;
        int exam3 = 50;
        int exam4 = 50;
        //When
        student.addExamScore(exam1);
        student.addExamScore(exam2);
        student.addExamScore(exam3);
        student.addExamScore(exam4);
        student.setExamScore(1, 95.0);
        String expectedSetExam = "Exam 1 --> 95.0\nExam 2 --> 51.0\nExam 3 --> 50.0\nExam 4 --> 50.0";
        //Then
        String actualSetExam = student.getExamScores();
        Assert.assertEquals(expectedSetExam, actualSetExam);
    }
}