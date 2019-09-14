package idv.kuma._7kyu.make_a_function_that_does_arithmetic;

class ArithmeticFunction {
    public static int arithmetic(int a, int b, String operator) {
        switch(operator) {
            case "add":
                return  a + b;
            case "subtract":
                return  a - b;
            case "multiply":
                return a * b;
            default:
                return a / b;
        }
    }


}