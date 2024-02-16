package main.java;
import javax.swing.SwingUtilities;

import main.java.controllers.ControllerCalculator;
import main.java.models.calculator.Calculator;
import main.java.models.calculator.ModelCalculator;
import main.java.views.ViewCalculator;
import main.java.views.WindowCalculator;




public class Main {

	public static void main(String[] args) {
		WindowCalculator calculator=new WindowCalculator();
		ViewCalculator view=new WindowCalculator();
		ModelCalculator model=new Calculator();
		ControllerCalculator controller=new ControllerCalculator(view,model);
		
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				view.setVisible(true);
			}
		});
	}
}
