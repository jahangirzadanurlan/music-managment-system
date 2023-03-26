package util;

import model.Music;
import service.impl.MusicServiceImpl;

import java.util.List;

public class Menu {
    public static int homePage() {
        System.out.println("---------| Home Page |---------");
        System.out.println("""
                0.Exit
                1.Edit music
                2.Create playlist
                3.Show""");
        return InputUtil.requiredInputInt("Choose option: ");
    }

    public static int editPage() {
        System.out.println("---------| Edit Music |---------");
        System.out.println("""
                1.Add music
                2.Update music
                3.Remove music""");
        return InputUtil.requiredInputInt("Choose option: ");
    }

    public static int showPage() {
        System.out.println("---------| Show Music |---------");
        System.out.println("""
                1.Show all music
                2.Show music by name
                3.show the songs in the playlist""");
        return InputUtil.requiredInputInt("Choose option: ");
    }

    public static void start() {
        MusicServiceImpl musicService = new MusicServiceImpl();
        while (true) {
            int choose = homePage();
            if (choose == 0) {
                System.exit(-1);
            } else if (choose == 1) {
                int a = editPage();
                if (a == 1) {
                    musicService.addMusic();
                } else if (a == 2) {
                    musicService.updateMusic();
                } else if (a==3){
                    musicService.removeMusic();
                }else {
                    System.out.println("Wrong option!!!");
                }
            } else if (choose==2) {
                musicService.createPlaylist();
            } else if (choose == 3) {
                int a = showPage();
                if (a == 1) {
                    System.out.println("---------------");
                    List<Music> liste=musicService.showAllMusic();
                    if (liste!=null){
                        liste.forEach(i-> System.out.println(i.toString()));
                    }
                    System.out.println("---------------");
                } else if (a == 2) {
                    System.out.println("---------------");
                    musicService.showMusic().forEach(i-> System.out.println(i.toString()));
                    System.out.println("---------------");
                } else if (a==3) {
                    System.out.println("---------------");
                    musicService.showPlaylist().forEach(i-> System.out.println(i.toString()));
                    System.out.println("---------------");
                } else {
                    System.out.println("Wrong option!!!");
                }
            }else {
                System.out.println("Wrong oprion!!!");
            }
        }
    }
}
