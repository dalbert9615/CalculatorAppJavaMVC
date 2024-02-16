package main.java.models.operators;

public class Subtraction implements BinaryOperator {
	@Override
	public double ejecutar(double x, double y) {
		return x - y;
	}
}
