package pl.lodz.p.project.core.dao.pagingandsearching;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Basic {@code Page} implementation.
 *
 * @param <T> the type of which the page consists.
 * @author Milczu
 */
public class PageImpl<T> implements Page<T>, Serializable {

    private static final long serialVersionUID = 867755909294344406L;

    private final List<T> content = new ArrayList<>();
    private final Pageable pageable;
    private final long total;

    /**
     * Constructor of {@code PageImpl}.
     *
     * @param content	the content of this page
     * @param pageable the paging information
     * @param total	the total amount of items available
     */
    public PageImpl(List<T> content, Pageable pageable, long total) {
        if (null == content) {
            throw new IllegalArgumentException("Content must not be null!");
        }

        this.content.addAll(content);
        this.total = total;
        this.pageable = pageable;
    }

    /**
     * Creates a new {@link PageImpl} with the given content. This will result in the created {@link Page} being
     * identical to the entire {@link List}.
     *
     * @param content
     */
    public PageImpl(List<T> content) {
        this(content, null, (null == content) ? 0 : content.size());
    }

    @Override
    public int getNumber() {
        return pageable == null ? 0 : pageable.getPageNumber();
    }

    @Override
    public int getSize() {
        return pageable == null ? 0 : pageable.getPageSize();
    }

    @Override
    public int getTotalPages() {
        return getSize() == 0 ? 0 : (int) Math.ceil((double) total / (double) getSize());
    }

    @Override
    public int getNumberOfElements() {

        return content.size();
    }

    @Override
    public long getTotalElements() {

        return total;
    }

    @Override
    public boolean hasPreviousPage() {
        return getNumber() > 0;
    }

    @Override
    public boolean isFirstPage() {
        return !hasPreviousPage();
    }

    @Override
    public boolean hasNextPage() {
        return ((getNumber() + 1) * getSize()) < total;
    }

    @Override
    public boolean isLastPage() {

        return !hasNextPage();
    }

    @Override
    public Iterator<T> iterator() {
        return content.iterator();
    }

    @Override
    public List<T> getContent() {
        return content;
    }

    @Override
    public boolean hasContent() {
        return !content.isEmpty();
    }

    @Override
    public Sort getSort() {
        return pageable == null ? null : pageable.getSort();
    }

    @Override
    public String toString() {
        String contentType = "UNKNOWN";
        if (content.size() > 0) {
            contentType = content.get(0).getClass().getName();
        }
        return String.format("Page %s of %d containing %s instances", getNumber(), getTotalPages(), contentType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PageImpl<?>)) {
            return false;
        }

        PageImpl<?> that = (PageImpl<?>) obj;

        boolean totalEqual = this.total == that.total;
        boolean contentEqual = this.content.equals(that.content);
        boolean pageableEqual = this.pageable == null ? that.pageable == null : this.pageable.equals(that.pageable);

        return totalEqual && contentEqual && pageableEqual;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (int) (total ^ total >>> 32);
        result = 31 * result + (pageable == null ? 0 : pageable.hashCode());
        result = 31 * result + content.hashCode();

        return result;
    }
}
