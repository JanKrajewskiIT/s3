package pl.lodz.p.project.core.jsf.menu;

/**
 *
 * @author milczu
 */
public enum StringCompareOperation implements StringComparableOperation {

    EQUALS(new EqualsComparableOperation()), STARTS_WITH(new StartsWithComparableOperation());
    
    private final StringComparableOperation comparableOperation;
    
    StringCompareOperation(StringComparableOperation comparableOperation) {
        this.comparableOperation = comparableOperation;
    }

    @Override
    public boolean apply(String expected, String current) {
        return comparableOperation.apply(expected, current);
    }
}

class EqualsComparableOperation implements StringComparableOperation {

    @Override
    public boolean apply(String expected, String current) {
        return current.equals(expected);
    }
}

class StartsWithComparableOperation implements StringComparableOperation {

    @Override
    public boolean apply(String expected, String current) {
        return current.startsWith(expected);
    }
}
