package io.zipcoder;

import java.util.*;

public class Classroom implements Comparator<Student>{


    //INITIALIZERS
    public Student[] students;
//    List<Student> students = new ArrayList<Student>();
    int maxNumberOfStudents;


    //MISC METHODS
    public void addStudent (Student student) {
        for(int i = 0; i < students.length; i++)
            if(students[i] == null) {
                students[i] = student;
//                System.out.println(student);
//                System.out.println(Arrays.toString(students));
                break;
            }
    }
    public void removeStudent (Student student) {
        for (int i = 0 ; i < students.length ; i++) {
            if ((students[i].getFirstName() == student.getFirstName()) &&
                    (students[i].getLastName() == student.getLastName())) {
                students[i] = null;
            }
        }
        for (int i = 0 ; i <= students.length ; i++) {
            if ((students[i] == null) && (students[i + 1] == null)) {break;}
            if ((students[i] == null) && (students[i + 1] != null)) {
                students[i] = students[i + 1];
                students[i + 1] = null;
            }
        }
    }


    //CONSTRUCTORS
    public Classroom (){
        this.students = new Student[30];
    }
    public Classroom (int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }
    public Classroom (Student[] students) {
        this.students = students;
        this.maxNumberOfStudents = 30;
    }



    //SETTERS

    //GETTERS

    public String getStudents() {
        System.out.println(Arrays.toString(students));
        return Arrays.toString(students);
    }

    public double getClassAverageExamScore() {
        double total = 0;

        for (int i = 0 ; i < students.length ; i++) {
            total += students[i].getAverageExamScore();
        }
        return (total / students.length);
    }

    public void getStudentsByScore(Student[] students) {

        Map<Double, Student> smartest = new TreeMap();
        for (int i = 0 ; i < students.length ; i++) {
            smartest.put(students[i].getAverageExamScore(), students[i]);
        }

        System.out.println(smartest.toString());


//        List<Student> smartest = new ArrayList<>(Arrays.asList(students));

//        smartest.sort(smartest, (a,b) -> a.getAverageExamScore().compareTo(b.getAverageExamScore()));

//        int highest = 0;
//        for (int i = 0 ; i < students.length ; i++) {
//            stuEx.put(students[i].toString(), students[i].getAverageExamScore());
//            }
//        System.out.println(stuEx);


    }


    @Override
    public int compare(Student o1, Student o2) {
        return 0;
    }
}
