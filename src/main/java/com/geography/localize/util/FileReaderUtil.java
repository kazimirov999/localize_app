package com.geography.localize.util;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Kazimirov
 */
public final class FileReaderUtil {

    private FileReaderUtil() {
    }

    public static List<String> readFileByLine(File file) {
        List<String> result = new LinkedList<>();
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
            String line = null;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException ex) {
            throw new RuntimeException("File error:  " + ex);

        }
        return result;
    }

    public static List<String> readFileByLine(InputStream inputStream) {
        List<String> result = new LinkedList<>();
        try (InputStream is = inputStream; BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                result.add(line.trim());
            }
        } catch (IOException ex) {
            throw new RuntimeException("File error:  " + ex);

        }
        return result;
    }
}
