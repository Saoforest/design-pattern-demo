package xyz.xiaolinz.demo.decorator.demo1;
/**
 *
 * 具体的装饰器
 * 通过重写父类的方法，实现对父类的功能增强
 *
 * @author huangmuhong
 * @date 2023/8/9
 */
public class DecoratorOne extends Decorator {

  public DecoratorOne(Component component) {
    super(component);
  }

  @Override
  public void operation() {
    System.out.println("装饰器1增强的行为");
    super.operation();
    System.out.println("装饰器1增强的行为");
  }
}
