package com.example.abdul.wishlistappv1.data;

/**
 * Created by simonkent on 08/12/2016.
 */
public class Music {
    private String artistDescription;
    // TODO change this from an int to the actual image data, because this is a horrible hack!!!
    private int image;

    public Music(String description, int image) {
        this.artistDescription = description;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public String getArtistDescription() {
        return artistDescription;
    }
}
