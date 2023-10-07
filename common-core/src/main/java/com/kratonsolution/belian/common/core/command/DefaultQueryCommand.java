package com.kratonsolution.belian.common.core.command;

import com.kratonsolution.belian.common.core.FilteredColumn;
import com.kratonsolution.belian.common.core.SortColumn;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.1
 */
@Getter
@Setter
public class DefaultQueryCommand implements QueryCommand {

    private boolean pagingEnabled = false;

    private List<FilteredColumn> filteredColumns = new ArrayList<>();

    private List<SortColumn> sortColumns = new ArrayList<>();

    private Optional<Integer> offset = Optional.of(0);

    private Optional<Integer> limit = Optional.of(100);


}
