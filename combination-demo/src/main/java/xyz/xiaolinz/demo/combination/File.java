package xyz.xiaolinz.demo.combination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 文件
 *
 * @author huangmuhong
 * @date 2023/11/30
 * @version 1.0.0
 * @see FileSystem
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class File implements FileSystem {


  private String fileName;

  private Long fileSize;


  @Override
  public void display() {
    System.out.println("文件名：" + fileName + "，文件大小：" + fileSize);
  }
}
