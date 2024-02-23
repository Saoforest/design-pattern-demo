package xyz.xiaolinz.demo.chain.mutate.array;

/**
 * @author huangmuhong
 * @date 2024/2/20
 */
public class Main {
    public static void main(String[] args) {
        final HandlerChain handleChain = new HandlerChain();
        handleChain.addHandler(new AHandler());
        handleChain.addHandler(new BHandler());

        handleChain.handle();
    }
}
