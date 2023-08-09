package xyz.xiaolinz.demo.decorator.demo1;
/**
 * @author huangmuhong
 * @date 2023/8/9
 */
public class DecoratorTwo extends Decorator {

  public DecoratorTwo(Component component) {
    super(component);
  }

  @Override
  public void operation() {
    System.out.println("装饰器2增强的行为");
    super.operation();
    System.out.println("装饰器2增强的行为");
  }
}
