package aboidsim.model;

/**
 *
 * Simulation class. It contains all the enviroment.
 *
 */

public class ModelImpl implements Model {

    private final Enviroment simulation = new EnviromentImpl();

    @Override
    public Enviroment getSimulation() {
        return this.simulation;
    }
}
