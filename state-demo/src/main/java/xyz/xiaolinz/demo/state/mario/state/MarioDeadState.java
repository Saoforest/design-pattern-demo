package xyz.xiaolinz.demo.state.mario.state;

/**
 * @author huangmuhong
 * @date 2024/2/27
 */
public class MarioDeadState implements MarioState {

    public static final MarioDeadState INSTANCE = new MarioDeadState();

    @Override
    public void eatMushroom(MarioStateMachine stateMachine) {

    }

    @Override
    public void eatFireFlower(MarioStateMachine stateMachine) {

    }

    @Override
    public void enemyAttack(MarioStateMachine stateMachine) {

    }

    @Override
    public void fallIntoPit(MarioStateMachine stateMachine) {

    }
}
