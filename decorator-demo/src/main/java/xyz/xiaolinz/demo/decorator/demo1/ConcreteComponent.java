package xyz.xiaolinz.demo.decorator.demo1;
/**
 * @author huangmuhong
 * @date 2023/8/9
 */
public class ConcreteComponent implements Component {

  @Override
  public void operation() {
    System.out.println("未被装饰的操作");
  }
}
