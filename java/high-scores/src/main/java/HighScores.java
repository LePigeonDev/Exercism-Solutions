import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HighScores {


    private final List<Integer> scores;
    private final List<Integer> best;

    public HighScores(List<Integer> highScores) {
        this.scores = new ArrayList<>(highScores); 
        this.best = new ArrayList<>(highScores);   
        Collections.sort(this.best);               
    }

    List<Integer> scores() {
        return scores;
    }

    Integer latest() {
        return scores.get(scores.size() - 1);
    }

    Integer personalBest() {
        return best.get(best.size() - 1);
    }

    List<Integer> personalTopThree() {
        int from = Math.max(0, best.size() - 3);
        List<Integer> top = new ArrayList<>(best.subList(from, best.size()));
        Collections.reverse(top);
        return top;
    }

}
