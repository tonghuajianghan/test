package com.opensymphony.xwork2.util.fs;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Represents file resource revision, used for file://* resources
 */
class FileRevision extends Revision {
    private File file;
    private long lastModified;

    public FileRevision(File file, long lastUpdated) {
        if (file == null) {
            throw new IllegalArgumentException("File cannot be null");
        }

        this.file = file;
        this.lastModified = lastUpdated;
    }

    public File getFile() {
        return file;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    public long getLastModified() {
        return lastModified;
    }

    public boolean needsReloading() {
        return this.lastModified < this.file.lastModified();
    }

    public static Revision build(URL fileUrl) {
        File file;
        try {
            file = new File(fileUrl.toURI());
        } catch (URISyntaxException e) {
            file = new File(fileUrl.getPath());
        }  catch (Throwable t) {
            return null;
        }
        if (file.exists() && file.canRead()) {
            long lastModified = file.lastModified();
            return new FileRevision(file, lastModified);
        }
        return null;
    }
}
