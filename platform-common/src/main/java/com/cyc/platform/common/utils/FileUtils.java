package com.cyc.platform.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by huzuxing on 2018/6/26.
 */
public class FileUtils {

    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static String getExt(String fileName) {
        if (StringUtils.isNullOrEmpty(fileName) || -1 == fileName.indexOf(".")) {
            return "";
        }
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        return ext;
    }

    public static String upload(MultipartFile file, String savePath) {

        if (null == file || StringUtils.isNullOrEmpty(savePath)) {
            return "";
        }
        String ext = getExt(file.getOriginalFilename());
        String saveFileName = StringUtils.getUuidWithoutCrossLine() + "." + ext;
        String filePath = savePath + File.separator + saveFileName;
        File saveFile = new File(filePath);
        if (!saveFile.exists() || !saveFile.getParentFile().isDirectory()) {
            saveFile.getParentFile().mkdirs();
        }
        InputStream is = null;
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        try {
            is = file.getInputStream();
            fos = new FileOutputStream(saveFile);
            bos = new BufferedOutputStream(fos);
            int len = 0;
            byte[] array = new byte[1024];
            while (-1 != (len = is.read(array))) {
                bos.write(array, 0, len);
            }
            bos.flush();
        } catch (IOException e) {
            logger.error("", e);
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    ;
                }
            }
            if (null != bos) {
                try {
                    bos.close();
                } catch (IOException e) {
                    ;
                }
            }
            if (null != fos) {
                try {
                    fos.close();
                } catch (IOException e) {
                    ;
                }
            }
        }

        return saveFileName;
    }

}
