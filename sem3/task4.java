package sem3;
/*
Напишите метод, на вход которого подаётся двумерный строковый массив
размером 4х4. При подаче массива другого размера необходимо бросить исключение
MyArraySizeException.
Далее метод должен пройтись по всем элементам массива, преобразовать в int
и просуммировать. Если в каком-то элементе массива преобразование не удалось
(например, в ячейке лежит символ или текст вместо числа), должно быть
брошено исключение MyArrayDataException с детализацией, в какой именно
ячейке лежат неверные данные.
В методе main() вызвать полученный метод, обработать возможные исключения
MyArraySizeException и MyArrayDataException и вывести результат расчета
(сумму элементов, при условии что подали на вход корректный массив).
 */
public class task4 {
    public static void main(String[] args) {
        String[][] array = new String[][]{{"1", "2", "3", "jdfhjfk"}, {"1", "2", "3", "4"},{"1", "2", "3", "4"},{"1", "2", "3", "4"}};

        try {
            int sum = checkArray(array);
            System.out.println(sum);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    public static int checkArray(String[][] array) {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException(array.length, array[0].length);
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(int size, int size2) {
        super("Не подходящий размер массива. Ваш массив: " + size + "x" + size2);
    }
}
class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int index, int index2) {
        super("Не удалось преобразовать в int элементы: " + index + ":" + index2);
    }
}
