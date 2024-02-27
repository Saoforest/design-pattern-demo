package xyz.xiaolinz.demo.state.mario.state;

import lombok.Getter;
import lombok.Setter;

/**
 * 马里奥状态机
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/27
 */
public class MarioStateMachine {

    @Getter
    @Setter
    private MarioState currentState;

    public MarioStateMachine() {
        this.currentState = MarioSmallState.INSTANCE;
    }

    /**
     * 吃蘑菇
     *
     * @author huangmuhong
     * @date 2024/02/27
     * @since 1.0.0
     */
    public void eatMushroom() {
        currentState.eatMushroom(this);
    }

    /**
     * 吃火花
     *
     * @author huangmuhong
     * @date 2024/02/27
     * @since 1.0.0
     */
    public void eatFireFlower() {
        currentState.eatFireFlower(this);
    }

    /**
     * 敌人攻击
     *
     * @author huangmuhong
     * @date 2024/02/27
     * @since 1.0.0
     */
    public void enemyAttack() {
        currentState.enemyAttack(this);
    }

    /**
     * 掉进坑里
     *
     * @author huangmuhong
     * @date 2024/02/27
     * @since 1.0.0
     */
    public void fallIntoPit() {
        currentState.fallIntoPit(this);
    }

}
