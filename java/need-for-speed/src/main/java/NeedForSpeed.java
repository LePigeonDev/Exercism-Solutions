class NeedForSpeed {
    private int speed;
    private int batteryDrain;
    private int battery = 100;
    private int meters = 0;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return this.battery < this.batteryDrain; 
    }

    public int distanceDriven() {
        return meters;
    }

    public void drive() {
        if (this.battery >= this.batteryDrain) {
            this.battery -= this.batteryDrain;
            this.meters += this.speed;
        }

    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }


    public int getSpeed() { 
        return speed; 
    }

    public int getBatteryDrain() { 
        return batteryDrain; 
    }
    
}

class RaceTrack {
    private int distance;
    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        int maxMoves = 100 / car.getBatteryDrain();
        int maxDistance = maxMoves * car.getSpeed();
        return maxDistance >= this.distance;
    }
}
