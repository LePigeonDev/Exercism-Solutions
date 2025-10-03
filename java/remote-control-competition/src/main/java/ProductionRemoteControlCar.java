class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
    private final int units;
    private int travelled = 0;
    private int numberOfVictories;
    public ProductionRemoteControlCar() {
        this.numberOfVictories = 0;
        this.units = 10;
    }
    public void drive() {
        travelled += units;
    }

    public int compareTo(ProductionRemoteControlCar other) {
        return Integer.compare(other.numberOfVictories, this.numberOfVictories);
    }
    
    public int getDistanceTravelled() {
        return travelled;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }
}
