package queries;

public class MusicQuery {

    public static final String ADD_MUSIC="INSERT INTO music(music_name,music_author,music_date) "+
            "VALUES(?,?,?)";
    public static final String REMOVE_MUSIC="UPDATE music SET music_status=0 WHERE music_name=?";
    public static final String UPDATE_MUSIC="UPDATE music SET music_name=?,music_author=? WHERE music_name=?";

    public static final String CREATE_PLAYLIST="INSERT INTO playlist(playlist_name,music_id) "+
            "VALUES(?,?)";

    public static final String SHOW_ALL_MUSIC="SELECT * FROM music";
    public static final String SHOW_MUSIC="SELECT * FROM music WHERE music_name=?";
    public static final String SHOW_PLAYLIST="SELECT m.id, m.music_name, m.music_author, m.music_date " +
            "FROM playlist p " +
            "JOIN music m ON p.music_id = m.id " +
            "WHERE p.playlist_name =? " +
            "ORDER BY m.id; ";

}
