import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение используя числа от 1 до 10:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));

    }
    public static String calc (String input) throws Exception { /*<-- метод должен принимать  математическое выражение и вовращать стороку с рехзультатьм иего выполнения*/
        int number1;
        int number2;
        String result;
        String action;
        boolean rom;
        String[] spl = input.split("[/*\\-+]");
        if (spl.length != 2) throw new Exception("Введите два числа");
        action = operation(input);
        if (action == null) throw new Exception("Недопустимая операция");

        if (Roman.rom(spl[0]) && Roman.rom(spl[1])) {
            number1 = Roman.arabConv(spl[0]);
            number2 = Roman.arabConv(spl[1]);
            rom = true;
        } else if (!Roman.rom(spl[0]) && !Roman.rom(spl[1])) {
            number1 = Integer.parseInt(spl[0]);
            number2 = Integer.parseInt(spl[1]);
//            if (number1<0 || number1>10) {throw new Exception("Введите число от 1 до 10");}
//            if (number2<0 || number2>10) {throw new Exception("Введите число от 1 до 10");}
            rom = false;
        } else {
            throw new Exception("Введите два арабских или два римских числа");
        }

        if (number1 < 1 || number1 > 10) {
            throw new Exception("Введите число от 1 до 10");
        }
        if (number2 < 1 || number2 > 10) {
            throw new Exception("Введите число от 1 до 10");
        }

        int arab = calculate(number1, number2, action);
        if (rom) {
            if (arab < 1) {
                throw new Exception("В римской системе отсутсвуют 0 и отрицательные числа");
            }
            result = Roman.romeConv(arab);
        } else {
            result = String.valueOf(arab);
        }
        return result;
    }

//        if (action.equals("+")) {result = number1 + number2;
//        else if (action.equals("-")) result = number1 - number2;
//        else if (action.equals("/")) result = number1 / number2;
//        else result = number1 * number2;


    static String operation (String input) {
        if (input.contains("+")) return "+";
        else if (input.contains("-")) return "-";
        else if (input.contains("/")) return "/";
        else if (input.contains("*")) return "*";
        else return null;
    }
    static int calculate (int a, int b, String s) {
        if (s.equals("+")) return a + b;
        else if (s.equals("-")) return a - b;
        else if (s.equals("/")) return a / b;
        else return a * b;
    }
}
class Roman {
    static String [] romArr = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                                            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                                            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI","XXVII", "XXVIII", "XXIX", "XXX",
                                            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                                            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                                             "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                                            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                                            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                                            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                                            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
    public static boolean rom (String ent) {
        for (int i = 0; i < romArr.length; i++) {
            if (ent.equalsIgnoreCase(romArr[i])) {
                return true;
            }
        }
        return false;
    }
    public static int arabConv (String roma) {
        for (int i = 0; i < romArr.length; i++){
            if (roma.equalsIgnoreCase(romArr[i])) {
                return i;
            }
        }
        return -1;
    }
    public static String romeConv (int arab) {
        return romArr[arab];
    }
}
