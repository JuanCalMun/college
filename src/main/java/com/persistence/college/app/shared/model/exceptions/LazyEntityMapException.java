package com.persistence.college.app.shared.model.exceptions;

public class LazyEntityMapException extends RuntimeException {

    private static final long serialVersionUID = -6179696141157930389L;

    public LazyEntityMapException() {
        super("The system is trying to map a lazy loaded entity. This entity is resolved as null");
    }
}
