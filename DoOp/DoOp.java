public class DoOp {
    public static String operate(String[] args) {
        if (args.length != 3) {
            return "Error";
        }
        int a, b;
        try {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            return "Error";
        }
        String op = args[1];
        switch (op) {
            case "+":
                return Integer.toString(a + b);
            case "-":
                return Integer.toString(a - b);
            case "*":
                return Integer.toString(a * b);
            case "/":
                if (b == 0) {
                    return "Error";
                }
                return Integer.toString(a / b);
            case "%":
                if (b == 0) {
                    return "Error";
                }
                return Integer.toString(a % b);
            default:
                return "Error";
        }
    }
}