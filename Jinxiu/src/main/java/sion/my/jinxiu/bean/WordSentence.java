package sion.my.jinxiu.bean;

import java.io.Serializable;

public class WordSentence implements Serializable {
    private int id;
    private String word;
    private String network_cn;
    private String network_en;
    private String tts_mp3;

    @Override
    public String toString() {
        return "WordSentence{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", network_cn='" + network_cn + '\'' +
                ", network_en='" + network_en + '\'' +
                ", tts_mp3='" + tts_mp3 + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getNetwork_cn() {
        return network_cn;
    }

    public void setNetwork_cn(String network_cn) {
        this.network_cn = network_cn;
    }

    public String getNetwork_en() {
        return network_en;
    }

    public void setNetwork_en(String network_en) {
        this.network_en = network_en;
    }

    public String getTts_mp3() {
        return tts_mp3;
    }

    public void setTts_mp3(String tts_mp3) {
        this.tts_mp3 = tts_mp3;
    }
}
