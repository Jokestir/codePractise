package com.example.android.miwok;

public class Word {

    private static final int NO_IMAGE_SPECIFIED = -1;


    private int imageReourceId = NO_IMAGE_SPECIFIED;
    private String englishTranslation;
    private String mowakTranslation;
    private int audioResourceId;

    public Word(String englishTranslation, String mowakTranslation, int imageReourceId, int audioID) {
        this.setImageReourceId(imageReourceId);
        this.setDefaultTranslation(englishTranslation);
        this.setMowakTranslation(mowakTranslation);
        this.audioResourceId = audioID;
    }

    public Word(String englishWord, String mowakWord,int audioId) {
        if (englishWord != null && mowakWord != null) {
            this.englishTranslation = englishWord;
            this.mowakTranslation = mowakWord;
            this.audioResourceId = audioId;
        } else {
            throw new IllegalArgumentException("Both englishword and mowakword should not be null");
        }
    }

    public int getImageReourceId() {
        return imageReourceId;
    }

    public void setImageReourceId(int imageReourceId) {
        this.imageReourceId = imageReourceId;
    }

    public String getDefaultTranslation() {
        return englishTranslation;
    }

    public void setDefaultTranslation(String englishTranslation) {
        if (englishTranslation != null)
            this.englishTranslation = englishTranslation;
        else
            throw new IllegalArgumentException("default word must not be null");
    }

    public String getMowakTranslation() {
        return mowakTranslation;
    }

    public void setMowakTranslation(String mowakTranslation) {
        if (mowakTranslation != null)
            this.mowakTranslation = mowakTranslation;
        else
            throw new IllegalArgumentException("mowakword should not be null");
    }

    public boolean hasImage() {
        return getImageReourceId() != NO_IMAGE_SPECIFIED;
    }

    public int getAudioResourceId() {
        return audioResourceId;
    }

    public void setAudioResourceId(int audioResourceId) {
        this.audioResourceId = audioResourceId;
    }

    @Override
    public String toString() {
        return "Word{" +
                "imageReourceId=" + imageReourceId +
                ", englishTranslation='" + englishTranslation + '\'' +
                ", mowakTranslation='" + mowakTranslation + '\'' +
                ", audioResourceId=" + audioResourceId +
                '}';
    }
}
