package com.geography.localize.service;

import com.geography.localize.domain.Geolocation;
import com.geography.localize.domain.Locality;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import javax.ws.rs.core.MediaType;
import org.apache.http.client.utils.URIBuilder;

/**
 *
 * @author Kazimirov
 */
public class LocalityGeocodingService implements LocalityService {

    public static final String GOOGLE_API_HOST = "maps.googleapis.com";
    public static final String GOOGLE_GEOCODE_PATH = "/maps/api/geocode/json";
    public static final String LOCALITY_ADDRESS = "address";
    public static final String PROTOCOLE = "https";

    private final Client client;

    public LocalityGeocodingService() {
        this(createClient());
    }

    public LocalityGeocodingService(Client client) {
        this.client = client;
    }

    @Override
    public Locality findLocality(String localityName) {
        Geolocation geolocation = null;
        WebResource webResource = client.resource(buildUrlForGoogleGeocodeService(localityName));
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        geolocation = response.getEntity(Geolocation.class);
        return geolocation.getLocalities().get(0);
    }

    private String buildUrlForGoogleGeocodeService(String localityName) {
        URIBuilder builder = new URIBuilder()
                .setScheme(PROTOCOLE)
                .setHost(GOOGLE_API_HOST)
                .setPath(GOOGLE_GEOCODE_PATH)
                .setParameter(LOCALITY_ADDRESS, localityName);
        return builder.toString();
    }

    private static Client createClient() {
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
                Boolean.TRUE);
        return Client.create(clientConfig);
    }
}
