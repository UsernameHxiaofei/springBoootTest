package cn.gtja.model;

import java.util.List;

/**
 * 分页的实体对象
 * @param <T>
 */
public class PageBean<T> {

    private Integer page;
    private Integer pageSize;
    private Integer nextPage;
    private Integer prePage;
    private Integer totalNum;
    private Integer totalPage;
    private List<T> data;


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getNextPage() {
        return nextPage = this.page + 1;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getPrePage() {
        return this.page - 1;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getTotalPage() {
        return this.totalNum%this.pageSize==0?this.totalNum/this.pageSize:this.totalNum/this.pageSize+1;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "page='" + page + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", nextPage='" + nextPage + '\'' +
                ", prePage='" + prePage + '\'' +
                ", totalNum='" + totalNum + '\'' +
                ", totalPage='" + totalPage + '\'' +
                ", data=" + data +
                '}';
    }
}
