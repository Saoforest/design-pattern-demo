package xyz.xiaolinz.demo.state.mario.state;

/**
 * @author huangmuhong
 * @date 2024/2/27
 */
public class Main {
    public static void main(String[] args) {
        MarioStateMachine mario = new MarioStateMachine();
        mario.eatFireFlower();
        mario.eatMushroom();
        mario.enemyAttack();
        mario.fallIntoPit();

        System.out.println("当前状态: " + mario.getCurrentState());
    }
}
