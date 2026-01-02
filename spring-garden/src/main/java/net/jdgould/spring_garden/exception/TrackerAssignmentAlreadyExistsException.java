package net.jdgould.spring_garden.exception;

public class TrackerAssignmentAlreadyExistsException extends RuntimeException {
    public TrackerAssignmentAlreadyExistsException(String message) {
        super(message);
    }
}
