package xyz.xiaolinz.demo.prototype.shallowcopy;

import java.io.Serializable;

/**
 * demo2 - 浅拷贝实现，实现Cloneable接口，重写clone方法
 *
 * <p>1. 实现Cloneable接口 2. 重写clone方法 3. 重写clone方法时，调用父类的clone方法 4. 重写clone方法时，将返回值强转为当前类
 *
 * @author huangmuhong
 * @date 2023/8/8
 */
public class PlayListCloneable extends PlayList implements Cloneable, Serializable {

  public static void main(String[] args){
    PlayListCloneable playListCloneable = new PlayListCloneable();

    try {
      PlayListCloneable clone = (PlayListCloneable) playListCloneable.clone();
      System.out.println(playListCloneable == clone);
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
