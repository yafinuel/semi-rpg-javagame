package utilz;

public class Constants {

    public static class Directions{
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }

    public static class PlayerConstants{
        public static final int IDLE = 0;
        public static final int SIDE_WALK_NO_WEAPON = 1;
        public static final int FRONT_WALK = 2;
        public static final int FRONT_WALK_NO_WEAPON = 3;
        public static final int BACK_WALK = 4;
        public static final int BACK_WALK_NO_WEAPON = 5;
        public static final int SIDE_WALK = 6;

        public static int GetSpriteAmount(int player_action){
            switch (player_action) {
                    case IDLE:
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
