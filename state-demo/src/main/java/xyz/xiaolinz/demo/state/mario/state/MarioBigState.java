package xyz.xiaolinz.demo.state.mario.state;

/**
 * @author huangmuhong
 * @date 2024/2/27
 */
public class MarioBigState implements MarioState {

    public static final MarioBigState INSTANCE = new MarioBigState();

    @Override
    public void eatMushroom(MarioStateMachine stateMachine) {
        System.out.println("已经是大马里奥了，吃蘑菇无效");
    }

    @Override
    public void eatFireFlower(MarioStateMachine stateMachine) {
        System.out.println("吃火花成功，变为火焰马里奥");
        stateMachine.setCurrentState(MarioFireState.INSTANCE);
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
