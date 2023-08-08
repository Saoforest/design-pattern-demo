package xyz.xiaolinz.demo.prototype.shallowcopy;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * demo1 - 浅拷贝实现，通过直接赋值实现
 *
 * @author huangmuhong
 * @date 2023/8/8
 */
@Data
@NoArgsConstructor
public class PlayList {

  private Long id;

  private String name;

  private List<Song> songs = new ArrayList<>();

  public PlayList(PlayList playList) {
    this.id = playList.id;
    this.name = playList.name;
    this.songs = playList.songs;
  }

  public static void main(String[] args){
    final var playList = new PlayList();
    playList.setId(1L);
    playList.setName("My Favorite");
    playList.addSong(new Song("song1", "artist1"));
    playList.addSong(new Song("song2", "artist2"));
    playList.addSong(new Song("song3", "artist3"));
    System.out.println(playList);

    // 浅拷贝
    final var playListCopy = new PlayList(playList);
    playListCopy.setName("My Favorite Copy");
    System.out.println(playListCopy);
  }

  public void addSong(Song song) {
    songs.add(song);
  }
}
