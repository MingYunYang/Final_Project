package nvds.geography;

import java.util.ArrayList;

/**
 * @author libby
 * @author mutara
 */
public class Country {

    private String name;

    private int population;

    private final ArrayList<State> stateList;

    public Country(String name) {
        this.name = name;
        stateList = new ArrayList<>();
    }

    public State addState(String name) {
        State state = new State(name);
        stateList.add(state);
        return state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public ArrayList<State> getStateList() {
        return stateList;
    }

    @Override
    public String toString() {
        return name;
    }

}
