package edu.hw2.Task1;

public sealed interface Expr {
    double evaluate();

    record Constant(double value) implements Expr {
        @Override
        public double evaluate() {
            return value;
        }
    }

    record Negate(double value) implements Expr {
        @Override
        public double evaluate() {
            return -value;
        }
    }

    record Exponent(double value, double degree) implements Expr {
        @Override
        public double evaluate() {
            return Math.pow(value, degree);
        }
    }

    record Addition(double firstVal, double secondVal) implements Expr {
        @Override
        public double evaluate() {
            return firstVal + secondVal;
        }
    }

    record Multiplication(double firstVal, double secondVal) implements Expr {
        @Override
        public double evaluate() {
            return firstVal * secondVal;
        }
    }
}
