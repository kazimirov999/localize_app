package com.geography.localize.manager;

import com.geography.localize.domain.Locality;
import com.geography.localize.service.LocalityService;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class GoogleGeolocationManager implements GeolocationManager {

    private final LocalityService localityService;

    public GoogleGeolocationManager(LocalityService localityService) {
        this.localityService = localityService;
    }

    @Override
    public Map<String, Locality> getLocalities(List<String> localityNames) {
        Map<String, Locality> result = new TreeMap<>();
        for (String localityName : localityNames) {
            result.put(localityName, localityService.findLocality(localityName));
        }
        return result;
    }

}
