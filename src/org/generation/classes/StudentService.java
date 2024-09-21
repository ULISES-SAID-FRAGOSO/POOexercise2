package org.generation.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.generation.exception.CourseNotFoundException;
import org.generation.exception.StudentNotFoundException;

public class StudentService {
   private HashMap<String, Course> courseList = new HashMap<>();
   private HashMap<String, Student> students = new HashMap<>();
   private HashMap<String, List<Course>> coursesEnrolledByStudents = new HashMap<>();

    public StudentService() {
        courseList.put("Math", new Course("Math", 10, "Aurelio Baldor"));
        courseList.put("Physics", new Course("Physics", 10, "Albert Einstein"));
        courseList.put("Art", new Course("Art", 10, "Pablo Picasso"));
        courseList.put("History", new Course("History", 10, "Sima Qian"));
        courseList.put("Biology", new Course("Biology", 10, "Charles Darwin"));
    }
    
    

    public void enrollStudents(String courseName, String studentID) throws CourseNotFoundException, StudentNotFoundException {
        if(courseList.containsKey(courseName)) {
        	throw new CourseNotFoundException(courseName);
        }
        if(!students.containsKey(studentID)) {
        	throw new StudentNotFoundException(studentID);
        }
    	
    	Course course = courseList.get(courseName);
        
//        if (course == null) {
//        	throw new CourseNotFoundException("Course " + courseName + " does not exist");
//        }
//        Student student = students.get(studentID);
//        if (student == null) {
//        	throw new StudentNotFoundException("Student " + studentID + " does not exist");
//        }
        
        if ( !coursesEnrolledByStudents.containsKey( studentID ) )
        {
            coursesEnrolledByStudents.put( studentID, new ArrayList<>() );
        }
        coursesEnrolledByStudents.get( studentID ).add( course );
    }


    public void unEnrollStudents(String courseName, String studentID) {
        Course course = courseList.get(courseName);
        if (course != null && coursesEnrolledByStudents.containsKey(studentID)) {
            coursesEnrolledByStudents.get(studentID).remove(course);
        }
    }

    public void showEnrolledStudents(String courseID) {
        Course course = courseList.get(courseID);
        System.out.println("Students enrolled in " + courseID + ":");
        for (String studentID : coursesEnrolledByStudents.keySet()) {
            List<Course> enrolledCourses = coursesEnrolledByStudents.get(studentID);
            if (enrolledCourses.contains(course)) {
                Student student = students.get(studentID);
            	System.out.println("Student ID: " + studentID);
            }
        }
    }

    public void showAllCourses() {
        for (Course course : courseList.values()) {
        	System.out.println("Available courses: " + course.getName());
        }//for each
    }
    
    public void addStudent (Student student) {
    	students.put(student.getId(), student);
    }

	@Override
	public String toString() {
		return "StudentService [courseList=" + courseList + ", students=" + students + ", coursesEnrolledByStudents="
				+ coursesEnrolledByStudents + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	

	
    
    

    
    
    
}
