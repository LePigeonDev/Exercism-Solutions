
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        int[] lastWeek = {0,2,5,3,7,8,4};
        return lastWeek;
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length-1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length-1] = birdsPerDay[birdsPerDay.length-1] + 1;
    }

    public boolean hasDayWithoutBirds() {
        for(int birds : birdsPerDay) {
            if(birds == 0) {return true;}
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int count = 0;
        if(numberOfDays > 7) {numberOfDays = 7;}

        for(int i = 0; i < numberOfDays; i++) {
            count += birdsPerDay[i];
        }
        return count;
    }

    public int getBusyDays() {
        int countBusyDays = 0;
        for(int birds : birdsPerDay) {
            if(birds >= 5) {countBusyDays++;}
        }
        return countBusyDays;
    }
}
