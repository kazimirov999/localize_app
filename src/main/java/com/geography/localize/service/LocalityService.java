package com.geography.localize.service;

import com.geography.localize.domain.Locality;

/**
 *
 * @author Kazimirov
 */
public interface LocalityService {
    
    Locality findLocality(String localityName);
}
