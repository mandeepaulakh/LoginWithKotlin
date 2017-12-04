package com.dupleit.demo.mapproject.Constant;

import java.util.List;

/**
 * Created by rajesh on 4/11/17.
 */

public class Utils1 {
    public static int parseInt(String value) {
        if (value == null || value.isEmpty()) return 0;
        try {
            return Integer.parseInt(value);
        } catch (Exception exp) {
            return 0;
        }
    }

    public static boolean isListEmpty(Object object) {

        if (object instanceof List) {
            List<Object> data = (List<Object>) object;
            return !(data.size() > 0 && data.get(0) != null);
        }
        return true;
    }
}
