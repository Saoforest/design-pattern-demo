package xyz.xiaolinz.demo.state.mario.state;

/**
 * @author huangmuhong
 * @date 2024/2/27
 */
public class MarioDeadState implements MarioState {

    public static final MarioDeadState INSTANCE = new MarioDeadState();

    @Override
    public void eatMushroom(MarioStateMachine stateMachine) {
        System.out.println("已经死了，吃蘑菇无效");
    }

    @Override
    public void eatFireFlower(MarioStateMachine stateMachine) {
        System.out.println("已经死了，吃火花无效");
    }

    @Override
    public void enemyAttack(MarioStateMachine stateMachine) {
        System.out.println("已经死了，被敌人攻击无效");
    }

    @Override
    public void fallIntoPit(MarioStateMachine stateMachine) {
        System.out.println("已经死了，掉进坑里无效");
    }
}
