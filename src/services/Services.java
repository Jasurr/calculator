package services;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public class Services implements Calc {

    @Override
    public String convertArabicNumberToRoman(Integer number) {
        return Objects.requireNonNull(Arrays.stream(Numbers.values())
                .filter(q -> q.getNumbers() == number)
                .findFirst()
                .orElse(null))
                .name();
    }

    @Override
    public Integer convertRomanNumberToArabic(String number) {
        return Numbers.valueOf(number).getNumbers();
    }

    public Integer getIndex(String str) {
        return str.indexOf(getOperator(str));
    }

    public String getFirstNumber(String str) {
        return str.substring(0, getIndex(str)).trim().toUpperCase(Locale.ROOT);
    }

    public String getSecondNumber(String str) {
        return str.substring(getIndex(str) + 1).trim().toUpperCase(Locale.ROOT);
    }

    public String getOperator(String str) {
        return Arrays.stream(Operator.values())
                .map(Operator::getOperator)
                .filter(str::contains)
                .findFirst()
                .orElse(null);
    }

    public Operator getOperatorE(String str) {
        return Arrays.stream(Operator.values())
                .filter(q -> str.contains(q.getOperator()))
                .findFirst()
                .orElse(null);
    }


    public boolean isRomanNumber(String number) {
        return Arrays.stream(Numbers.values())
                .anyMatch(q -> number.equals(q.name()));
    }
    // Calculate numbers
    public Integer calculate(Integer a, Integer b, Operator operator) throws Exception {
        switch (operator) {
            case PLUS:
                return a + b;
            case SUBSTRING:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                if (b == 0) throw new Exception("cannot divide 0");
                return a / b;
            default:
                throw new Exception("Not find operator");
        }
    }
}

