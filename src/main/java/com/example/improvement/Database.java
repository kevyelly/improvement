package com.example.improvement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Database {
    public static final String URL = "jdbc:mysql://localhost:3306/practice";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    public static User loggedIn;
    public static String chosenCourse;

    public static boolean checkPass(String user, String p) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement statement = connection.prepareStatement("select * from users where Username=?")) {
            statement.setString(1, user);
            ResultSet resultSet = statement.executeQuery();
            User fetched = null;
            while (resultSet.next()) {
                fetched = new User(resultSet.getInt("ID"), resultSet.getString("Username"), resultSet.getString("Password"), resultSet.getInt("Role"));
            }
            if (fetched == null) {
                System.out.println("User does not exist");
                return false;
            }
            if (Objects.equals(fetched.password, p)) {
                System.out.println("Sumakses");
                loggedIn = fetched;
                return true;
            } else {
                System.out.println("Incorrect pass");
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Course> getCourse(int ID) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement statement = connection.prepareStatement("select * from courses where studentid=?")) {
            statement.setInt(1, ID);
            System.out.println(ID);
            ResultSet resultSet = statement.executeQuery();
            List<Course> courses = new ArrayList<>();
            while (resultSet.next()) {
                courses.add(new Course(resultSet.getString("coursecode"), resultSet.getString("coursename"), resultSet.getDouble("grades")));
            }
            return courses;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Course> getCourseTeacher(int ID) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT coursecode, coursename, grades\n" +
                "FROM courses\n" +
                "WHERE teacherid = ?;")) {
            statement.setInt(1, ID);
            System.out.println(ID);
            ResultSet resultSet = statement.executeQuery();
            List<Course> courses = new ArrayList<>();
            while (resultSet.next()) {
                courses.add(new Course(resultSet.getString("coursecode"), resultSet.getString("coursename"), resultSet.getDouble("grades")));
            }
            return courses;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
