package main.java.models.calculator;

import main.java.models.operators.BinaryOperator;

public interface ModelCalculator {

	public void clear();
	public double getResultado();
	public void nuevaOperacion(BinaryOperator operacion);
	public void nuevoOperando(double operando);
}
