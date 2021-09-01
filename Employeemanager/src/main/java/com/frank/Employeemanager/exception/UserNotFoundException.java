package com.frank.Employeemanager.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        //el mensaje que se mostrara es el que se le esta pasando del "EmployeeService" en la exception
        super(message);
    }
}
