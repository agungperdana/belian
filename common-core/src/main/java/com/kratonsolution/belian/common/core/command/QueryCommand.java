package com.kratonsolution.belian.common.core.command;

import com.kratonsolution.belian.common.core.FilteredColumn;
import com.kratonsolution.belian.common.core.SortColumn;

import java.util.List;
import java.util.Optional;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.1
 */
public interface QueryCommand {

    Optional<Integer> getOffset();

    Optional<Integer> getLimit();

    List<FilteredColumn> getFilteredColumns();

    List<SortColumn> getSortColumns();

    public boolean isPagingEnabled();
}
