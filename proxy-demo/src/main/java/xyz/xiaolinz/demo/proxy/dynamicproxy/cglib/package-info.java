/**
 * CGLIB动态代理
 *
 * <p>CGLIB动态代理是通过继承的方式实现的，它是针对类实现代理的，原理是对指定的目标类生成一个子类， 并覆盖其中方法实现增强，但因为采用的是继承，所以不能对final修饰的类进行代理。
 * 这里的例子使用 Spring 的 Enhancer 来实现 CGLIB 动态代理。
 *
 * @author huangmuhong
 * @date 2023/8/8
 */
package xyz.xiaolinz.demo.proxy.dynamicproxy.cglib;
