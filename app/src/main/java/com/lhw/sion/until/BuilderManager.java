package com.lhw.sion.until;

import com.hjq.demo.R;



public class BuilderManager {
    private BuilderManager(){

    }
    private static BuilderManager ourInstance = new BuilderManager();
    public static BuilderManager getInstance() {
        return ourInstance;
    }
    private static int[] imageResources = new int[] {
            R.drawable.icon_send, R.drawable.icon_cammer, R.drawable.icon_scissors,


    };

    private static int[] textResources = new int[] {
          R.string.a, R.string.b, R.string.c
    };
    private static int imageResourceIndex = 0;
    private static int textResourceIndex = 0;
    public static int getImageResource() {
        if (imageResourceIndex >= imageResources.length)
            imageResourceIndex = 0;
        return imageResources[imageResourceIndex++];
    }
    public static int getTextResource() {
        if (textResourceIndex >= textResources.length)
            textResourceIndex = 0;
        return textResources[textResourceIndex++];
    }
}
