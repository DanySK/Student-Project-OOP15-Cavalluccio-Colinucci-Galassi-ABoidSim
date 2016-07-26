package aboidsim.view;

import java.util.ArrayList;
import java.util.List;

import aboidsim.util.InputInfo;

public class ViewImpl implements View {

	@Override
	public List<InputInfo> getInputs() {
		// TODO Auto-generated method stub
	        List<InputInfo> list = InputHandler.getInputHandler().getInputs();
	        InputHandler.getInputHandler().clearInputs();
		return list;
	}

}
