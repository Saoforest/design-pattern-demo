package xyz.xiaolinz.demo.combination;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文件夹
 *
 * @author huangmuhong
 * @date 2023/11/30
 * @version 1.0.0
 * @see FileSystem
 */
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class Folder implements FileSystem {

  private String folderName;

  private List<FileSystem> fileSystemList;

  public Folder(String folderName) {
    this.folderName = folderName;
    fileSystemList = new ArrayList<>();
  }

  public void add(FileSystem fileSystem) {
    fileSystemList.add(fileSystem);
  }

  @Override
  public void display() {
    System.out.println("文件夹名：" + folderName);
    for (FileSystem fileSystem : fileSystemList) {
      fileSystem.display();
    }
  }
}
