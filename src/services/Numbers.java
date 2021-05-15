package services;

public enum Numbers {
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10);

    int numbers;

    Numbers(int numbers) {
        this.numbers = numbers;
    }

    public int getNumbers() {
        return numbers;
    }
}
