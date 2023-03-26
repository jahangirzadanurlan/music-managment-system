package repository.impl;

import model.Music;
import queries.MusicQuery;
import repository.MusicRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static repository.DBConnection.connect;

public class MusicRepositoryImpl implements MusicRepository {
    Music music=new Music();
    @Override
    public boolean addMusic(Music music) {
        try(Connection connection=connect()) {
            PreparedStatement preparedStatement=connection.prepareStatement(MusicQuery.ADD_MUSIC);
            preparedStatement.setString(1,music.getMusicName());
            preparedStatement.setString(2,music.getMusicAuthor());
            preparedStatement.setDate(3, Date.valueOf(music.getMusicDate()));

            int val=preparedStatement.executeUpdate();
            return val>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeMusic(String musicName) {
        try(Connection connection=connect()) {
            PreparedStatement preparedStatement=connection.prepareStatement(MusicQuery.REMOVE_MUSIC);
            preparedStatement.setString(1,musicName);

            int val=preparedStatement.executeUpdate();
            return val>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateMusic(String musicName, Music music) {
        try(Connection connection=connect()) {
            PreparedStatement preparedStatement=connection.prepareStatement(MusicQuery.UPDATE_MUSIC);

            preparedStatement.setString(1,music.getMusicName());
            preparedStatement.setString(2,music.getMusicAuthor());
            preparedStatement.setString(3,musicName);

            int val=preparedStatement.executeUpdate();
            return val>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean createPlaylist(String playlistName,int musicId) {
        try(Connection connection=connect()) {
            PreparedStatement preparedStatement=connection.prepareStatement(MusicQuery.CREATE_PLAYLIST);
            preparedStatement.setString(1,playlistName);
            preparedStatement.setInt(2,musicId);

            int val=preparedStatement.executeUpdate();
            return val>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Music> showAllMusic() {
        try(Connection connection=connect()) {
            PreparedStatement preparedStatement=connection.prepareStatement(MusicQuery.SHOW_ALL_MUSIC);

            List<Music> musics=new LinkedList<>();
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("music_name");
                String author=resultSet.getString("music_author");
                Date date=resultSet.getDate("music_date");

                musics.add(new Music(id,name,author,date.toLocalDate()));
            }
            return musics;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Music> showMusic(String musicName) {
        try(Connection connection=connect()) {
            PreparedStatement preparedStatement=connection.prepareStatement(MusicQuery.SHOW_MUSIC);
            preparedStatement.setString(1,musicName);

            List<Music> musics=new LinkedList<>();
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("music_name");
                String author=resultSet.getString("music_author");
                Date date=resultSet.getDate("music_date");

                musics.add(new Music(id,name,author,date.toLocalDate()));
            }
            return musics;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Music> showPlaylist(String playlistName) {
        try(Connection connection=connect()) {
            PreparedStatement preparedStatement=connection.prepareStatement(MusicQuery.SHOW_PLAYLIST);
            preparedStatement.setString(1,playlistName);

            List<Music> musics=new LinkedList<>();
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("music_name");
                String author=resultSet.getString("music_author");
                Date date=resultSet.getDate("music_date");

                musics.add(new Music(id,name,author,date.toLocalDate()));
            }
            return musics;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
