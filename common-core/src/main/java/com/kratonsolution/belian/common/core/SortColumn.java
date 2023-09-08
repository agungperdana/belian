package com.kratonsolution.belian.common.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.1
 */
@Getter
@AllArgsConstructor
public class SortColumn {

    public static String ASC = "ASC";

    public static String DESC = "DESC";

    @NonNull
    private String name;

    private String type = ASC;
}
