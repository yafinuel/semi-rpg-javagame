package utilz;

import main.Game;

import java.security.PublicKey;

public class Constants {

    public static class Environment{
        public static final int BIG_CLOUD_WIDTH_DEFAULT = 400;
        public static final int BIG_CLOUD_HEIGHT_DEFAULT = 101;
        public static final int SMALL_CLOUD_WIDTH_DEFAULT = 74;
        public static final int SMALL_CLOUD_HEIGHT_DEFAULT = 24;

        public static final int BIG_CLOUD_WIDTH = (int) (BIG_CLOUD_WIDTH_DEFAULT * Game.SCALE);
        public static final int BIG_CLOUD_HEIGHT = (int) (BIG_CLOUD_HEIGHT_DEFAULT * Game.SCALE);
        public static final int SMALL_CLOUD_WIDTH = (int) (SMALL_CLOUD_WIDTH_DEFAULT * Game.SCALE);
        public static final int SMALL_CLOUD_HEIGHT = (int) (SMALL_CLOUD_HEIGHT_DEFAULT * Game.SCALE);
    }

    public static class UI{
        public static class Buttons{
            public static final int B_WIDTH_DEFAULT = 140;
            public static final int B_HEIGHT_DEFAULT = 56;
            public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT * Game.SCALE);
            public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT * Game.SCALE);
        }

        public static class PauseButtons{
            public static final int SOUND_SIZE_DEFAULT = 42;
            public static final int SOUND_SIZE = (int)(SOUND_SIZE_DEFAULT * Game.SCALE);
        }

        public static class URMButtons {
            public static final int URM_DEFAULT_SIZE = 56;
            public static final int URM_SIZE = (int)(URM_DEFAULT_SIZE * Game.SCALE);
        }

        public static class VolumeButtons {
            public static final int VOLUME_DEFAULT_WIDTH = 28;
            public static final int VOLUME_DEFAULT_HEIGHT = 44;
            public static final int SLIDER_DEFAULT_WIDTH = 215;

            public static final int VOLUME_WIDTH = (int)(VOLUME_DEFAULT_WIDTH * Game.SCALE);
            public static final int VOLUME_HEIGHT = (int)(VOLUME_DEFAULT_HEIGHT * Game.SCALE);
            public static final int SLIDER_WIDTH = (int)(SLIDER_DEFAULT_WIDTH * Game.SCALE);
        }
    }

    public static class Directions{
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }

    public static class PlayerConstants{
        public static final int IDLE_NO_WEAPON = 0;
        public static final int IDLE = 1;
        public static final int SIDE_WALK_NO_WEAPON = 2;
        public static final int SIDE_WALK = 3;
        public static final int BACK_WALK_NO_WEAPON = 4;
        public static final int BACK_WALK = 5;
        public static final int FRONT_WALK = 6;
        public static final int FRONT_WALK_NO_WEAPON = 7;
        public static final int JUMP = 8;
        public static final int HIT = 9;

        public static int GetSpriteAmount(int player_action){
            switch (player_action) {
                case HIT:
                    return 4;
                case IDLE_NO_WEAPON:
                case IDLE:
                case JUMP:
                    return 7;
                case SIDE_WALK_NO_WEAPON:
                case FRONT_WALK:
                case FRONT_WALK_NO_WEAPON:
                case BACK_WALK:
                case BACK_WALK_NO_WEAPON:
                case SIDE_WALK:
                    return 8;
                default:
                    return 0;
            }
        }



    }
}
