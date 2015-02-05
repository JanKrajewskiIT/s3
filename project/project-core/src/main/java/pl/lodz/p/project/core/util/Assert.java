package pl.lodz.p.project.core.util;

/**
 *
 * @author Milczu
 */
public class Assert {
    
    public static void isTrue(boolean expression) {
        Assert.isTrue(expression, null);
    }
    
    public static void isTrue(boolean expression, String message) {
        if(!expression) {
            throw new IllegalArgumentException(message);
        }
    }
    
    public static void notNull(Object o) {
        if(o == null) {
            throw new IllegalArgumentException();
        }
    }
}
