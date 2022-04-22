package mytest.java.features.fanxin.model;

import java.util.List;

/**
 * @description：
 * @author: whm
 * @create: 2021-12-20 15:53
 * @version：
 **/
public class PageData<T> {
    /**
     * 记录总条数
     */
    private Long totalCount;
    /**
     * 数据体
     */
    private List<T> data;

    public PageData(Long totalCount, List<T> data) {
        this.totalCount = totalCount;
        this.data = data;
    }

    public PageData() {
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
