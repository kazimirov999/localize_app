package com.geography.localize;

import com.geography.localize.domain.Locality;
import com.geography.localize.manager.DataSourceFileManagerImpl;
import com.geography.localize.manager.DataSourceManager;
import com.geography.localize.manager.GoogleGeolocationManager;
import com.geography.localize.service.LocalityGeocodingService;
import com.geography.localize.manager.GeolocationManager;
import com.geography.localize.presenter.ConsolePresenter;
import com.geography.localize.presenter.Presenter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 *
 * @author Kazimirov
 */
public class Launcher {

    private  void startApp(String filePath) {
        Presenter presenter = new ConsolePresenter();
        DataSourceManager dsManager = (filePath == null || filePath.isEmpty())
                ? new DataSourceFileManagerImpl()
                : new DataSourceFileManagerImpl(filePath);
        try {
            GeolocationManager glManager = new GoogleGeolocationManager(new LocalityGeocodingService());
            Map<String, Locality> localities = glManager.getLocalities(dsManager.getLocalitiesNames());
            presenter.showLocalities(localities);
        } catch (Exception e) {
            presenter.showMessage(e.getMessage());
        }

    }

    public static void main(String[] args) {
        new Launcher().startApp(args.length > 0 ? args[0] : null);
    }
}
