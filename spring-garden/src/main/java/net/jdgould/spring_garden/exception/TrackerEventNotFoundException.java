package net.jdgould.spring_garden.exception;

public class TrackerEventNotFoundException extends RuntimeException {
    public TrackerEventNotFoundException(String message) {
        super(message);
    }
}
