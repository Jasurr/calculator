package services;

public class CalcManager {
    final Services services;

    public CalcManager() {
        services = new Services();
    }

    public String getResult(String str) throws Exception {
        if (services.isRomanNumber(services.getFirstNumber(str)) && services.isRomanNumber(services.getSecondNumber(str))) {
            return services.convertArabicNumberToRoman(
                    services.calculate(services.convertRomanNumberToArabic(services.getFirstNumber(str)),
                            services.convertRomanNumberToArabic(services.getSecondNumber(str)),
                            services.getOperatorE(str)));
        } else {
            return services.calculate(
                    Integer.parseInt(services.getFirstNumber(str)),
                    Integer.parseInt(services.getSecondNumber(str)),
                    services.getOperatorE(str)).toString();
        }
    }
}
