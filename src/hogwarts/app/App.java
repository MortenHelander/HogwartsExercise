package hogwarts.app;

import hogwarts.app.UI.TextUI;
import hogwarts.data.House;
import hogwarts.data.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    ArrayList<Student> students = new ArrayList<>();
    TextUI ui = new TextUI();
    Scanner scan = new Scanner(System.in);

    //Constructor.
    public App() {
    }

    //Methods.
    public void start() {
        loadStudents();
        System.out.println("Starting application...");
        showMenu();
    }

    private void loadStudents() {
        //Create the four houses.
       /* House gryffindor = new House("Gryffindor");
        House slytherin = new House("Slytherin");
        House hufflepuff = new House("Hufflepuff");
        House ravenclaw = new House("Ravenclaw");*/


        try {
            File file = new File("students.csv");
            System.out.println("Indhold af filen:"+ file.getName());

            Scanner scan = new Scanner(file);
            scan.useDelimiter("[;\n]");
            String header = scan.nextLine();


            while(scan.hasNext()) {
                String name = scan.next();
                String house = scan.next();
                int age = Integer.parseInt(scan.next().trim());

                House house1 = new House(house);
                Student student = new Student(name, house1, age );
                students.add(student);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        //Create students.
        /*Student harry = new Student("Harry Potter", gryffindor, 17);
        Student ron = new Student("Ronald Weasley", gryffindor, 17);
        Student hermione = new Student("Hermione Granger", gryffindor, 17);
        students.add(harry);
        students.add(ron);
        students.add(hermione);*/
    }

    private void showMenu() {
        int choice;
        while (true) {
            choice = ui.promptNumeric("""
                    Student Menu:
                    --------------
                    1) List all students.
                    2) Create new student.
                    
                    0) Exit application.
                    """);
                if (choice == 1) {
                   listAllStudents();
                } else if (choice == 2) {
                    createNewStudent();
                } else if (choice == 0) {
                    System.out.println("Exiting application");
                    return;
                } else {
                    System.out.println("Please only enter correct inputs!");
                }
            }
    }

    private void listAllStudents() {
        System.out.println("There are " +students.size() + " students in the system");
        System.out.println("====================================");
        for(Student e : students){
            System.out.printf("%20s - age %-2d - house: %s\n", e.getName(), e.getAge(), e.getHouse().getName());
        }

    }


        private void createNewStudent() {
           String name= ui.promptText("Please type name of student here:");
           String houseString=ui.promptText("Please type the house of the student here:");
           int age = ui.promptNumeric("Please type the age of the student here:");
           House house = new House(houseString);
           Student student = new Student(name, house, age);
           students.add(student);
        }
}
