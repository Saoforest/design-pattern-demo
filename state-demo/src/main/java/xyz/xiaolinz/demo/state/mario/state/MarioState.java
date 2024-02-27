package xyz.xiaolinz.demo.state.mario.state;

/**
 * 有限状态机 - 状态模式抽象状态
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/27
 */
public interface MarioState {

    /**
     * 吃蘑菇
     *
     * @param stateMachine 状态机
     * @author huangmuhong
     * @date 2024/02/27
     * @since 1.0.0
     */
    void eatMushroom(MarioStateMachine stateMachine);

    /**
     * 吃火花
     *
     * @param stateMachine 状态机
     * @author huangmuhong
     * @date 2024/02/27
     * @since 1.0.0
     */
    void eatFireFlower(MarioStateMachine stateMachine);

    /**
     * 敌人攻击
     *
     * @param stateMachine 状态机
     * @author huangmuhong
     * @date 2024/02/27
     * @since 1.0.0
     */
    void enemyAttack(MarioStateMachine stateMachine);

    /**
     * 掉进坑里
     *
     * @param stateMachine 状态机
     * @author huangmuhong
     * @date 2024/02/27
     * @since 1.0.0
     */
    void fallIntoPit(MarioStateMachine stateMachine);
}
