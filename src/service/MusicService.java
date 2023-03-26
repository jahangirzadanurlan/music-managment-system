package service;

import model.Music;

import java.util.List;

public interface MusicService {
    void addMusic();
    void removeMusic();
    void updateMusic();
    void createPlaylist();
    List<Music> showAllMusic();
    List<Music> showMusic();
    List<Music> showPlaylist();

}
