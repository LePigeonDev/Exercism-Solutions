public class JedliksToyCar {
    private final int distanceDrive = 20;
    private int distanceDisplay = 0;
    private int batteryDisplay = 100;
    private int countDrive = 0;

    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return "Driven " + distanceDisplay + " meters";
    }

    public String batteryDisplay() {
        if (batteryDisplay > 0 ) {
            return "Battery at " + batteryDisplay + "%";
        }
        return "Battery empty";
    }

    public void drive() {
        if(this.batteryDisplay > 0) {
            this.distanceDisplay = distanceDisplay + distanceDrive;
            this.batteryDisplay--;
        }
    }
}
