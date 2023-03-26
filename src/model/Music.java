package model;

import java.time.LocalDate;

public class Music {
    private int musicId;
    private String musicName;
    private String musicAuthor;
    private LocalDate musicDate;
    private String playlistName;

    public Music(int musicId, String musicName, String musicAuthor, LocalDate musicDate, String playlistName) {
        this.musicId = musicId;
        this.musicName = musicName;
        this.musicAuthor = musicAuthor;
        this.musicDate = musicDate;
        this.playlistName = playlistName;
    }

    public Music(int musicId, String musicName, String musicAuthor, LocalDate musicDate) {
        this.musicId = musicId;
        this.musicName = musicName;
        this.musicAuthor = musicAuthor;
        this.musicDate = musicDate;
    }

    public Music(String musicName, String musicAuthor, LocalDate musicDate) {
        this.musicName = musicName;
        this.musicAuthor = musicAuthor;
        this.musicDate = musicDate;
    }

    public Music() {
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicAuthor() {
        return musicAuthor;
    }

    public void setMusicAuthor(String musicAuthor) {
        this.musicAuthor = musicAuthor;
    }

    public LocalDate getMusicDate() {
        return musicDate;
    }

    public void setMusicDate(LocalDate musicDate) {
        this.musicDate = musicDate;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    @Override
    public String toString() {
        return "Music{" +
                "musicId=" + musicId +
                ", musicName='" + musicName + '\'' +
                ", musicAuthor='" + musicAuthor + '\'' +
                ", musicDate=" + musicDate +
                '}';
    }
}
