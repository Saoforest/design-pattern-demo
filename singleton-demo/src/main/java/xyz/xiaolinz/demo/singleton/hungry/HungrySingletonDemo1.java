package xyz.xiaolinz.demo.singleton.hungry;
/**
 *
 * 创建型设计模式 - 单例模式 - 饿汉式
 * 1. 持有一个 jvm 全局唯一的实例
 * 2. 避免别人随意的创建单例对象，需要私有化构造器
 * 3. 暴露一个方法用于获取全局唯一实例
 *
 * 优点：
 *  1. 创建对象本身的复杂度：很多单例的对象创建过程极其复杂；很多单例对象创建会占用很大内存，比如缓存对象；很多单例对象创建完成后可能很小且简单
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/7/25
 */
public class HungrySingletonDemo1 {

  // idea 1
  private static final HungrySingletonDemo1 instance = new HungrySingletonDemo1();


  // idea 2
  private HungrySingletonDemo1() {}


  // idea 3
  public static HungrySingletonDemo1 getInstance() {
    return instance;
  }

}
