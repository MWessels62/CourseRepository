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

        course1.add(new Course("Intro to Programming", 4, "John Smith"));
        course1.add(new Course("Intro to Software Development", 1000, "Johan Smit"));
        course1.add(new Course("Data Science 101", 10, "Brian Rockefeller"));
        course1.add(new Course("Machine Learning: An Introduction", 25, "AN Other"));
        course1.add(new Course("Outro to Programming", 1000, "Sebastian De Klerk"));

        // Sort list according to number of students
        Collections.sort(course1, new NumberOfStudentsComparator());
        //Print results
        System.out.println("Sort the list in ascending order according to number of students....\n");
        for (int iterator = 0; iterator < course1.size(); iterator++) {
            System.out.println(course1.get(iterator));
        }
        System.out.println("\n");


        // Swap items 1 and 2
        Collections.swap(course1,1,2);
        System.out.println("Swap the 2nd item with the 3rd item......\n");
        for (int iterator = 0; iterator < course1.size(); iterator++) {
            System.out.println(course1.get(iterator));
        }
        System.out.println("\n");

        //Create new course object
        List<Course> courses2 = new ArrayList<Course>();
        
        //Populate 2nd Array list using addAll method1
        Collections.addAll(courses2, course1.get(0),course1.get(1),course1.get(2),course1.get(3),course1.get(4));
        System.out.println("Populate 2nd Array list using addAll method\n");
        for (int iterator = 0; iterator < courses2.size(); iterator++) {
            System.out.println(courses2.get(iterator));
        }
        System.out.println("\n");
       
        //Populate 2nd Array list using copy method [This will overwrite what was done by the addAll method]
        Collections.copy(courses2,course1);

        System.out.println("Populate 2nd Array list using copy method\n");
        for (int iterator = 0; iterator < courses2.size(); iterator++) {
            System.out.println(courses2.get(iterator));
        }
        System.out.println("\n");

        //Add 2 new items to 'courses2'
        courses2.add(new Course("Java 101", 55, "Dr. P Green"));
        courses2.add(new Course("Advanced Programming", 93, "Prof M. Milton"));

        //Sort courses2 by courseName
        Collections.sort(courses2, new CourseNameComparator());

        System.out.println("Courses2: sorted alphabetically according to courseName...\n");
        for (int iterator = 0; iterator < courses2.size(); iterator++) {
            System.out.println(courses2.get(iterator));
        }
        System.out.println("\n");

        //Search for where course "Java 101" is located in the array
        int index = Collections.binarySearch(courses2, new Course ("Java 101",0,null),new CourseNameComparator());
        System.out.println("\n The index of 'Java 101' in courses2 is: " + index + "\n");
        
        //disjoint analysis to confirm that there are no similarities between the two course arrays
        boolean arrayDisjoint = Collections.disjoint(course1,courses2);
        System.out.println("Result of disjoint analysis between both arrays is: " + arrayDisjoint);

        //Find course with most students
        Course mostStudents = Collections.max(courses2, new NumberOfStudentsComparator());
        System.out.println("\nThe course with the most students is: \n" + mostStudents);

        //Find course with least students
        Course leastStudents = Collections.min(courses2, new NumberOfStudentsComparator());
        System.out.println("\nThe course with the least students is: \n" + leastStudents);
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

    
}

class NumberOfStudentsComparator implements Comparator<Course> {
    @Override
    public int compare(Course course1, Course course2) {
        return course1.getNumberOfStudents() - course2.getNumberOfStudents();
    }
}

class CourseNameComparator implements Comparator<Course> {
    @Override
    public int compare(Course course1, Course course2) {
        return course1.getCourseName().compareTo(course2.getCourseName());
    }
}
