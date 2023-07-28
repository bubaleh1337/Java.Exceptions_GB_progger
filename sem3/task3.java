package sem3;

import java.io.*;

/*
Создайте класс исключения, который будет выбрасываться при делении на 0.
Исключение должно отображать понятное для пользователя сообщение об ошибке.

Создайте класс исключений, которое будет возникать при обращении к пустому
элементу в массиве ссылочного типа. Исключение должно отображать понятное
для пользователя сообщение об ошибке

Создайте класс исключения, которое будет возникать при попытке открыть
несуществующий файл. Исключение должно отображать понятное для пользователя
сообщение об ошибке.
 */
public class task3 {
    public static void main(String[] args) throws FileNotExist {
        try {
            File file = new File("text");
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
        } catch (FileNotFoundException e) {
            throw new FileNotExist("text");
        }
    }
}
class DivByZero extends ArithmeticException{
    public DivByZero() {
        super("Невозможно поделить на ноль.");
    }
}
class EmptyArrayElement extends NullPointerException{
    public EmptyArrayElement(int index) {
        super("Обращение к пустому элементу массива: " + index);
    }
    public EmptyArrayElement() {
        super("Обращение к пустому элементу массива: ");
    }
}

class FileNotExist extends FileNotFoundException {
    public FileNotExist(String path) {
        super("Такого файла не существует: " + path);
    }
    public FileNotExist() {
        super("Такого файла не существует.");
    }
}