package java_core_bai14.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java_core_bai14.models.GoodStudent;
import java_core_bai14.models.NormalStudent;
import java_core_bai14.models.Student;

public class Dao {
    public static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=JavaCoreBai14";
    public static final String USER = "sa";
    public static final String PW = "P90rushbnonstop!";

    private static Dao _instance;

    private Dao() {

    }

    public static Dao instance() {
        if (_instance == null) {
            _instance = new Dao();
        }
        return _instance;
    }

    private Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = URL + ";trustServerCertificate=true";
            conn = DriverManager.getConnection(connectionUrl, USER, PW);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void addStudent(Student student) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            String sql = "INSERT INTO Student (fullName, dateOfBirth, sex, phoneNumber, universityName, gradeLevel, gpa, bestRewardName, englishScore, entryTestScore, type) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, student.getFullName());
            pstmt.setDate(2, java.sql.Date.valueOf(student.getDateOfBirth()));
            pstmt.setString(3, student.getSex());
            pstmt.setString(4, student.getPhoneNumber());
            pstmt.setString(5, student.getUniversityName());
            pstmt.setString(6, student.getGradeLevel());
            
            if (student instanceof GoodStudent) {
                GoodStudent goodStudent = (GoodStudent) student;
                pstmt.setDouble(7, goodStudent.getGpa());
                pstmt.setString(8, goodStudent.getBestRewardName());
                pstmt.setNull(9, java.sql.Types.INTEGER);
                pstmt.setNull(10, java.sql.Types.DECIMAL);
                pstmt.setInt(11, 1);
            } else if (student instanceof NormalStudent) {
                NormalStudent normalStudent = (NormalStudent) student;
                pstmt.setNull(7, java.sql.Types.DECIMAL);
                pstmt.setNull(8, java.sql.Types.NVARCHAR);
                pstmt.setInt(9, normalStudent.getEnglishScore());
                pstmt.setDouble(10, normalStudent.getEntryTestScore());
                pstmt.setInt(11, 2);
            }
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Student> getStudents() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Student> students = new ArrayList<>();

        try {
            conn = getConnection();
            String sql = "SELECT * FROM Student";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Student student = null;
                int type = rs.getInt("type");
                if (type == 1) {
                    GoodStudent goodStudent = new GoodStudent(
                        rs.getString("fullName"),
                        rs.getDate("dateOfBirth").toLocalDate(),
                        rs.getString("sex"),
                        rs.getString("phoneNumber"),
                        rs.getString("universityName"),
                        rs.getString("gradeLevel"),
                        rs.getDouble("gpa"),
                        rs.getString("bestRewardName")
                    );
                    student = goodStudent;
                } else if (type == 2) {
                    NormalStudent normalStudent = new NormalStudent(
                        rs.getString("fullName"),
                        rs.getDate("dateOfBirth").toLocalDate(),
                        rs.getString("sex"),
                        rs.getString("phoneNumber"),
                        rs.getString("universityName"),
                        rs.getString("gradeLevel"),
                        rs.getInt("englishScore"),
                        rs.getDouble("entryTestScore")
                    );
                    student = normalStudent;
                }

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return students;
    }
    
    public List<Student> getGoodStudents() {
        List<Student> goodStudents = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();

            String sql = "SELECT * FROM Student WHERE type = 1";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                GoodStudent goodStudent = new GoodStudent(
                    rs.getString("fullName"),
                    rs.getDate("dateOfBirth").toLocalDate(),
                    rs.getString("sex"),
                    rs.getString("phoneNumber"),
                    rs.getString("universityName"),
                    rs.getString("gradeLevel"),
                    rs.getDouble("gpa"),
                    rs.getString("bestRewardName")
                );
                goodStudents.add(goodStudent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return goodStudents;
    }

    public List<Student> getNormalStudents() {
        List<Student> normalStudents = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();

            String sql = "SELECT * FROM Student WHERE type = 2";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                NormalStudent normalStudent = new NormalStudent(
                    rs.getString("fullName"),
                    rs.getDate("dateOfBirth").toLocalDate(),
                    rs.getString("sex"),
                    rs.getString("phoneNumber"),
                    rs.getString("universityName"),
                    rs.getString("gradeLevel"),
                    rs.getInt("englishScore"),
                    rs.getDouble("entryTestScore")
                );
                normalStudents.add(normalStudent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return normalStudents;
    }
}