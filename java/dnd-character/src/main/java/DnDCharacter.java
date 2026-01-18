import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class DnDCharacter {

    private final int strength;
    private final int dexterity;
    private final int constitution;
    private final int intelligence;
    private final int wisdom;
    private final int charisma;
    private final int hitpoints;

    DnDCharacter() {
        this.strength = ability(rollDice());
        this.dexterity = ability(rollDice());
        this.constitution = ability(rollDice());
        this.intelligence = ability(rollDice());
        this.wisdom = ability(rollDice());
        this.charisma = ability(rollDice());
        this.hitpoints = 10 + modifier(this.constitution);
    }

    int ability(List<Integer> scores) {
        List<Integer> copy = new ArrayList<>(scores);
        copy.sort(Collections.reverseOrder());
        
        int result = 0;
        for(int i = 0; i < 3; i++) {
            result += copy.get(i);
        }
        return result;
    }

    List<Integer> rollDice() {
        List<Integer> roll = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            roll.add(1 + (int) (Math.random() * 6));
        }
        return roll;
    }

    int modifier(int input) {
        return (int) Math.floor((input-10)/2.0);
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return hitpoints;
    }
}
