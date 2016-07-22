package aboidsim.model;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * Simulation class. It contains all the environment.
 *
 */

public class ModelImpl implements Model {

    private final Environment simulation = new EnvironmentImpl();
    private final RuleSet activeRules = new RuleSet();

    @Override
    public Environment getSimulation() {
        return this.simulation;
    }

    @Override
    public List<Integer> getLevels() {
        return Arrays.stream(Levels.values()).map(values -> values.getId()).collect(Collectors.toList());
    }

    @Override
    public Set<RuleImpl> getActiveRules() {
        return this.activeRules.getRules();
    }
}
