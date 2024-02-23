package xyz.xiaolinz.demo.chain.tradition.array;

/**
 * @author huangmuhong
 * @date 2024/2/20
 */
public class AHandler implements Handler {
    @Override
    public boolean handle() {
        System.out.println("AHandler handle");
        boolean handled = false;
        //...
        return handled;
    }
}
