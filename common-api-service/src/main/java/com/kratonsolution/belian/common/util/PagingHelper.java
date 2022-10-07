package com.kratonsolution.belian.common.util;

import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Optional;

public class PagingHelper {

    public static final String PAGE_PARAM = "page";

    public static final String LIMIT_PARAM = "limit";

    public static int getPage(ServerRequest request) {
        return NumberHelper.toInt(request.pathVariable(PAGE_PARAM), 1);
    }

    public static int getLimit(ServerRequest request) {
        return NumberHelper.toInt(request.pathVariable(LIMIT_PARAM), 100);
    }

    public static int getOffset(ServerRequest request) {
        return (getPage(request)-1)*getLimit(request);
    }

    public static int getTotalPage(int totalRows, ServerRequest request) {

        int mod = totalRows%getLimit(request);
        return ((totalRows-mod)/getLimit(request))+(mod>0?1:0);
    }
}
