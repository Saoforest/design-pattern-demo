package xyz.xiaolinz.demo.state.mario.condition;

/**
 * @author huangmuhong
 * @date 2024/2/26
 */
public class Main {
    public static void main(String[] args) {
        final Mario mario = new Mario();
        mario.handleEvent(MarioEvent.MUSHROOM);
        mario.handleEvent(MarioEvent.FIRE_FLOWER);
        mario.handleEvent(MarioEvent.ENEMY_ATTACK);
        mario.handleEvent(MarioEvent.FALL_INTO_PIT);

        System.out.println("mario = " + mario.getCurrentState());
    }
}
