package org.jcrop;

import java.io.Serializable;

public class PreviewSettings implements Serializable {

    public PreviewSettings(String previewDivName, int previewWidth, int previewHeight) {
        this.previewDivName = previewDivName;
        this.previewWidth = previewWidth;
        this.previewHeight = previewHeight;
    }

    private String previewDivName;
    private int previewWidth = 100;
    private int previewHeight = 100;

    public String getPreviewDivName() {
        return previewDivName;
    }

    public void setPreviewDivName(String previewDivName) {
        this.previewDivName = previewDivName;
    }

    public int getPreviewWidth() {
        return previewWidth;
    }

    public void setPreviewWidth(int previewWidth) {
        this.previewWidth = previewWidth;
    }

    public int getPreviewHeight() {
        return previewHeight;
    }

    public void setPreviewHeight(int previewHeight) {
        this.previewHeight = previewHeight;
    }
}
