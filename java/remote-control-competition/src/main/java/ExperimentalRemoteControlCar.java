public class ExperimentalRemoteControlCar implements RemoteControlCar {
    private final int units;
    private int travelled = 0;

    public ExperimentalRemoteControlCar() {
        this.units = 20;
    }
    public void drive() {
        travelled += units;
    }

    public int getDistanceTravelled() {
        return travelled;
    }
}
