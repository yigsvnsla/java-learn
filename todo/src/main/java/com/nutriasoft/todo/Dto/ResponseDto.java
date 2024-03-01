package com.nutriasoft.todo.Dto;

import lombok.Getter;
import lombok.Setter;

public class ResponseDto<T> {

    @Getter
    @Setter
    private MetadataResponseDto meta = null;

    @Getter
    @Setter
    private T data;

    public ResponseDto(T _data, MetadataResponseDto _metaDataResponse) {
        this.setData(_data);
        this.setMeta(_metaDataResponse);
    }

    public ResponseDto(T _data) {
        this.setData(_data);
    }
}
