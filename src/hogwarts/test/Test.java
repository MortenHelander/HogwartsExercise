package hogwarts.test;
import hogwarts.data.Course;
import hogwarts.data.House;
import hogwarts.data.Student;
import hogwarts.data.Teacher;

public class Test {
    public static void main(String[] args) {
        //Create the four houses.
        House gryffindor = new House("Gryffindor");
        House slytherin = new House("Slytherin");
        House hufflepuff = new House("Hufflepuff");
        House ravenclaw = new House("Ravenclaw");

        //Create teacher.
        Teacher snape = new Teacher("Severus Snape", slytherin);

        //Create students.
        Student harry = new Student("Harry Potter", gryffindor, 17);
        Student ron = new Student("Ronald Weasley", gryffindor, 17);
        Student hermione = new Student("Hermione Granger", gryffindor, 17);

        //Create course.
        Course potions = new Course("Potions", snape);

        //Add students to course.
        potions.addStudent(harry);
        potions.addStudent(ron);
        potions.addStudent(hermione);

        System.out.println("Course: " + potions.getName());
        System.out.println(" with teacher " + potions.getTeacher());
        System.out.println(" has the following students: ");
        System.out.println(potions.getStudents());

    }

}
