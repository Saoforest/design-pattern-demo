package xyz.xiaolinz.demo.adapter.objectadapter;

/**
 * 类适配器模式 - 适配器角色
 *
 * <p>适配器角色是适配器模式的核心，它是适配器模式的重点。 适配器模式的实现方式有两种：类适配器和对象适配器。 对象适配器模式是适配器模式常见的实现方式，通过组合的方式实现。
 *
 * <p>适配器模式的优点： 1. 适配器模式可以让两个没有任何关系的类在一起运行，只要适配器角色能够搞定他们就成。 2.
 * 增加了类的透明性，客户端只需要访问目标角色，对于如何适配目标角色的具体行为则透明。 3. 提高了类的复用度，适配器角色可以重复使用，而不是每次都重新写适配器。 4.
 * 灵活性好，适配器角色不仅可以适配类，还可以适配对象。
 *
 * @author huangmuhong
 * @date 2023/08/10
 * @version 1.0.0
 */
public class ClassAdapter implements Target {

  protected Adapter adapter;

  public ClassAdapter(Adapter adapter) {
    this.adapter = adapter;
  }

  @Override
  public void request() {
    // 这里是对需要适配的类的方法进行调用
    adapter.specificRequest();
  }
}
