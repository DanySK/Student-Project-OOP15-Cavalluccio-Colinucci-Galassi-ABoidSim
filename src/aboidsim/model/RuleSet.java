package aboidsim.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Container class that represent a set of Rule implementation.
 *
 */
public class RuleSet {

	private final Set<Rule> rules;

	/**
	 * Basic constructor with no arguments.
	 */
	public RuleSet() {
		this.rules = new HashSet<>();
	}

	/**
	 * Constructor witch sets the rules according the the argument.
	 *
	 * @param newRules
	 *            the rules to initialize the set with.
	 */
	public RuleSet(final Set<Rule> newRules) {
		this.rules = newRules;
	}

}
