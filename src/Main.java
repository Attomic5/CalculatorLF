import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1,2);
        int b = calc.minus.apply(1, 1); //  на 0 делить нельзя
        int result = calc.check.apply(b);
        int c = calc.divideCheck(a, b);
//        int c = calc.divide.apply(a, result);

        calc.println.accept(c);
    }
    public static class Calculator {
        static Supplier<Calculator> instance = Calculator::new;

        BinaryOperator<Integer> plus = (x, y) -> x + y;
        BinaryOperator<Integer> minus = (x, y) -> x - y;
        BinaryOperator<Integer> multiply = (x, y) -> x * y;
        BinaryOperator<Integer> divide  = (x, y) -> x / y;

        UnaryOperator<Integer> pow = x -> x * x;
        UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

        Predicate<Integer> isPositive = x -> x > 0;

        Consumer<Integer> println = System.out::println;

        UnaryOperator<Integer> check = x -> x != 0 ? x : -1;

        public int divideCheck (int a, int b) {
            if (b != 0) {
                int c = divide.apply(a, b);
                return c;

            } else {
                System.out.println("Делить на ноль нельзя");
                return -1;
            }
        }
    }
}
