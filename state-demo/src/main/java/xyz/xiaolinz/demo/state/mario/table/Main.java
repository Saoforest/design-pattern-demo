package xyz.xiaolinz.demo.state.mario.table;

import xyz.xiaolinz.demo.state.mario.MarioEvent;

/**
 * @author huangmuhong
 * @date 2024/2/27
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
