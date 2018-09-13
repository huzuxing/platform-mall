package com.cyc.platform.common.utils;

/**
 * Created by huzuxing on 2017/7/12.
 */
public class StringUtils {

    private StringUtils() {}

    public static boolean isNullOrEmpty(String str) {
        return null == str || "".equals(str);
    }

    public static boolean isNullOrEmpty(String... params) {
        int length = params.length;
        if (length == 0)
            return false;
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            if (StringUtils.isNullOrEmpty(params[i])) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    public static String getFileExit(String fileName) {
        if (isNullOrEmpty(fileName)) {
            return fileName;
        }
        String ext = fileName.substring(fileName.lastIndexOf("\\.") + 1, fileName.length());
        return ext;
    }

    public static String getFileName(String filePath) {
        if (isNullOrEmpty(filePath)) {
            return filePath;
        }
        String fileName = filePath.substring(0, filePath.lastIndexOf("\\."));
        return fileName;
    }
}
