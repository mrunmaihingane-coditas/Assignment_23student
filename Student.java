package StudentJDBC;

import java.sql.*;
import java.util.Scanner;

public class Student {
    int ID;
    String name;
    int per;
    String city;
    int year;
    String gender;
    Scanner sc = new Scanner(System.in);
   public void altertable(){
       Connection con = Conectivity.connection();
       try {
           PreparedStatement ps = con.prepareStatement("alter table student_College add column gender varchar(9) default 'M'");
           ps.executeUpdate();
       } catch (SQLException e) {
           System.out.println(e);
       }


   }
   public void showTyrecord(){
       Connection con = Conectivity.connection();
       try {
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("select name, year, per from  student_College where per>70 and year = 3");
           while (rs.next()){
               System.out.println(rs.getString("name")+"==="+rs.getInt("year")+"==="+rs.getInt("per"));
           }
       } catch (SQLException e) {
           System.out.println(e);
       }

   }
   public void showStudent(){
       Connection con = Conectivity.connection();
       try {
           Statement st  = con.createStatement();
           ResultSet rs = st.executeQuery("select ID, name from  student_College where ID between 1 and 10");
           while (rs.next()){
               System.out.println(rs.getInt("ID")+"==="+rs.getString("name"));
           }

       } catch (SQLException e) {
           System.out.println(e);
       }


   }
   public void add3student(){
       Connection con = Conectivity.connection();
       for (int i =0;i<3;i++){
           try {
               System.out.println("Enter name");
           name = sc.nextLine();
           System.out.println("Enter per");
           per=sc.nextInt();
           System.out.println("Enter city");
           city = sc.nextLine();
           System.out.println("ENTER year");
           year = sc.nextInt();
           sc.nextLine();
           System.out.println("Enter gender");
            gender= sc.nextLine();
           PreparedStatement ps = con.prepareStatement("insert into student_College (name,per,city,year,gender)values(?,?,?,?,?)");
           ps.setString(1,name);
           ps.setInt(2,per);
           ps.setString(3, city);
           ps.setInt(4,year);
           ps.setString(5,gender);
           ps.executeUpdate();

       }
           catch (SQLException e) {
               System.out.println(e);
           }
       }

   }
   public void salutation(){
       Connection con = Conectivity.connection();
       try {
           PreparedStatement ps = con.prepareStatement("UPDATE  student_College SET name = CONCAT('Mr. ', name) WHERE gender = 'M'");
           PreparedStatement ps1 = con.prepareStatement("UPDATE  student_College SET name = CONCAT('Mrs. ', name) WHERE gender = 'F'");

           ps.executeUpdate();
           ps1.executeUpdate();
       } catch (SQLException e) {
           System.out.println(e);
       }

   }
   public void studentBE(){
       Connection con = Conectivity.connection();
       try {
           PreparedStatement ps = con.prepareStatement("delete from student_College where year=3");
           ps.executeUpdate();
       } catch (SQLException e) {
           System.out.println(e);
       }





   }
}
