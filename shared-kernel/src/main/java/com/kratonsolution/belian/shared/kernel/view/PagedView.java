package com.kratonsolution.belian.shared.kernel.view;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Getter
@Builder
public class PagedView <D>{

    @NonNull
    private List<D> data;

    @Builder.Default
    private int page = 1;

    @Builder.Default
    private int pages = 1;

    @Builder.Default
    private int limit = 100;

    private String key;
}
