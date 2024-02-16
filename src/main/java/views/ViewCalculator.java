package main.java.views;
import java.awt.event.ActionListener;

public interface ViewCalculator {
	public void setDisplay(String s);
	public String getDisplay();
	public void setVisible(boolean v);
	public void addOyenteTeclaDigito(int digito,ActionListener l);
	public void addOyenteTeclaDecimal(ActionListener l);
	public void addOyenteTeclaMas(ActionListener l);
	public void addOyenteTeclaMenos(ActionListener l);
	public void addOyenteTeclaPor(ActionListener l);
	public void addOyenteTeclaDiv(ActionListener l);
	public void addOyenteTeclaIgual(ActionListener l);
	public void addOyenteTeclaClear(ActionListener l);
}
