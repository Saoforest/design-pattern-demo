package xyz.xiaolinz.demo.decorator.demo1;
/**
 * 装饰器设计模式
 * 1. 使用组合的方式，实现对被装饰对象的功能增强
 * 2. 装饰器和被装饰对象实现同一个接口，方便扩展
 * 3. 定义通用的抽象装饰器，方便扩展
 *
 * @author huangmuhong
 * @date 2023/8/9
 */
public abstract class Decorator implements Component {

  protected final Component component;

  public Decorator(Component component) {
    this.component = component;
  }

  @Override
  public void operation() {
    component.operation();
  }
}
