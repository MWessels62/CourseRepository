import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Course {

    private String courseName;
    private int numberOfStudents;
    private String courseLecturer;
    
    //Constructor for course object
    public Course(String courseName, int numberOfStudents, String courseLecturer) {
        this.courseName = courseName;
        this.numberOfStudents = numberOfStudents;
        this.courseLecturer = courseLecturer;
    }

    public static void main(String[] args) {
        List<Course> course1 = new ArrayList<Course>();

        //course1.add(new Course("Intro to Programming", 4, "John Smith"));
        //course1.add(new Course("Intro to Software Development", 1000, "Johan Smit"));
        //course1.add(new Course("Data Science 101", 10, "Brian Rockefeller"));
        //course1.add(new Course("Machine Learning: An Introduction", 25, "AN Other"));
        //course1.add(new Course("Outro to Programming", 1000, "Sebastian De Klerk"));
        
        Course temp1 = new Course("",0,"");
        temp1.setCourseName("Intro to Programming");
        temp1.setNumberOfStudents(4);
        temp1.setCourseLecturer("John Smith");
        course1.add(temp1);
        
        Course temp2 = new Course("",0,"");
        temp2.setCourseName("Intro to Software Development");
        temp2.setNumberOfStudents(1000);
        temp2.setCourseLecturer("Johan Smit");
        course1.add(temp2);

        Course temp3 = new Course("",0,"");
        temp3.setCourseName("Data Science 101");
        temp3.setNumberOfStudents(10);
        temp3.setCourseLecturer("Brian Rockefeller");
        course1.add(temp3);

        Course temp4 = new Course("",0,"");
        temp4.setCourseName("Machine Learning: An Introduction");
        temp4.setNumberOfStudents(25);
        temp4.setCourseLecturer("AN Other");
        course1.add(temp4);

        Course temp5 = new Course("",0,"");
        temp5.setCourseName("Outro to Programming");
        temp5.setNumberOfStudents(1000);
        temp5.setCourseLecturer("Sebastian De Klerk");
        course1.add(temp5);

        Collections.sort(course1, new NumberOfStudentsComparator());
        
        System.out.println("\n");
        for (int iterator = 0; iterator < course1.size(); iterator++) {
            System.out.println(course1.get(iterator));
        }
        System.out.println("\n");


    }

    //Getters and Setters
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public String getCourseLecturer() {
        return courseLecturer;
    }

    public void setCourseLecturer(String courseLecturer) {
        this.courseLecturer = courseLecturer;
    }

    //@Override
    public String toString() {
        return ("[Course Name: " + courseName + "] [Course Lecturer: " + courseLecturer + "] [Number Of Students: " + numberOfStudents + "]");
    }

    class NumberOfStudentsComparator implements Comparator < Course > {
        @Override
        public int compare ( Course course1 , Course course2 ) {
            return course1.getNumberOfStudents() - course2.getNumberOfStudents();
        }
    }
}