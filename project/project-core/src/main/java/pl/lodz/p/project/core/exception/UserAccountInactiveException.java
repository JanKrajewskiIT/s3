package pl.lodz.p.project.core.exception;

/**
 * Created by lukasz on 30.01.15.
 */
public class UserAccountInactiveException extends RuntimeException {

    /**
     * Constructs a <code>UserAccountInactiveException</code> with the specified
     * message.
     *
     * @param msg the detail message.
     */
    public UserAccountInactiveException(String msg) {
        super(msg);
    }

    /**
     * Constructs a {@code UserAccountInactiveException} with the specified message and root cause.
     *
     * @param msg the detail message.
     * @param t root cause
     */
    public UserAccountInactiveException(String msg, Throwable t) {
        super(msg, t);
    }

    /**
     * Constructs a {@code UserAccountInactiveException} with the root cause.
     *
     * @param t root cause
     */
    public UserAccountInactiveException(Throwable t) {
        super(t);
    }

}
