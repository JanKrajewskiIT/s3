package pl.lodz.p.project.core.exception;

/**
 * Exception designed to inform that there is a unique constraint violation.
 *
 * @author Łukasz Gadomski
 */
//TODO @ApplicationException(rollback = true)
public class UniqueConstraintViolationException extends RuntimeException {

	private static final long serialVersionUID = 2943804412614934562L;

	public UniqueConstraintViolationException(String message) {
        super(message);
    }

    public UniqueConstraintViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniqueConstraintViolationException(Throwable cause) {
        super(cause);
    }

}
