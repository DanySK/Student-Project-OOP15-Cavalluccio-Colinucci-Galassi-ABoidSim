package aboidsim.controller;

import aboidsim.model.Model;
import aboidsim.view.View;

/**
 * Implementation of the Controller inteface.
 *
 */
public class ControllerImpl implements Controller {

	private Model model;
	private View view;
	private MainLoop mainLoop;

	/**
	 * Public constructor.
	 *
	 * @param m
	 *            a Model implementation
	 * @param v
	 *            a View implementation
	 * @param mL
	 *            a MainLoop implementation
	 */
	public ControllerImpl(final Model m, final View v, final MainLoop mL) {
		this.model = m;
		this.view = v;
		this.mainLoop = mL;
	}

	@Override
	public void setView(final View newView) {
		this.view = newView;
	}

	@Override
	public View getView() {
		return this.view;
	}

	@Override
	public void setModel(final Model newModel) {
		this.model = newModel;
	}

	@Override
	public Model getModel() {
		return this.model;
	}

	@Override
	public void setMainLoop(final MainLoop newMainLoop) {
		this.mainLoop = newMainLoop;
	}

	@Override
	public MainLoop getMainLoop() {
		return this.mainLoop;
	}

	@Override
	public void start() {
		this.mainLoop.run();
	}

}
