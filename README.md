#
# <span>__Решение домашних заданий к семинару 3. Продвинутая работа с исключениями в Java.__</span>

## **Задача 1.**

Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол

**Форматы данных:**

фамилия, имя, отчество - строки

датарождения - строка формата dd.mm.yyyy

номертелефона - целое беззнаковое число без форматирования

пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида

<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.

Данная промежуточная аттестация оценивается по системе "зачет" / "не зачет"

"Зачет" ставится, если слушатель успешно выполнил
"Незачет"" ставится, если слушатель успешно выполнил

Критерии оценивания:
Слушатель напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом

[Решение](https://github.com/bubaleh1337/Java.Exceptions_GB_progger/blob/main/sem3/hw3/task1.java)

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
