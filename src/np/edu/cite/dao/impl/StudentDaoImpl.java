package np.edu.cite.dao.impl;

import np.edu.cite.dao.StudentDao;
import np.edu.cite.entity.Student;
import np.edu.cite.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        // open database
        DBConnection dbConnection = new DBConnection();
        try {
            Connection conn = dbConnection.open();
            // Get student List
            String sql = "SELECT * FROM students;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Student s = new Student();
                s.setId(resultSet.getInt("id"));
                s.setName(resultSet.getString("name"));
                s.setRoll(resultSet.getInt("roll"));
                s.setEnrolled(resultSet.getBoolean("isEnrolled"));
                students.add(s);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dbConnection.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return students;
    }

    @Override
    public void insert(Student student) {
        // open database
        DBConnection dbConnection = new DBConnection();
        try {
            Connection conn = dbConnection.open();
            // Get student List
            String sql = "INSERT INTO students (name, roll, isEnrolled) VALUES (?, ?, ?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getRoll());
            stmt.setBoolean(3, student.isEnrolled());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dbConnection.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Student getById(int id) {
        // open database
        DBConnection dbConnection = new DBConnection();
        try {
            Connection conn = dbConnection.open();
            // Get student List
            String sql = "SELECT * FROM students WHERE id = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            Student s = new Student();

            resultSet.next();
            s.setId(resultSet.getInt("id"));
            s.setName(resultSet.getString("name"));
            s.setRoll(resultSet.getInt("roll"));
            s.setEnrolled(resultSet.getBoolean("isEnrolled"));

            resultSet.close();
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dbConnection.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void update(Student student) {
        // open database
        DBConnection dbConnection = new DBConnection();
        try {
            Connection conn = dbConnection.open();
            // Get student List
            String sql = "UPDATE students SET name=?, roll=?, isEnrolled=? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getRoll());
            stmt.setBoolean(3, student.isEnrolled());
            stmt.setInt(4, student.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dbConnection.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        // open database
        DBConnection dbConnection = new DBConnection();
        try {
            Connection conn = dbConnection.open();
            // Get student List
            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dbConnection.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
