package com.kratonsolution.belian.common.core.settings;

import lombok.Data;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.1
 */
@Data
public class DefaultGeneralSettings implements GeneralSettings {

    private String language = DefaultLanguage.US_ENGLISH;

    private String localTime = DefaultTime.UTC;
}
