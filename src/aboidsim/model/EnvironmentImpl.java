package aboidsim.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import aboidsim.util.Vector;

/**
 *
 * This class show all the components of the simulation environment. (Not
 * tree-boids)
 *
 */
public class EnvironmentImpl implements Environment {

    private final Set<Boid> enviroment;
    private static final double COLLISION_RADIUS = 0.50;
    private final RuleSet rules = new RuleSet();

    /**
     * Constructor.
     */
    public EnvironmentImpl() {
        this.enviroment = new HashSet<>();
    }

    @Override
    public void createBoid(final Vector pos, final int liv) {
        final Boid boid = new BoidImpl(pos, liv);
        this.enviroment.add(boid);
    }

    @Override
    public void destroyBoid(final Vector pos) {
        this.enviroment.remove(this.enviroment.stream()
                .filter(boid -> boid.getPosition().dist(pos) < EnvironmentImpl.COLLISION_RADIUS).findFirst().get());
    }

    @Override
    public void checkBoidSameLevel() {
        for (final Boid boid : this.enviroment) {
            if (boid.getLevel() > Levels.TREE_L0.getId()) {
                boid.getSameLevelNearBoids()
                        .addAll(this.enviroment.stream().filter(b -> boid.getLevel() == b.getLevel())
                                .filter(bo -> boid.getPosition().dist(bo.getPosition()) < boid.getInfluenceRadius())
                                .limit(boid.getMaxMembers()).collect(Collectors.toSet()));
            }
        }
    }

    @Override
    public void checkBoidOtherLevel() {
        for (final Boid boid : this.enviroment) {
            if (boid.getLevel() > Levels.TREE_L0.getId()) {
                boid.getOtherLevelNearBoids()
                        .addAll(this.enviroment.stream().filter(b -> boid.getLevel() != b.getLevel())
                                .filter(bo -> boid.getPosition().dist(bo.getPosition()) < boid.getInfluenceRadius())
                                .collect(Collectors.toSet()));
            }
        }
    }

    @Override
    public void collision() {
        for (final Boid boid : this.enviroment) {

        }
    }

    @Override
    public Set<Boid> getEnviroment() {
        return this.enviroment;
    }

    @Override
    public double getCollisionRadius() {
        return EnvironmentImpl.COLLISION_RADIUS;
    }
}
