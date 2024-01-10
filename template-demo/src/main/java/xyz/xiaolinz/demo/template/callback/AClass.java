package xyz.xiaolinz.demo.template.callback;

/**
 * @author huangmuhong
 * @date 2024/1/8
 */
public class AClass {

    /**
     * 过程
     *
     * @param callBack 回调
     * @author huangmuhong
     * @date 2024/01/08
     * @since 1.0.0
     */
    public void process(CallBack callBack) {
        // 定义算法骨架,并动态调用回调实现模板设计模式对方法的扩展
        System.out.println("AClass.process");
        callBack.call();
        System.out.println("AClass.process");
    }

}
