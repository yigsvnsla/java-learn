package com.nutriasoft.todo.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PageDto {
    // todo: hay que implementar una interfaz para la el PageDto y el QueryParamsDto
    private Integer page;

    private Integer take;

    private Long count;

    private Integer pageCount;

    private Boolean hasPreviousPage;

    private Boolean hasNextPage;
    
    /*
     * public PageDto(
     * Integer _page,
     * Integer _take,
     * Long _count) {
     * this.setPage(_page);
     * this.setTake(_take);
     * this.setCount(_count);
     * this.setPageCount((int) Math.ceil(this.getCount() / this.getTake()));
     * this.setHasPreviousPage(this.getPage());
     * this.setHasNextPage(this.getPage() < this.getPageCount());
     * }
     * 
     * public PageDto(Long _count) {
     * this.setCount(_count);
     * this.setPageCount((int) Math.ceil(this.getCount() / this.getTake()));
     * this.setHasPreviousPage(this.getPage());
     * this.setHasNextPage(this.getPage(), this.getPageCount());
     * }
     */

    public void setHasNextPage(Integer _page, Integer _pageCount) {
        this.hasNextPage = _page < _pageCount - 1;
    }

    public void setHasPreviousPage(Integer _page) {
        this.hasPreviousPage = _page > 1;
    }

    public void setPageCount(Integer _pageCount) {
        this.pageCount = _pageCount - 1;
    }

}
