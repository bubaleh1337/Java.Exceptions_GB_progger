package sem2.hw2;

import java.util.Scanner;

/*
Разработайте программу, которая выбросит Exception,
когда пользователь вводит пустую строку. Пользователю
должно показаться сообщение, что пустые строки вводить нельзя.
 */
public class task2 {
    public static void main(String[] args) {
        prompt();
    }
    public static void prompt() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите не пустую строку: ");
        String line = scanner.nextLine();
        if(!line.isEmpty()) {
            System.out.println(line);
            prompt();
        }
        else {
            throw new RuntimeException("Пустые строки вводить нельзя.");
        }
    }
}
