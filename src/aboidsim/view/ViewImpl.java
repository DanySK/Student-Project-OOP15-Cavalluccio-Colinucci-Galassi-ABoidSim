package aboidsim.view;

import java.util.List;

import aboidsim.util.InputInfo;
import aboidsim.util.Pair;
import aboidsim.util.Vector;
import javafx.application.Application;

/**
 * used to comunicate with the controller
 *
 */
public class ViewImpl implements View {


    
    /**
     * return all the input of the interface as a list of IputInfo
     */
    public List<InputInfo> getInputs() {
        // TODO Auto-generated method stub
        List<InputInfo> list = InputHandler.getInputHandler().getInputs();
        InputHandler.getInputHandler().clearInputs();
        return list;
    }

   
    public void start(List<String> boids, List<String> rules) {
        MainWindow.setBoids(boids);
        MainWindow.setRules(rules);
        Application.launch(MainWindow.class);

    }

    @Override
    public void drawEntities(List<Pair<Vector, Integer>> entities) {
        // TODO Auto-generated method stub
        
    }
    
    
 
}
