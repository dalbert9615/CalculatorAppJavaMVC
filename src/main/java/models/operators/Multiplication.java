package main.java.models.operators;

public class Multiplication implements BinaryOperator{
	@Override
	public double ejecutar(double x,double y) {
		return x*y;
	}
}
