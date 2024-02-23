package xyz.xiaolinz.demo.chain.tradition.linked;

/**
 * @author huangmuhong
 * @date 2024/2/20
 */
public class Main {
    public static void main(String[] args) {
        final HandleChain handleChain = new HandleChain();
        handleChain.addHandler(new AHandler());
        handleChain.addHandler(new BHandler());

        handleChain.handle();
    }
}
