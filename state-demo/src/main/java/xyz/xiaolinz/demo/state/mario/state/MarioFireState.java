package xyz.xiaolinz.demo.state.mario.state;

/**
 * @author huangmuhong
 * @date 2024/2/27
 */
public class MarioFireState implements MarioState {

    public static final MarioFireState INSTANCE = new MarioFireState();

    @Override
    public void eatMushroom(MarioStateMachine stateMachine) {
        System.out.println("已经是火焰马里奥了，吃蘑菇无效");
    }

    @Override
    public void eatFireFlower(MarioStateMachine stateMachine) {
        System.out.println("已经是火焰马里奥了，吃火花无效");
    }

    @Override
    public void enemyAttack(MarioStateMachine stateMachine) {
        System.out.println("被敌人攻击，变为小马里奥");
        stateMachine.setCurrentState(MarioSmallState.INSTANCE);
    }

    @Override
    public void fallIntoPit(MarioStateMachine stateMachine) {
        System.out.println("掉进坑里，直接死掉");
        stateMachine.setCurrentState(MarioDeadState.INSTANCE);
    }
}
