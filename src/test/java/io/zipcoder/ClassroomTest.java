package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ClassroomTest {
    @Test
    public void testGetAverageExamScore() {
        //Given
        ArrayList<Double> s1Scores = new ArrayList<>(Arrays.asList(100.0, 150.0));
        ArrayList<Double> s2Scores = new ArrayList<>(Arrays.asList(225.0, 25.0));

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double actual = classroom.getClassAverageExamScore();
        double expected = 125.0;
        // Then
        System.out.println(actual);
        Assert.assertEquals(expected, actual, 0.0);
    }


    @Test
    public void testAddStudent() {
        // : Given
        Student gerald = new Student("Gerald", "Buttlicker");
        Classroom actualClassroom = new Classroom(1);
        Student[] expStudents = new Student[]{gerald};
        String expected = Arrays.toString(expStudents);
        // When
        actualClassroom.addStudent(gerald);
        String actual = actualClassroom.getStudents();
        // Then
       Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveStudent() {
        //Given
        Student gerald = new Student("Gerald", "Buttlicker");
        Student herman = new Student("Herman", "Sillyface");
        Student clyde = new Student("Clyde", "Theglide");
        Student dingo = new Student("Dingo", "Atemybaby");
        Student[] acStu = new Student[]{gerald, herman, clyde, dingo};
        Classroom classroom = new Classroom(acStu);

        //When
        Student[] exStu = new Student[]{gerald, clyde, dingo, null};
        classroom.removeStudent(herman);

        //Then
        Assert.assertEquals(Arrays.toString(exStu), classroom.getStudents());
    }

    @Test
    public void testGetStudentsByScore() {
        ArrayList<Double> gerScores = new ArrayList<>(Arrays.asList(75.0, 50.0));
        ArrayList<Double> herScores = new ArrayList<>(Arrays.asList(80.0, 25.0));
        ArrayList<Double> clyScores = new ArrayList<>(Arrays.asList(75.0, 50.0));
        ArrayList<Double> dinScores = new ArrayList<>(Arrays.asList(50.0, 40.0));

        Student herman = new Student("Herman", "Buttlicker", herScores);
        Student gerald = new Student("Gerald", "Sillyface", gerScores);
        Student clyde = new Student("Clyde", "Theglide", clyScores);
        Student dingo = new Student("Dingo", "Atemybaby", dinScores);

        Student[] acStu = new Student[]{herman, gerald, clyde, dingo};
        Classroom classroom = new Classroom(acStu);
        acStu = classroom.getStudentsByScore(acStu);
        Student[] exStu = new Student[]{gerald, clyde, herman, dingo};

        Assert.assertEquals(exStu, acStu);
    }

    @Test
    public void testGradeBook(){
        ArrayList<Double> gerScores = new ArrayList<>(Arrays.asList(75.0, 50.0));
        ArrayList<Double> herScores = new ArrayList<>(Arrays.asList(80.0, 25.0));
        ArrayList<Double> clyScores = new ArrayList<>(Arrays.asList(75.0, 50.0));
        ArrayList<Double> dinScores = new ArrayList<>(Arrays.asList(50.0, 40.0));
        ArrayList<Double> meepScores = new ArrayList<>(Arrays.asList(66.0, 71.0));
        ArrayList<Double> marvScores = new ArrayList<>(Arrays.asList(12.0, 15.0));
        ArrayList<Double> docScores = new ArrayList<>(Arrays.asList(100.0, 100.0));

        Student herman = new Student("Herman", "Buttlicker", herScores);
        Student gerald = new Student("Gerald", "Sillyface", gerScores);
        Student clyde = new Student("Clyde", "Theglide", clyScores);
        Student dingo = new Student("Dingo", "Atemybaby", dinScores);
        Student meep = new Student("Meep", "Dooboo", meepScores);
        Student marvin = new Student("Marvin", "Martian", marvScores);
        Student doc = new Student("Doc", "Lilly", docScores);

        Student[] acStu = new Student[]{herman, gerald, clyde, dingo, meep, marvin, doc};
        Classroom classroom = new Classroom(acStu);
        String expected = "Doc Lilly A\nMeep Dooboo B\nGerald Sillyface B\nClyde Theglide C\nHerman Buttlicker D\n" +
                "Dingo Atemybaby D\nMarvin Martian D\n";
        String actual = classroom.getGradeBook(acStu);

        Assert.assertEquals(expected, actual);
    }


}
