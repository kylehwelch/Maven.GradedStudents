package io.zipcoder;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAverageExamScore() == o2.getAverageExamScore()) {
            if (o1.getLastName().charAt(0) < o2.getLastName().charAt(0)) {return -1;}
            else return 1;
        } else if (o1.getAverageExamScore() > o2.getAverageExamScore()){
            return -1;
        } else return 1;
    }
}
