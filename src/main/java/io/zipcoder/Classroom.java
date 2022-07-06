package io.zipcoder;

public class Classroom {

    //INITIALIZERS
    public Student[] students;
    int maxNumberOfStudents = 30;


    //CONSTRUCTORS
    public Classroom (){
        this.students = new Student[30];
    }
    public Classroom (int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }
    public Classroom (Student[] students) {
        this.students = students;
    }

    //SETTERS

    //GETTERS

    public Student[] getStudents() {
        return students;
    }


    public double getAverageExamScore() {
        //iterate through students array, using getAverageExamScore to add to sum,
        double total = 0;

        for (int i = 0 ; i < students.length ; i++) {
            total += students[i].getAverageExamScore();
        }
        return (total / students.length);
    }



}
