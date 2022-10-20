package com.mxs.huobi.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Util {
    public static String getJsonAsString(String json) throws IOException {
        return new String(Files.readAllBytes(getFile(json).toPath()));
    }

    public static Object getJsonAsObject(String json, Class c) throws IOException {
        return new ObjectMapper().readValue(getFile(json), c);
    }

    private static File getFile(String json) throws IOException {
        return new ClassPathResource(json).getFile();
    }
}
