package xyz.xiaolinz.demo.combination;

/**
 * @author huangmuhong
 * @date 2023/11/30
 */
public class Main {

  public static void main(String[] args) {
    Folder fileSystem = new Folder("root");
    fileSystem.add(new File("file1", 1024L));
    fileSystem.add(new File("file2", 1024L));
    fileSystem.add(new File("file3", 1024L));

    Folder folder1 = new Folder("folder1");
    folder1.add(new File("file4", 1024L));
    folder1.add(new File("file5", 1024L));
    folder1.add(new File("file6", 1024L));

    fileSystem.add(folder1);

    fileSystem.display();
  }

}
