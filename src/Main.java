import services.CalcManager;

import java.util.Scanner;

public class Main {
    static CalcManager calcManager = new CalcManager();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(calcManager.getResult(str));
    }
}
