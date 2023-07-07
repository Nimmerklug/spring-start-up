package SpringAppTest.MusicExample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(
                MusicConfig.class);

        //Music music = context.getBean("musicBean", Music.class);
        //MusicPlayer musicPlayer = new MusicPlayer(music);
        MusicPlayer musicPlayer1 = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer musicPlayer2 = context.getBean("musicPlayer", MusicPlayer.class);

        System.out.println("Is it the same Music Player? " + (musicPlayer1 == musicPlayer2) + "\n" +
                (musicPlayer1) + "\n" +
                (musicPlayer2) + "\n");

        musicPlayer2.setVolume(10);

        System.out.println("Music Player Name: " + musicPlayer1.getName());
        System.out.println("Music Player Volume: " + musicPlayer1.getVolume());

        musicPlayer1.playMusic();
        musicPlayer1.showMusicList();

        System.out.println("\n" + ("*".repeat(100)) + "\n");

        System.out.println("Music Player Name: " + musicPlayer2.getName());
        System.out.println("Music Player Volume: " + musicPlayer2.getVolume());

        musicPlayer2.playMusic();
        musicPlayer2.showMusicList();

        context.close();
    }
}

