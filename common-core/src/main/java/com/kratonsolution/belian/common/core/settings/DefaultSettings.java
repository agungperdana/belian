package com.kratonsolution.belian.common.core.settings;

import lombok.Data;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.1
 */
@Data
public class DefaultSettings implements Settings {

    private GeneralSettings generalSettings = new DefaultGeneralSettings();
}
