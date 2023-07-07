package SpringAppTest.MusicExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class MusicPlayer {
    @Autowired
    @Qualifier("rockMusic")
    private Music music;
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    @Autowired
    private List<Music> musicList = new ArrayList<>();

    // IoC
    public MusicPlayer(Music music) {
        setMusic(music);
    } //{this.music = music;}

    public MusicPlayer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void showMusicList() {
        System.out.println("Music List: " + musicList.size() + " entries");
        for (Music music : musicList) {
            System.out.println("\t* " + music.getSong());
        }
    }
}