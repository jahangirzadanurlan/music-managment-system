package repository;

import model.Music;

import java.util.List;

public interface MusicRepository {
    boolean addMusic(Music music);
    boolean removeMusic(String musicName);
    boolean updateMusic(String musicName,Music music);
    boolean createPlaylist(String playlist,int musicId);
    List<Music> showAllMusic();
    List<Music> showMusic(String musicName);
    List<Music> showPlaylist(String playlistName);

}
