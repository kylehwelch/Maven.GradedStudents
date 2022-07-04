package io.zipcoder;

import java.util.ArrayList;

public class Student {
    //INITIALIZING VARIABLES
    private String firstName;
    private String lastName;
    ArrayList<Double> examScores = new ArrayList<Double>();


    //CONSTRUCTORS
    public Student () {
        this.firstName = "";
        this.lastName = "";
    }
    public Student (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Student (String firstName, String lastName, ArrayList<Double> examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = examScores;
    }
    public Student (ArrayList<Double> examScores){
        this.examScores = examScores;
    }
    public void addExamScore(double examScore) {
        this.examScores.add(examScore);
        System.out.println("New exam score added. Exam# " + (examScores.lastIndexOf(examScore)+1) + " Score: " + this.examScores.get(examScores.size()-1));
    }

    //SETTERS
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setExamScore (int examNumber, Double examScore) {
        //ENTER EXAM NUMBER, NOT INDEX NUMBER
        this.examScores.set(examNumber-1, examScore);

    }

    //GETTERS
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getExamScores() {
        String theList = "";
        int y = 1;
        for (int i = 0 ; i < this.examScores.size() ; i++) {
            if (i < this.examScores.size()-1) {theList += ("Exam " + y + " --> " + this.examScores.get(i) + "\n");}
            else if (i == this.examScores.size()-1) {theList += ("Exam " + y + " --> " + this.examScores.get(i));}
            y++;
        }
        System.out.println(theList);
        return theList;
    }
    public int getNumberOfExamsTaken() {
        return this.examScores.size();
    }
}
