package org.generation.main;

import org.generation.classes.Student;
import org.generation.classes.StudentService;
import org.generation.exception.CourseNotFoundException;
import org.generation.exception.StudentNotFoundException;

public class Main {

    public static void main(String[] args) {
	    StudentService studentService = new StudentService();
	    //TODO refactor this code to use encapsulation inside studentsService
        studentService.addStudent(new Student( "Carlos", "1030", 31 ) );
        studentService.addStudent(new Student( "Ian", "1020", 28 ) );
        studentService.addStudent(new Student( "Elise", "1020", 26 ) );
        studentService.addStudent(new Student( "Santiago", "1020", 33 ) );
     
        
        try {
            studentService.enrollStudents("Math01", "1030");
            studentService.enrollStudents("History", "1040"); 
        } catch (CourseNotFoundException | StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Imprimir estudiantes inscritos en Matemáticas
        studentService.showEnrolledStudents("Math");

        // Imprimir estudiantes inscritos en Biología
        studentService.showEnrolledStudents("Biology");
       
       studentService.showAllCourses();
       
    }
}