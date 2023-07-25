package sem1;
/*
Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
Необходимо посчитать и вернуть сумму элементов этого массива.
При этом накладываем на метод 2 ограничения: метод может
работать только с квадратными массивами (кол-во строк = кол-ву столбцов),
и в каждой ячейке может лежать только значение 0 или 1.
Если нарушается одно из условий, метод должен бросить RuntimeException
с сообщением об ошибке.
 */
public class task3 {
    public static void main(String[] args) {
        Integer[][] array = new Integer[][]{{1, 0}, {1, 0}};
        System.out.println(CheckArray(array));
    }
    public static Integer CheckArray (Integer[][] array) {
        int sum = 0;

        if (array.length != array[0].length) {
            throw new RuntimeException("Массив не квадратный");
        }

        for (int i = 0; i < array.length; i++) { // кол-во строк
            for (int j = 0; j < array[0].length; j++) { // столбцы
                if (array[i][j] != 0 && array[i][j] != 1) {
                    throw new RuntimeException("В ячейках на индексах: " + i + " " + j + " нет 0 или 1");
                }
                sum += array[i][j];
            }
        }
        return array.length;
    }
}
