package service.impl;

import model.Music;
import repository.MusicRepository;
import repository.impl.MusicRepositoryImpl;
import service.MusicService;
import util.InputUtil;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class MusicServiceImpl implements MusicService {
    private final MusicRepository musicRepository;

    public MusicServiceImpl(){
        musicRepository=new MusicRepositoryImpl();
    }

    @Override
    public void addMusic() {
        musicRepository.addMusic(fillMusic());
        System.out.println("----------| Adding is succesfully |--------");
    }

    private Music fillMusic() {
        String musicName= InputUtil.requiredInputString("Enter Music name: ");
        String musicAuthor= InputUtil.requiredInputString("Enter Music signer: ");
        LocalDate musicDate= InputUtil.requiredInputDate("Enter Music date: ");

        return new Music(musicName,musicAuthor,musicDate);
    }

    @Override
    public void removeMusic() {
        String name=InputUtil.requiredInputString("Enter the name of the book you want to delete: ");

        MusicServiceImpl musicService=new MusicServiceImpl();
        List<Music> music=musicService.showAllMusic();
        Optional<Music> optionalMusic=music.stream().filter(i->i.getMusicName().equals(name)).findFirst();

        if (optionalMusic.isPresent()){
            musicRepository.removeMusic(name);
            System.out.println("----------| Removing is succesfully |--------");
        }else{
            System.out.println("There is no book with this name...");
        }
    }

    @Override
    public void updateMusic() {
        String name=InputUtil.requiredInputString("Enter the name of the book to be updated: ");

        MusicServiceImpl musicService=new MusicServiceImpl();
        List<Music> music=musicService.showAllMusic();
        Optional<Music> optionalMusic=music.stream().filter(i->i.getMusicName().equals(name)).findFirst();

        if (optionalMusic.isPresent()){
            musicRepository.updateMusic(name,fillMusic());
        }else{
            System.out.println("There is no book with this name...");
        }

    }

    @Override
    public void createPlaylist() {
        MusicServiceImpl musicService=new MusicServiceImpl();
        int idB=musicService.showAllMusic().size();

        String playlistName=InputUtil.requiredInputString("Enter playlist name: ");
        int count=InputUtil.requiredInputInt("How much music do you want to add: ");
        for (int i = 0; i < count; i++) {
            int id= InputUtil.requiredInputInt("Enter Music id: ");
            if (id<=idB){
                musicRepository.createPlaylist(playlistName,id);
                System.out.println("----------| Adding is succesfully |--------");
            }else{
                System.out.println("There is no such id");
            }
        }

    }

    @Override
    public List<Music> showAllMusic() {
        return musicRepository.showAllMusic();
    }

    @Override
    public List<Music> showMusic() {
        String name=InputUtil.requiredInputString("Enter the name of the music you want to see information about: ");
        return musicRepository.showMusic(name);
    }

    @Override
    public List<Music> showPlaylist() {
        String name=InputUtil.requiredInputString("Enter the name of the playlist you want to see information about: ");
        return musicRepository.showPlaylist(name);
    }

}
