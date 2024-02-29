package Dto;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

public class MetadataResponseDto {
    @Getter
    @Setter
    private HttpStatus status;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private PageDto pagination = null;

    public MetadataResponseDto(HttpStatus _status, String _message, PageDto _pagination) {
        this.setStatus(_status);
        this.setMessage(_message);
        this.setPagination(_pagination);
    }

    public MetadataResponseDto(HttpStatus _status, String _message) {
        this.setStatus(_status);
        this.setMessage(_message);
    }
}
