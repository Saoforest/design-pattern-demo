package xyz.xiaolinz.demo.state.mario.condition;

import lombok.Getter;

/**
 * 马里奥
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/26
 */
public class Mario {

    @Getter
    private MarioState currentState;

    public Mario() {
        this.currentState = MarioState.SMALL;
    }

    public void handleEvent(MarioEvent event) {
        switch (currentState) {
            case SMALL:
                if (event.equals(MarioEvent.MUSHROOM)) {
                    currentState = MarioState.BIG;
                } else if (event.equals(MarioEvent.FIRE_FLOWER)) {
                    currentState = MarioState.FIRE;
                } else if (event.equals(MarioEvent.ENEMY_ATTACK)) {
                    currentState = MarioState.DEAD;
                } else if (event.equals(MarioEvent.FALL_INTO_PIT)) {
                    currentState = MarioState.DEAD;
                }
                break;
            case BIG:
                if (event.equals(MarioEvent.FIRE_FLOWER)) {
                    currentState = MarioState.FIRE;
                } else if (event.equals(MarioEvent.ENEMY_ATTACK)) {
                    currentState = MarioState.SMALL;
                } else if (event.equals(MarioEvent.FALL_INTO_PIT)) {
                    currentState = MarioState.DEAD;
                }
                break;
            case FIRE:
                if (event.equals(MarioEvent.ENEMY_ATTACK)) {
                    currentState = MarioState.SMALL;
                } else if (event.equals(MarioEvent.FALL_INTO_PIT)) {
                    currentState = MarioState.DEAD;
                }
                break;
            case DEAD:
            default:
                break;
        }
    }
}
