import db.DBCourse;
import db.DBHelper;
import models.Course;
import models.Level;
import models.Student;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Course course1 = new Course("Software Dev", Level.BA);
        Course course2 = new Course("Maths", Level.BENG);
        DBHelper.save(course1);
        DBHelper.save(course2);
        Student student1 = new Student("Joe", "Pollock", 31, 1025, course1);
        Student student2 = new Student("John", "Smith", 25, 1026, course2);
        Student student3 = new Student("Sarah", "Parker", 29, 1027, course2);
        DBHelper.save(student1);
        DBHelper.save(student2);
        DBHelper.save(student3);

        student2.setLastName("Rainer");
        DBHelper.update(student2);

        Student john = DBHelper.find(Student.class, student2.getId());

        DBHelper.delete(student3);

        List<Student> allStudents = DBHelper.getAll(Student.class);
        List<Course> allCourses = DBHelper.getAll(Course.class);

        List<Student> allStudentsCourse1 = DBCourse.getAllStudents(course1);

    }
}
