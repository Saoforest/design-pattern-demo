package xyz.xiaolinz.demo.adapter.objectadapter;

/**
 * @author huangmuhong
 * @date 2023/8/10
 */
public class Main {
  public static void main(String[] args){
    final var adapter = new Adapter();
    Target target = new ObjectAdapter(adapter);
    target.request();
  }
}
