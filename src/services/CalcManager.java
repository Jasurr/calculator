package services;

public class CalcManager {
    private final Services services;

    public CalcManager() {
        services = new Services();
    }

    public String getResult(String str) throws Exception {
        String firstNumber = services.getFirstNumber(str);
        String secondNumber = services.getSecondNumber(str);
        if (services.isRomanNumber(firstNumber)
                && services.isRomanNumber(secondNumber)) {
            Integer result = services.calculate(
                    services.convertRomanNumberToArabic(firstNumber),
                    services.convertRomanNumberToArabic(secondNumber),
                    services.getOperatorE(str));
            if (result < 1) {
                throw new Exception("Roman numerals are greater than 1");
            }
            return services.convertArabicNumberToRoman(result);
        } else if (services.isRomanNumber(firstNumber)
                || services.isRomanNumber(secondNumber)) {
            throw new Exception("Cannot calculate different type of numbers");
        } else {
            return services.calculate(
                    Integer.parseInt(firstNumber),
                    Integer.parseInt(secondNumber),
                    services.getOperatorE(str)).toString();
        }
    }
}
