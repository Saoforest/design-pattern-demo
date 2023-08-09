package xyz.xiaolinz.demo.decorator.demo1;
/**
 * @author huangmuhong
 * @date 2023/8/9
 */
public class Main {
  public static void main(String[] args){
    // 1.创建原始对象
    final var concreteComponent = new ConcreteComponent();
    // 2.创建装饰器
    final var decoratorOne = new DecoratorOne(concreteComponent);
    final var decoratorTwo = new DecoratorTwo(decoratorOne);
    // 3.执行装饰器的操作
    decoratorTwo.operation();
  }
}
