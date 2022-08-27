import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        System.out.print(calc(inputStr));
    }

    public static String calc(String input) throws Exception {
        String[] inputArr = input.split(" ");
        String testNum1 = inputArr[0];
        String testNum2 = inputArr[2];
        String operator = inputArr[1];

        String[] arabicArr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] romanArr = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] operatorsArr = {"+", "-", "*", "/"};

        if ((inputArr.length != 3) || (!isStrInArr(operator, operatorsArr)) || (!(isStrInArr(testNum1, arabicArr) && isStrInArr(testNum2, arabicArr)) && !(isStrInArr(testNum1, romanArr) && isStrInArr(testNum2, romanArr)))) {
            throw new Exception();
        }

        if (isStrInArr(testNum1, arabicArr)) {
            int num1 = Integer.parseInt(testNum1);
            int num2 = Integer.parseInt(testNum2);
            int result = calculate(operator, num1, num2);
            return Integer.toString(result);
        } else {
            int num1 = findIndex(romanArr, testNum1) + 1;
            int num2 = findIndex(romanArr, testNum2) + 1;
            int result = calculate(operator, num1, num2);

            if (result <= 0) {
                throw new Exception();
            }

            return toRoman(result);
        }

    }

    public static int calculate(String operator, int a, int b) {
        if (operator.equals("+")) {
            return a + b;
        }
        if (operator.equals("-")) {
            return a - b;
        }
        if (operator.equals("*")) {
            return a * b;
        }
        if (operator.equals("/")){
            return a / b;
        }
        return -101;
    }

    public static boolean isStrInArr(String str, String[] arr) {
        for (String s : arr) {
            if (str.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static int findIndex(String[] arr, String str) {
        for (int i = 0; i < arr.length; i++) {
            if (str.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String toRoman(int num) {
        String[] romanArr = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String romanNum = "";

        if (num == 100) {
            romanNum += "C";
            num -= 100;
        }

        if (num >= 90) {
            romanNum += "XC";
            num -= 90;
        }

        if (num >= 50) {
            romanNum += "L";
            num -= 50;
        }

        if (num >= 40) {
            romanNum += "XL";
            num -= 40;
        }

        while (num >= 10) {
            romanNum += "X";
            num -= 10;
        }

        if (num > 0) {
            romanNum += romanArr[num - 1];
        }

        return romanNum;
    }
}