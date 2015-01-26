package pl.lodz.p.project.core.dao;

import com.google.common.base.Joiner;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by milczu on 26.01.15.
 */
public class SQLSelectQueryBuilder {

    private List<String> columns = new ArrayList<>();
    private String tableName;

    private SQLSelectQueryBuilder() {
    }

    public static SQLSelectQueryBuilder create() {
        return new SQLSelectQueryBuilder();
    }

    public SQLSelectQueryBuilder select(String[] columns) {
        return select(Arrays.asList(columns));
    }

    public SQLSelectQueryBuilder select(Collection<String> columns) {
        this.columns.addAll(columns);
        return this;
    }

    public SQLSelectQueryBuilder from(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public String buildSQL() {
        Assert.isTrue(StringUtils.isNotBlank(tableName));
        return new StringBuilder("SELECT ").append(columns.isEmpty() ? "*" : Joiner.on(",").join(columns)).append(" FROM ").append(tableName).toString();
    }
}
