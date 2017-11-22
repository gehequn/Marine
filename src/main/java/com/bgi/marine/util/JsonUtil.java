package com.bgi.marine.util;

import java.lang.reflect.Type;
import com.google.gson.Gson;

public class JsonUtil {

    private static Gson json = new Gson();

    public static String parseJson(Object value) throws Exception {
        String str = json.toJson(value);
        return str;
    }

    public static Object JsonToList(String content, Type type) throws Exception {
            return json.fromJson(content, type);
    }
}
