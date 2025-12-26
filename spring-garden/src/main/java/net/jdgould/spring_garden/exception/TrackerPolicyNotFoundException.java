package net.jdgould.spring_garden.exception;

public class TrackerPolicyNotFoundException extends RuntimeException {
    public TrackerPolicyNotFoundException(String message) {
        super(message);
    }
}
