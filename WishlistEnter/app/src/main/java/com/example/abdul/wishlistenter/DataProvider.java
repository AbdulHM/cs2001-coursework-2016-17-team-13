package com.example.abdul.wishlistenter;

/**
 * Created by Abdul on 26/02/2017.
 */

public class DataProvider {

    public DataProvider(int img_res, String mediaName){

        this.setImg_res(img_res);
        this.setMediaName(mediaName);
    }

    private int img_res;
    private String mediaName;


    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public int getImg_res() {
        return img_res;
    }

    public void setImg_res(int img_res) {
        this.img_res = img_res;
    }
}
