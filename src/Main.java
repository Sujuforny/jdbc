import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Ostudent ostudent = new Ostudent();
        Student student = new Student();
       Boolean isOperation=false;
       do {
           System.out.println("1.insert new student");
           System.out.println("2.update informention student");
           System.out.println("3.delete student by ID");
           System.out.println("4.select informention student");
           System.out.println("5.Show Informention All student");
           System.out.println("0.exit");
           System.out.print("chose one :");
           int op = scanner.nextInt();
           switch (op){
               case 1 -> {
                   System.out.println("***************insert new student***************");
                   System.out.print("Enter ID: ");
                   student.setId(scanner.nextInt());
                   System.out.print("Enter Name: ");
                   student.setName(scanner.nextLine());
                   scanner.nextLine();
                   System.out.print("Enter Class Name: ");
                   student.setClassName(scanner.nextLine());
                   ostudent.insert(student.getId(),student.getName(),student.getClassName() );
               }

               case 2 -> {
                   System.out.println("***************update informention student***************");
                   System.out.print("Enter ID Student that you want to update informention:");
                   student.setId(scanner.nextInt());
                   System.out.print("New Name: ");
                   student.setName(scanner.nextLine());
                   scanner.nextLine();
                   System.out.print("New class: ");
                   student.setClassName(scanner.nextLine());
                   ostudent.update(student.getId(), student.getName(), student.getClassName());
               }
               case 3 -> {
                   System.out.println("***************delete student by ID***************");
                   System.out.print("Enter ID: ");
                   student.setId(scanner.nextInt());
                   ostudent.delete(student.getId());
               }
               case 4 -> {
                   System.out.println("***************select informention student by ID ***************");
                   System.out.print("Enter ID: ");
                   student.setId(scanner.nextInt());
                   ostudent.search(student.getId());
               }
               case 5 -> {
                   System.out.println("==================Show Informention All student==================");
                   ostudent.showInformention();
               }
               case 0 -> {
                   System.out.println("5.exit");
                   isOperation=true;
               }
           }
       }while (!isOperation);
    }
}