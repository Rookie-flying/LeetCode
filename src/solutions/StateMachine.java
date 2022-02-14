package solutions;

import javafx.scene.chart.Chart;

import java.util.HashMap;
import java.util.Map;

public class StateMachine {

    public boolean isNumber(String s) {

        
        //建立状态集，每一个状态，以及它的转移状态
        Map<State, Map<CharType, State>> stateSet = new HashMap<>();
        // 开始的空格状态的转移
        Map<CharType, State> startBlankMap = new HashMap<CharType, State>() {
            {
                put(CharType.CHAR_BLANK, State.STATE_START_BLANK);
                put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
                put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
                put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            }
        };

        Map<CharType, State> integerSign = new HashMap<CharType, State>() {
            {
                put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
                put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
            }
        };

        Map<CharType, State> integerState = new HashMap<CharType, State>() {
            {
                put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
                put(CharType.CHAR_EXP, State.STATE_EXP);
                put(CharType.CHAR_BLANK, State.STATE_END_BLANK);
                put(CharType.CHAR_POINT, State.STATE_POINT);
            }
        };

        Map<CharType, State> pointInteger = new HashMap<CharType, State>() {
            {
                put(CharType.CHAR_BLANK, State.STATE_END_BLANK);
                put(CharType.CHAR_EXP, State.STATE_EXP);
                put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            }
        };

        Map<CharType, State> pointWithoutInt = new HashMap<CharType, State>() {
            {
                put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            }
        };

        Map<CharType, State> fraction = new HashMap<CharType, State>() {
            {
                put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
                put(CharType.CHAR_EXP, State.STATE_EXP);
                put(CharType.CHAR_BLANK, State.STATE_END_BLANK);
            }
        };

        Map<CharType, State> exp = new HashMap<CharType, State>() {
            {
                put(CharType.CHAR_NUMBER, State.STATE_EXP_INT);
                put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
            }
        };

        Map<CharType, State> expSign = new HashMap<CharType, State>() {
            {
                put(CharType.CHAR_NUMBER, State.STATE_EXP_INT);
            }
        };

        Map<CharType, State> expInt = new HashMap<CharType, State>() {
            {
                put(CharType.CHAR_BLANK, State.STATE_END_BLANK);
                put(CharType.CHAR_NUMBER, State.STATE_EXP_INT);
            }
        };

        Map<CharType, State> endBlank = new HashMap<CharType, State>() {
            {
                put(CharType.CHAR_BLANK, State.STATE_END_BLANK);
            }
        };

        stateSet.put(State.STATE_START_BLANK, startBlankMap);
        stateSet.put(State.STATE_INT_SIGN, integerSign);
        stateSet.put(State.STATE_INTEGER, integerState);
        stateSet.put(State.STATE_POINT, pointInteger);
        stateSet.put(State.STATE_POINT_WITHOUT_INT, pointWithoutInt);
        stateSet.put(State.STATE_FRACTION, fraction);
        stateSet.put(State.STATE_EXP, exp);
        stateSet.put(State.STATE_EXP_SIGN, expSign);
        stateSet.put(State.STATE_EXP_INT, expInt);
        stateSet.put(State.STATE_END_BLANK, endBlank);

        State state = State.STATE_START_BLANK;
        int len = s.length();

        for (int i=0 ; i<len ; ++i) {

            char c = s.charAt(i);
            CharType charType = getCharType(c);
            if (!stateSet.get(state).containsKey(charType)) {
                return false;
            } else {
                //转移到next state
                state = stateSet.get(state).get(charType);
            }
        }



        return state == State.STATE_END_BLANK || state == State.STATE_EXP_INT
                || state == State.STATE_INTEGER || state == State.STATE_FRACTION || state == State.STATE_POINT;
    }

    public CharType getCharType (char c) {

        if (c >= '0' && c <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (c == '+' || c == '-') {
            return CharType.CHAR_SIGN;
        } else if (c == 'e' || c == 'E') {
            return CharType.CHAR_EXP;
        } else if (c == ' ') {
            return CharType.CHAR_BLANK;
        } else if (c == '.') {
            return CharType.CHAR_POINT;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }

    public static void main(String[] args) {
        StateMachine stateMachine = new StateMachine();
        System.out.println(stateMachine.isNumber("     .1  "));
    }
}

enum State {

    STATE_START_BLANK,
    STATE_INT_SIGN,
    STATE_INTEGER,
    STATE_POINT,
    STATE_POINT_WITHOUT_INT,
    STATE_FRACTION,
    STATE_EXP,
    STATE_EXP_SIGN,
    STATE_EXP_INT,
    STATE_END_BLANK
}

enum CharType {
    CHAR_NUMBER,
    CHAR_EXP,
    CHAR_POINT,
    CHAR_SIGN,
    CHAR_BLANK,
    CHAR_ILLEGAL
}