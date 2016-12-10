package com.geography.localize.manager;

import com.geography.localize.domain.Locality;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kazimirov
 */
public interface GeolocationManager {
    
   Map<String, Locality> getLocalities(List<String> localityNames);
}
