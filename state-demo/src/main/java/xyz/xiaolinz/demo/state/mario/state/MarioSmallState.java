package xyz.xiaolinz.demo.state.mario.state;

/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/27
 * @see MarioState
 */
public class MarioSmallState implements MarioState {

    public static final MarioSmallState INSTANCE = new MarioSmallState();

    @Override
    public void eatMushroom(MarioStateMachine stateMachine) {
        System.out.println("吃蘑菇成功，变为大马里奥");
        stateMachine.setCurrentState(MarioBigState.INSTANCE);
    }

    @Override
    public void eatFireFlower(MarioStateMachine stateMachine) {
        System.out.println("吃火花成功，变为火焰马里奥");
        stateMachine.setCurrentState(MarioFireState.INSTANCE);
    }

    @Override
    public void enemyAttack(MarioStateMachine stateMachine) {
        System.out.println("被敌人攻击，直接死掉");
        stateMachine.setCurrentState(MarioDeadState.INSTANCE);
    }

    @Override
    public void fallIntoPit(MarioStateMachine stateMachine) {
        System.out.println("掉进坑里，直接死掉");
        stateMachine.setCurrentState(MarioDeadState.INSTANCE);
    }
}
