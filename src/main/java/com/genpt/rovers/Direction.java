package com.genpt.rovers;

import com.genpt.rovers.exception.IllegalInputException;

public enum Direction {
    N {
        @Override
        public Direction left() {
            return W;
        }
        @Override
        public Direction right() {
            return E;
        }
    },
    E {
        @Override
        public Direction left() {
            return N;
        }
        @Override
        public Direction right() {
            return S;
        }
    },
    S {
        @Override
        public Direction left() {
            return E;
        }
        @Override
        public Direction right() {
            return W;
        }
    },
    W {
        @Override
        public Direction left() {
            return S;
        }
        @Override
        public Direction right() {
            return N;
        }
    };
    Direction direction;

    public static Direction valueOf(char c) {
        switch (c) {
        case 'N':
            return N;
        case 'E':
            return E;
        case 'S':
            return S;
        case 'W':
            return W;
        default:
            throw new IllegalInputException("Unknow direction: " + c);
        }
    }

    public abstract Direction left();
    public abstract Direction right();
}
