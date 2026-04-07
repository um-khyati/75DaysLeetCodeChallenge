class Robot {

    int width;
    int height;
    int total;

    int curSteps;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        curSteps = 0;

        total = (height + width) * 2 - 4;
        
    }
    
    public void step(int num) {
        curSteps += num;
    }
    
    public int[] getPos() {
        int step = curSteps % total;

        if (step <= width - 1) {
            return new int[]{step, 0};
        }
        step -= width - 1;

        if (step <= height - 1) {
            return new int[]{width-1, step};
        }

        step -= height - 1;

        if (step <= width - 1) {
            return new int[]{width - 1 - step, height - 1};
        }

        step -= width - 1;

        return new int[]{0, height - 1 - step};
    }
    
    public String getDir() {
        if (curSteps == 0) {
            return "East";
        }

        int step = curSteps % total;

        if (step == 0) {
            return "South";
        }

        if (step <= width - 1) {
            return "East";
        }
        step -= width - 1;

        if (step <= height - 1) {
           return "North";
        }

        step -= height - 1;

        if (step <= width - 1) {
           return "West";
        }

        return "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */