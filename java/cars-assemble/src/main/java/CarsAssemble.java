public class CarsAssemble {
    private final int productionPerHour = 221;
    private double successRate;

    public double productionRatePerHour(int speed) {
        if (speed <= 4) {
            successRate = 1;
        } else if (speed <= 8) {
            successRate = 0.90;
        } else if (speed == 9) {
            successRate = 0.80;    
        } else {
            successRate = 0.77;
        }
        
        return (speed * productionPerHour) * successRate;
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60);
    }
}
