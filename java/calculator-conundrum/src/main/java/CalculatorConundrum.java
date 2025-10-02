class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) throws IllegalArgumentException {
        try{
            if(operation == null) {
                throw new IllegalArgumentException("Operation cannot be null");
            }
            if(operation.equals("")) {
                throw new IllegalArgumentException("Operation cannot be empty");
            }

            String result = "";
            switch(operation) {
                case "+":
                    result = String.valueOf(operand1 + operand2);
                    break;

                case "*":
                    result = String.valueOf(operand1 * operand2);
                    break;

                case "/":
                    result = String.valueOf(operand1 / operand2);
                    break;

                default:
                    throw new IllegalOperationException("Operation '" + operation + "' does not exist");
            }
            return operand1 + " " + operation + " " + operand2 + " = " + result;
        } catch (ArithmeticException e) {
            throw new IllegalOperationException("Division by zero is not allowed", e);
        }


    }
}
