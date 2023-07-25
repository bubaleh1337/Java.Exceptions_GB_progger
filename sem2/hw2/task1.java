package sem2.hw2;

import java.util.Scanner;

/*
Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */
public class task1 {
    public static void main(String[] args) {
        getNum();
    }
    public static void getNum() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дробное число: ");
        String num = scanner.next();
        if(checkException(num)) {
            System.out.println(num);
            getNum();
        }
        else {
            System.out.println("Вы ввели не дробное число. Попробуйте снова.");
            getNum();
        }
    }
    public static boolean checkException(String num) {
        try {
            Float.valueOf(num);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
