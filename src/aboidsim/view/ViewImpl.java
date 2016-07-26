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

    @Override
    public void start(List<String> boids, List<String> rules)  {
        try {
            MainWindow window = new MainWindow(boids, rules);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     
       
        
    }

}
