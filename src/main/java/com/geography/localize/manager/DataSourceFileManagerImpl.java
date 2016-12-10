package com.geography.localize.manager;

import com.geography.localize.util.FileReaderUtil;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public class DataSourceFileManagerImpl implements DataSourceManager {

    public static final String DEFAULT_FILE_PATH = "testFile.txt";
    private File file;
    private InputStream inputStream;

    public DataSourceFileManagerImpl(File file) {
        this.file = file;
    }

    public DataSourceFileManagerImpl(String filePath) {
        this(new File(filePath));
    }

    public DataSourceFileManagerImpl() {
        this.inputStream = getInputStreamForDefaultFile();
    }

    @Override
    public List<String> getLocalitiesNames() {
        return file == null ? FileReaderUtil.readFileByLine(inputStream) : FileReaderUtil.readFileByLine(file);
    }

    private InputStream getInputStreamForDefaultFile() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            classLoader = Class.class.getClassLoader();
        }
        return classLoader.getResourceAsStream(DEFAULT_FILE_PATH);
    }
}
