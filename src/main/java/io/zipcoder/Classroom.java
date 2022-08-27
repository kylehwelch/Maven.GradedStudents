package io.zipcoder;

import java.util.*;

public class Classroom{


    //INITIALIZERS
    public Student[] students;
    int maxNumberOfStudents;

    private StudentComparator studentComparator = new StudentComparator();


    //MISC METHODS
    public void addStudent (Student student) {
        for(int i = 0; i < students.length; i++)
            if(students[i] == null) {
                students[i] = student;
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
        for (int i = 0 ; i < students.length-1 ; i++) {
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

    public Student[] getStudentsByScore(Student[] students) {
        StudentComparator sc = new StudentComparator();
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < students.length-1; i++) {
                if (sc.compare(students[i], students[i+1]) > 0) {
                    Student tempStu = students[i];
                    students[i] = students [i+1];
                    students[i+1] = tempStu;
                    swapped = true;
                }
            }
        }
        List<Student> smartest = new ArrayList<>(Arrays.asList(students));
        return smartest.toArray(new Student[0]);
    }

    public String getGradeBook(Student[] students){
//        An A is 10th percentile.
//        A B is 11th and 29th percentile.
//        A C is 30th and 50th percentile.
//        A D 51st and 89th percentile.
//        An F is 11th percentile.
        students = getStudentsByScore(students);
        double percentile;
        StringBuilder gradeBook = new StringBuilder();
        List<Double> examScores = new ArrayList<>();
        for (Student s : students) {examScores.add(s.getAverageExamScore());}
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < examScores.size(); j++) {
                if (students[i].getAverageExamScore() == examScores.get(j)) {
                    percentile = 100 * ((examScores.size() - j) / (double)examScores.size());
                    if (percentile >= 90) {
                        gradeBook.append(students[i].getFirstName() + " " + students[i].getLastName() + " A\n");
                        break;
                    } else if (percentile >= 71 && percentile < 90) {
                        gradeBook.append(students[i].getFirstName() + " " + students[i].getLastName() + " B\n");
                        break;
                    } else if (percentile >= 50 && percentile < 71) {
                        gradeBook.append(students[i].getFirstName() + " " + students[i].getLastName() + " C\n");
                        break;
                    } else if (percentile >= 11 && percentile < 50) {
                        gradeBook.append(students[i].getFirstName() + " " + students[i].getLastName() + " D\n");
                        break;
                    } else {
                        gradeBook.append(students[i].getFirstName() + " " + students[i].getLastName() + " F\n");
                        break;
                    }
                }
            }
        }
        return gradeBook.toString();
    }
}
