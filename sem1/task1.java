package sem1;

import java.util.Scanner;

/*
Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
Если длина массива меньше некоторого заданного минимума, метод возвращает -1,
 в качестве кода ошибки, иначе - длину массива.
 */
public class task1 {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, 4};
        int min = 5;
        System.out.println(CheckArray(array, min));
    }
    public static Integer CheckArray (Integer[] array, int min_val) {
        if (array.length < min_val) {
            return -1;
        }
        return array.length;
    }
}
