package aboidsim.util;

import java.util.Optional;

/**
 * This class contains an input as well as its important arguments. This class
 * as been intended to store values that cannot be changed after the creation.
 */
public class InputInfo {
	private final Input input;
	private final Optional<Integer> number;
	private final Optional<Vector> position;

	/**
	 * Constructor. This constructor has all the arguments.
	 *
	 * @param in
	 *            the input
	 * @param level
	 *            the integer. It represents the level of a boid.
	 * @param pos
	 *            the vector. It represents the position of the input.
	 * @throws IllegalArgumentException
	 *             if the wrong input has been used
	 */
	public InputInfo(final Input in, final Integer level, final Vector pos) throws IllegalArgumentException {
		if (!in.equals(Input.CREATE_BOID)) {
			throw new IllegalArgumentException("Wrong constructor for the selected input");
		}
		this.input = in;
		this.number = Optional.of(level);
		this.position = Optional.of(pos);
	}

	/**
	 * Constructor.
	 *
	 * @param in
	 *            the input
	 * @param pos
	 *            the vector. It represents the position of the input.
	 * @throws IllegalArgumentException
	 *             if the wrong input has been used
	 */
	public InputInfo(final Input in, final Vector pos) throws IllegalArgumentException {
		if (!in.equals(Input.DESTROY_BOID)) {
			throw new IllegalArgumentException("Wrong constructor for the selected input");
		}
		this.input = in;
		this.number = Optional.empty();
		this.position = Optional.of(pos);
	}

	/**
	 * Constructor.
	 *
	 * @param in
	 *            the input
	 * @param rule
	 *            the integer. It represents a rule.
	 * @throws IllegalArgumentException
	 *             if the wrong input has been used
	 */
	public InputInfo(final Input in, final Integer rule) throws IllegalArgumentException {
		if (!in.equals(Input.TOGGLE_RULE)) {
			throw new IllegalArgumentException("Wrong constructor for the selected input");
		}
		this.input = in;
		this.number = Optional.of(rule);
		this.position = Optional.empty();
	}

	/**
	 * Constructor. It has no other arguments beside the input.
	 *
	 * @param in
	 *            the input
	 * @throws IllegalArgumentException
	 *             if the wrong input has been used
	 */
	public InputInfo(final Input in) throws IllegalArgumentException {
		if (!in.equals(Input.PAUSE) || !in.equals(Input.CLOSE)) {
			throw new IllegalArgumentException("Wrong constructor for the selected input");
		}
		this.input = in;
		this.number = Optional.empty();
		this.position = Optional.empty();
	}

	/**
	 * Getter. It returns the input stored.
	 *
	 * @return the input
	 */
	public Input getInput() {
		return this.input;
	}

	/**
	 * Getter. It return the integer stored.
	 *
	 * @return the integer
	 * @throws UnsupportedOperationException
	 *             if the integer is not present
	 */
	public Integer getNumber() throws UnsupportedOperationException {
		if (this.number.isPresent()) {
			return this.number.get();
		} else {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Getter. It return the position (a vector) stored.
	 *
	 * @return the vector
	 * @throws UnsupportedOperationException
	 *             if the vector is not present
	 */
	public Vector getPosition() throws UnsupportedOperationException {
		if (this.position.isPresent()) {
			return this.position.get();
		} else {
			throw new UnsupportedOperationException();
		}
	}

}
