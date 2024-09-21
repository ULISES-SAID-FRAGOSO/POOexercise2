package org.generation.exception;

public class CourseNotFoundException extends Exception
{

    public CourseNotFoundException(String message)
    {
        super("course not found!![" + message + "]");
    }
}