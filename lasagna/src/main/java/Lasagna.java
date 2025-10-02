public class Lasagna {
    // TODO: define the 'expectedMinutesInOven()' method
    public int expectedMinutesInOven() {
        return 40;
    }

    // TODO: define the 'remainingMinutesInOven()' method
    public int remainingMinutesInOven(int realTime){
        if(realTime > 0) {
            int remainingTime = this.expectedMinutesInOven() - realTime;
            return remainingTime;
        }
        return 0;
    }

    // TODO: define the 'preparationTimeInMinutes()' method
    public int preparationTimeInMinutes(int nbrLayers) {
        if(nbrLayers > 0) {
            int preparationTime = nbrLayers * 2;
            return preparationTime;
        }
        return 0;
    }

    // TODO: define the 'totalTimeInMinutes()' method
    public int totalTimeInMinutes(int nbrLayers, int cookedTime){
        int totalTime = cookedTime + preparationTimeInMinutes(nbrLayers);
        return totalTime;
    }
}
