/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.was04.department.core.exception;

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
