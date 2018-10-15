package com.newmind.seobackstage.common.mybatis;

import com.newmind.seobackstage.common.model.OrderByInput;
import com.newmind.seobackstage.common.model.PageInput;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description 分页查询工具类
 * create by zhoukc
 */
public class PageSqlFactory {

    private PageSqlFactory() {
    }


    public static String getPageSql(String column, String table, String condition, PageInput input) {

        String sql = MessageFormat.format("select {0} from {1} where {2} order by {3} limit {4},{5}",
                column, table, isEmpty(condition), sort(input), ((input.getPageNumber() - 1) * input.getPageSize()), input.getPageSize());

        return sql;
    }

    private static String isEmpty(String condition) {
        if (condition == null || Objects.equals("", condition)) {
            return "1=1";
        }
        return condition;
    }

    private static String sort(PageInput input) {
        List<OrderByInput> orders = input.getOrders();
        if (orders == null || orders.size() == 0) {
            return "id asc";
        }
        List<String> columns = orders.stream().map(p ->
                (p.getPropertyName() + " " + (p.isDescending() ? "desc" : "asc"))).collect(Collectors.toList());
        return String.join(",", columns);
    }

    public static String getPageCountSql(String table, String condition) {
        String sql = MessageFormat.format("select count(*) from {0} where {1}", table, isEmpty(condition));
        return sql;
    }

}
