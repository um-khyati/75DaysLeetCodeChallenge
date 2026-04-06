class Solution {
    public enum DIR {UP, DOWN, LEFT, RIGHT}
    public class RoboGrid {
        int x;
        int y;
        DIR dir;
        Set<Integer> obstacles;
        public RoboGrid(int x, int y, DIR dir, Set<Integer> obstacles) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.obstacles = obstacles;
        }
        public void trymove(int units) {
            if(units == 0) return;
            int oldX = this.x;
            int oldY = this.y;
            switch(dir) {
                case DIR.UP: y += 1; break;
                case DIR.DOWN: y -= 1; break;
                case DIR.LEFT: x -= 1; break;
                case DIR.RIGHT: x += 1; break;
                default: throw new Error("beep beep");
            }
            if(obstacles.contains(locHash(this.x, this.y))) {
                this.x = oldX;
                this.y = oldY;
            } else this.trymove(units-1);
        }
        public void turnLeft() {
            switch(this.dir) {
                case DIR.UP : this.dir = DIR.LEFT; break;
                case DIR.DOWN : this.dir = DIR.RIGHT; break;
                case DIR.RIGHT : this.dir = DIR.UP; break;
                case DIR.LEFT : this.dir = DIR.DOWN; break;
                default : throw new Error("unhandled dir");
            }
        }
        public void turnRight() {
            switch(this.dir) {
                case DIR.UP : this.dir = DIR.RIGHT; break;
                case DIR.DOWN : this.dir = DIR.LEFT; break;
                case DIR.RIGHT : this.dir = DIR.DOWN; break;
                case DIR.LEFT : this.dir = DIR.UP; break;
                default : throw new Error("unhandled dir"); 
            }
        }
    }
    public int locHash(int x, int y) {
        return (x + 30000) * 60001 + (y + 30000);
    }
    public int robotSim(int[] commands, int[][] obstacles) {
        int n = commands.length;
        
        Set<Integer> obsta = new HashSet<Integer>();
        for(int[] obstacle : obstacles) obsta.add(locHash(obstacle[0], obstacle[1]));
        RoboGrid robo = new RoboGrid(0,0,DIR.UP, obsta);
        int maxDist = 0;
        for(int cmd : commands)
            if(cmd == -2) robo.turnLeft();
            else if(cmd == -1) robo.turnRight();
            else {
                robo.trymove(cmd);
                maxDist = Math.max(maxDist, edist(0, 0, robo.x, robo.y));
            }

        return maxDist;
    }
    public int edist(int fr, int fc, int tr, int tc) {
        int dr = fr - tr;
        int dc = fc - tc;
        return (int)(Math.pow(dr, 2) + Math.pow(dc, 2));
    }
}