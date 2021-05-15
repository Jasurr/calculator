package services;

public enum Operator {
    PLUS("+"),
    SUBSTRING("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}
