package pl.lodz.p.project.core.exception;

/**
 * Exception designed to inform about optimistic lock exception.
 *
 * @author Łukasz Gadomski
 */
//TODO @ApplicationException(rollback = true)
public class OptLockException extends RuntimeException {

	private static final long serialVersionUID = 5360291910792387806L;

	public OptLockException(String message) {
        super(message);
    }

    public OptLockException(String message, Throwable cause) {
        super(message, cause);
    }

    public OptLockException(Throwable cause) {
        super(cause);
    }
}
