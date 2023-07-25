#
# <span>__Решение домашних заданий к семинару 2. Исключения и их обработка.__</span>

## **Задача 1.**

Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

[Решение](https://github.com/bubaleh1337/Java.Exceptions_GB_progger/blob/main/sem2/hw2/task1.java)

## **Задача 2.**

Если необходимо, исправьте данный код ([задание 2](https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit))

**Решение:**

I. Код не скомпилируется по причине не существующего типа intArray[8]:
       
        double catchedRes1 = intArray[8] / d;

## **Задача 3.**

Дан следующий код, исправьте его там, где требуется ([задание 3](https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)

**Решение:**

I. Первый catch ловит всевозможные ошибки:

       catch (Throwable ex)

II. Лишнее throws Exception при объявлении метода, т.к. все ошибки обрабатываются в дальнейшем:

       public static void main(String[] args) throws Exception {

III. Лишняя обработка, т.к. нулевых значений в коде не наблюдается:

       catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");

IV. Лишнее throws FileNotFoundException при объявлении метода, т.к. нет работы с файлами в коде:

       public static void printSum(Integer a, Integer b) throws FileNotFoundException {
            System.out.println(a + b);
       }

## **Задача 4.**

Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

[Решение](https://github.com/bubaleh1337/Java.Exceptions_GB_progger/blob/main/sem2/hw2/task2.java)


#
