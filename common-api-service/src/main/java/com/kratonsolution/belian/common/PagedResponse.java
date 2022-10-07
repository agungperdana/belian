package com.kratonsolution.belian.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Getter
@AllArgsConstructor
public class PagedResponse<D> {

    @NonNull
    private List<D> data;

    private int page = 1;

    private int limit = 100;

    private int totalPage = 1;

    private String key;
}
