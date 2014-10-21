package pl.lodz.p.was04.department.core.utils;

/**
 *
 * @author milczu
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
