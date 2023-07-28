package sem3;

import java.io.IOException;

/*
Создайте класс Счетчик, у которого есть метод add(),
увеличивающий значение внутренней int переменной на 1.
Сделайте так, чтобы с объектом такого типа можно было работать
в блоке try-with-resources. Подумайте, что должно происходить
при закрытии этого ресурса? Напишите метод для проверки, закрыт ли ресурс.
При попытке вызвать add() у закрытого ресурса, должен выброситься IOException
 */
public class task2 {
    public static void main(String[] args) {
        try (Counter counter = new Counter()){
            counter.add();
            System.out.println(counter.getValue());
            counter.close();
            System.out.println(counter.getValue());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Counter implements AutoCloseable {
    private Integer value = 0;
    public void add() throws IOException {
        if (value == null) throw new IOException("Значение закрыто");
        value += 1;
    }
    public Integer getValue() throws IOException {
        if (value == null) throw new IOException("Значение закрыто");
        return this.value;
    }
    @Override
    public void close() throws IOException {
        value = null;
    }
}