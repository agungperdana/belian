package com.kratonsolution.belian.geographic.api.application;

import java.util.List;

import com.kratonsolution.belian.geographic.api.GeographicData;
import com.kratonsolution.belian.geographic.api.GeographicType;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0
 */
public interface GeographicService {
   
    GeographicData create(@NonNull GeographicCreateCommand command);
    
    GeographicData update(@NonNull GeographicUpdateCommand command);
    
    GeographicData delete(@NonNull GeographicDeleteCommand command);

    GeographicData getByCode(@NonNull String code);
    
    List<GeographicData> getAllGeographics();
    
    List<GeographicData> getAllGeographicRoots();

    List<GeographicData> getAllGeographics(@NonNull GeographicFilter filter);
    
    List<GeographicData> getAllGeographics(int page, int size);
    
    List<GeographicData> getAllGeographics(@NonNull GeographicFilter filter, int page, int size);
    
    List<GeographicData> getAllByType(@NonNull GeographicType type);
    
    int count();
    
    int count(@NonNull GeographicFilter filter);
}
