package sem1;
/*
Реализуйте метод checkArray(Integer[] arr), принимающий в качестве
аргумента целочисленный одномерный массив.
Метод должен пройтись по каждому элементу и проверить что он не равен null.
А теперь реализуйте следующую логику:

Если в какой-то ячейке встретился null, то необходимо “оповестить”
об этом пользователя

Если null’ы встретились в нескольких ячейках, то идеально было
бы все их “подсветить”
 */
public class task4 {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, null, 5, null, null};
        CheckArray(array);

    }
    public static void CheckArray (Integer[] array) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if( array[i] == null) stringBuilder.append(i).append(" ");
        }
        if (stringBuilder.length() > 0) {
            throw new RuntimeException("В массиве находятся null-ы на индексах: " + stringBuilder);
        }
    }
}
