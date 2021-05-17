package services;

import java.util.Arrays;
import java.util.Locale;

public class Services implements Calc {
    private static String[] ROME = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static int[] ARAB = {100, 90, 50, 40, 10, 9, 5, 4, 1};
    private StringBuilder romanNumber;

    @Override
    public String convertArabicNumberToRoman(Integer number) {
        romanNumber = new StringBuilder();
        Integer n = number;
        for (int i = 0; i < ARAB.length; i++) {
            while (n >= ARAB[i]) {
                romanNumber.append(ROME[i]);
                n -= ARAB[i];
            }
        }
        return romanNumber.toString();
    }

    @Override
    public Integer convertRomanNumberToArabic(String roman) {
        romanNumber = new StringBuilder(roman);
        int arabicNum = 0, i = 0;
        if (romanNumber.length() > 0) {
            while (true) {
                do {
                    if (ROME[i].length() <= romanNumber.length()) {
                        if (ROME[i].equals(romanNumber.substring(0, ROME[i].length()))) {
                            arabicNum += ARAB[i];
                            romanNumber.delete(0, ROME[i].length());
                            if (romanNumber.length() == 0) {
                                return arabicNum;
                            }
                        } else break;
                    } else break;
                } while (true);
                i++;
            }
        }
        return 0;
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
        for (String rome : ROME)
            if (number.contains(rome)) return true;
        return false;
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

