package edu.hw2.Task1;

public sealed interface Expr {
    double evaluate();

    record Constant(double value) implements Expr {

        @Override
        public double evaluate() {
            return value;
        }

        public Constant(Expr expr) {
            this(expr.evaluate());
        }
    }

    record Negate(double value) implements Expr {
        @Override
        public double evaluate() {
            return -value;
        }

        public Negate(Expr expr) {
            this(expr.evaluate());
        }
    }

    record Exponent(double value, double degree) implements Expr {
        @Override
        public double evaluate() {
            return Math.pow(value, degree);
        }

        public Exponent(Expr expr, int degree) {
            this(expr.evaluate(), degree);
        }
    }

    record Addition(double firstVal, double secondVal) implements Expr {

        @Override
        public double evaluate() {
            return firstVal + secondVal;
        }

        public Addition(Expr value1, Expr value2) {
            this(value1.evaluate(), value2.evaluate());
        }

    }

    record Multiplication(double firstVal, double secondVal) implements Expr {
        @Override
        public double evaluate() {
            return firstVal * secondVal;
        }

        public Multiplication(Expr firstV, Expr secondV) {
            this(firstV.evaluate(), secondV.evaluate());
        }
    }
}
