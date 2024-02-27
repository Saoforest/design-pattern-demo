package xyz.xiaolinz.demo.state.mario.table;

import java.util.Map;
import lombok.Getter;
import xyz.xiaolinz.demo.state.mario.MarioEvent;
import xyz.xiaolinz.demo.state.mario.MarioState;

/**
 * 有限状态机 - 查表法
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/27
 */
public class Mario {

    @Getter
    private MarioState currentState;

    private final Map<MarioStateEventPair, MarioState> transitionTable =
        Map.of(new MarioStateEventPair(MarioState.SMALL, MarioEvent.MUSHROOM), MarioState.BIG,
            new MarioStateEventPair(MarioState.SMALL, MarioEvent.FIRE_FLOWER), MarioState.FIRE,
            new MarioStateEventPair(MarioState.SMALL, MarioEvent.ENEMY_ATTACK), MarioState.DEAD,
            new MarioStateEventPair(MarioState.SMALL, MarioEvent.FALL_INTO_PIT), MarioState.DEAD,
            new MarioStateEventPair(MarioState.BIG, MarioEvent.FIRE_FLOWER), MarioState.FIRE,
            new MarioStateEventPair(MarioState.BIG, MarioEvent.ENEMY_ATTACK), MarioState.SMALL,
            new MarioStateEventPair(MarioState.BIG, MarioEvent.FALL_INTO_PIT), MarioState.DEAD,
            new MarioStateEventPair(MarioState.FIRE, MarioEvent.ENEMY_ATTACK), MarioState.SMALL,
            new MarioStateEventPair(MarioState.FIRE, MarioEvent.FALL_INTO_PIT), MarioState.DEAD);

    public Mario() {
        this.currentState = MarioState.SMALL;
    }

    public void handleEvent(MarioEvent event) {
        MarioStateEventPair pair = new MarioStateEventPair(currentState, event);
        currentState = transitionTable.getOrDefault(pair, currentState);
    }

}
