package com.nutriasoft.todo.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDto<T> {

    private MetadataResponseDto meta = null;

    private T data;

    public ResponseDto(T _data, MetadataResponseDto _metaDataResponse) {
        this.setData(_data);
        this.setMeta(_metaDataResponse);
    }

    public ResponseDto(T _data) {
        this.setData(_data);
    }
}
