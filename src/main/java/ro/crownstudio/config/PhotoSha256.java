package ro.crownstudio.config;

import ro.crownstudio.utils.FileTools;

import java.util.Properties;

public class PhotoSha256 extends ConfigBase {

    private static PhotoSha256 INSTANCE;

    private final Properties properties;

    private PhotoSha256() {
        this.properties = loadProperties(FileTools.getFileFromResources("photoHashes.properties"));
    }

    public static PhotoSha256 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PhotoSha256();
        }
        return INSTANCE;
    }

    public String getSha256ForPhotoId(int id) {
        return properties.getProperty(String.valueOf(id));
    }
}
