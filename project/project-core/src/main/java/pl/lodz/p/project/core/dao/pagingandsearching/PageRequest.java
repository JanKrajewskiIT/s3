package pl.lodz.p.project.core.dao.pagingandsearching;

import pl.lodz.p.project.core.dao.pagingandsearching.Sort.Direction;

import java.io.Serializable;

/**
 * Basic Java Bean implementation of {@code Pageable}.
 *
 * @author Milczu
 */
public class PageRequest implements Pageable, Serializable {

    private static final long serialVersionUID = 8280485938848398236L;

    private final int page;
    private final int size;
    private final Sort sort;

    /**
     * Creates a new {@link PageRequest}. Pages are zero indexed, thus providing 0 for {@code page} will return the
     * first page.
     *
     * @param size
     * @param page
     */
    public PageRequest(int page, int size) {
        this(page, size, null);
    }

    /**
     * Creates a new {@link PageRequest} with sort parameters applied.
     *
     * @param page
     * @param size
     * @param direction
     * @param properties
     */
    public PageRequest(int page, int size, Direction direction, String... properties) {
        this(page, size, new Sort(direction, properties));
    }

    /**
     * Creates a new {@link PageRequest} with sort parameters applied.
     *
     * @param page
     * @param size
     * @param sort
     */
    public PageRequest(int page, int size, Sort sort) {
        if (0 > page) {
            throw new IllegalArgumentException(
                    "Page index must not be less than zero!");
        }

        if (0 >= size) {
            throw new IllegalArgumentException(
                    "Page size must not be less than or equal to zero!");
        }

        this.page = page;
        this.size = size;
        this.sort = sort;
    }


    @Override
    public int getPageSize() {
        return size;
    }


    @Override
    public int getPageNumber() {
        return page;
    }


    @Override
    public int getOffset() {
        return page * size;
    }

    @Override
    public Sort getSort() {
        return sort;
    }


    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PageRequest)) {
            return false;
        }

        PageRequest that = (PageRequest) obj;

        boolean pageEqual = this.page == that.page;
        boolean sizeEqual = this.size == that.size;

        boolean sortEqual
                = this.sort == null ? that.sort == null : this.sort
                .equals(that.sort);

        return pageEqual && sizeEqual && sortEqual;
    }


    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + page;
        result = 31 * result + size;
        result = 31 * result + (null == sort ? 0 : sort.hashCode());

        return result;
    }
}
