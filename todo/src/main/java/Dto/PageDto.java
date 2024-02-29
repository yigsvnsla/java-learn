package Dto;

import lombok.Getter;
import lombok.Setter;

public class PageDto {
    @Getter
    @Setter
    private int page = 1;

    @Getter
    @Setter
    private int take = 10;

    @Getter
    @Setter
    private int count;

    @Getter
    @Setter
    private int pageCount;

    @Getter
    @Setter
    private boolean hasPreviousPage;

    @Getter
    @Setter
    private boolean hasNextPage;

    public PageDto(
            int _page,
            int _take,
            int _count) {
        this.setPage(_page);
        this.setTake(_take);
        this.setCount(_count);
        this.setPageCount((int) Math.ceil(this.getCount() / this.getTake()));
        this.setHasPreviousPage(this.getPage() > 1);
        this.setHasNextPage(this.getPage() < this.getPageCount());
    }

    public PageDto(int _count) {
        this.setCount(_count);
        this.setPageCount((int) Math.ceil(this.getCount() / this.getTake()));
        this.setHasPreviousPage(this.getPage() > 1);
        this.setHasNextPage(this.getPage() < this.getPageCount());
    }
}
