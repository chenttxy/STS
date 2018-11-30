package com.sts.model;

public class Images {
    private Integer imagesId;

    private String path1;

    private String path2;

    private String path3;

    private String path4;

    private String path5;

    public Integer getImagesId() {
        return imagesId;
    }

    public void setImagesId(Integer imagesId) {
        this.imagesId = imagesId;
    }

    public String getPath1() {
        return path1;
    }

    public void setPath1(String path1) {
        this.path1 = path1 == null ? null : path1.trim();
    }

    public String getPath2() {
        return path2;
    }

    public void setPath2(String path2) {
        this.path2 = path2 == null ? null : path2.trim();
    }

    public String getPath3() {
        return path3;
    }

    public void setPath3(String path3) {
        this.path3 = path3 == null ? null : path3.trim();
    }

    public String getPath4() {
        return path4;
    }

    public void setPath4(String path4) {
        this.path4 = path4 == null ? null : path4.trim();
    }

    public String getPath5() {
        return path5;
    }

    public void setPath5(String path5) {
        this.path5 = path5 == null ? null : path5.trim();
    }
}