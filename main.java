package StudentJDBC;

import java.sql.Connection;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("STUDENT MANGEMENT ");
        Scanner sc = new Scanner(System.in);
        Connection con = Conectivity.connection();
        Student student = new Student();
        boolean flage = true;
        while (flage){
            System.out.println("ENTER 1 : ALTER TABLE ADD GENDER COLUMN");
            System.out.println("ENTER 2 : DISPLAY RECORDS OF TY HAVE MORE 70");
            System.out.println("ENTER 3 : DISPLAY STUDENT 1 - 10 ");
            System.out.println("ENTER 4 : OPERATION");
            System.out.println("ENTER 0 : EXIT ");
            int ch = sc.nextInt();

            switch (ch){
                case 1:
                    student.altertable();
                    break;
                case 2:
                    student.showTyrecord();
                    break;
                case 3:
                    student.showStudent();
                    break;
                case 4:
                    boolean flage1 = true;
                    while (flage1) {
                        System.out.println("ENTER 1 : ADD 3 STUDENTS");
                        System.out.println("ENTER 2 : SALUTATIONS ");
                        System.out.println("ENTER 3 : REMOVE STUDENT OF LAST YEAR ");
                        int ch1 = sc.nextInt();
                        switch (ch1) {
                            case 1:
                                student.add3student();
                                break;
                            case 2:
                                student.salutation();
                                break;
                            case 3:
                                student.showStudent();
                                break;
                            case 0:
                                flage1=false;
                                break;
                        }
                    }
                    break;
                case 0:
                    flage=false;
                    break;
            }
        }



    }
}
