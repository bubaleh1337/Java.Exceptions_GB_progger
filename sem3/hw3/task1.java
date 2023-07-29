package sem3.hw3;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном
порядке, разделенные пробелом: +

Фамилия Имя Отчество дата рождения номер телефона пол +

Форматы данных: +
фамилия, имя, отчество - строки
дата рождения - строка формата dd.mm.yyyy
номер телефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает
с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он
ввел меньше и больше данных, чем требуется. +

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно
обработано, пользователю выведено сообщение с информацией, что именно неверно. +

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
в него в одну строку должны записаться полученные данные, вида

<Фамилия><Имя><Отчество><дата рождения><номер телефона><пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
пользователь должен увидеть стектрейс ошибки.

Критерии оценивания:

Слушатель напишите приложение, которое будет запрашивать у пользователя следующие данные
в произвольном порядке, разделенные пробелом
 */
public class task1 {
    static Scanner scanner = new Scanner(System.in);
    private static final String Date_REGEX =
            "^(?:(?:(?:0?[13578]|1[02])(\\/|-|\\.)31)\\1|" +
                    "(?:(?:0?[1,3-9]|1[0-2])(\\/|-|\\.)(?:29|30)\\2))" +
                    "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:0?2(\\/|-|\\.)29\\3" +
                    "(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|" +
                    "[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|" +
                    "^(?:(?:0?[1-9])|(?:1[0-2]))(\\/|-|\\.)(?:0?[1-9]|1\\d|" +
                    "2[0-8])\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    private static final Pattern Date_PATTERN = Pattern.compile(Date_REGEX);

    public static void main(String[] args) {
        String[] human_info = new String[]{};
        try {
            human_info = prompt("Введите через пробел: ФИО, дату рождения, номер телефона и пол (f или m): ");
            checkAmount(human_info);
            for (int i = 0; i < human_info.length; i++) {
                checkFormat(human_info, i);
            }
            printPB(human_info);

            Map<Integer, String> sent = new HashMap<>();
            sent = parse(human_info);
            //вывод значений
            for (String value : sent.values()) {
                System.out.print(value + " ");
            }
        } catch (RuntimeException e) {
            System.out.println();
        }
    }
    // Запрос у пользователя данных:
    public static String[] prompt(String msg) {
        System.out.println(msg);
        return scanner.nextLine().split(" ");
    }
    // Парсинг полученных значений:
    public static Map<Integer, String> parse(String[] human_info) {
        Map<Integer, String> human = new HashMap<>();
        int i = 0;
        for (String word : human_info) {
            human.put(i++, word);
        }
        return human;
    }

    // Проверка формата введённых данных:
    public static void checkFormat(String[] human_info, int i) {
        switch (i) {
            case 0: // Проверка фамилии
                if(checkString(human_info[0]))
                    throw new StringException(-1);
            case 1: // Проверка имени
                if(checkString(human_info[1]))
                    throw new StringException(-1);
            case 2: // Проверка отчества
                if(checkString(human_info[2]))
                    throw new StringException(-1);
            case 3: // Проверка даты
                if (!dateValidator(human_info[3])) throw new StringException(-3);
            case 4: // Проверка номера телефона
                if(!checkString(human_info[4]))
                    throw new StringException(-2);
            case 5: // Проверка пола
                if (!human_info[5].equals("f") && !human_info[5].equals("m")) throw new StringException(-4);
        }
    }
    public static boolean checkString(String line) {
        try {
            Integer.valueOf(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
//    public static void checkFormat(Map<String, String> people) {
//        try {
//            Integer.valueOf(people.get(0));
//        } catch (StringException e) {
//
//        }
//        for (Map.Entry<String, String> item : people.entrySet()) {
//
//            System.out.printf("\nKey: %s  Value: %s \n", item.getKey(), item.getValue());
//        }
//    }

    // Проверка на количество введённых данных:
    public static void checkAmount(String[] human_info) {
        if (human_info.length < 6) throw new AmountException(-1);
        if (human_info.length > 6) throw new AmountException(-3);
    }
    // Записываем в массив:
//    public static String[] getArray(String[] human_info) {
//        String[] list = new String[]{};
//        if (dateValidator(date)) {
//            list[1] = date;
//        } else {
//            System.out.println(date + " - не верный формат даты. Попробуйте снова.");
//        }
//        return list;
//    }

    // Проверка валидности даты:
    public static boolean dateValidator(String date) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy");
        myFormat.setLenient(false);
        try {
            myFormat.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static void printPB(String[] human) {
        for (String s : human) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
class AmountException extends RuntimeException {
    public AmountException(int error) {
        super();
        switch (error) {
            case -1 -> System.out.println("Вы ввели меньше данных, чем нужно.");
            case -3 -> System.out.println("Вы ввели больше данных, чем нужно.");
        }
    }
}
class StringException extends NumberFormatException {
    public StringException(int error) {
        super();
        switch (error) {
            case -1 ->
                    System.out.println("Неккоректен формат ввода введённых данных. В ФИО должны быть только буквенные значения.");
            case -2 ->
                    System.out.println("Неккоректен формат ввода введённых данных. При вводе номера телефона должны быть только числовые значения.");
            case -3 ->
                    System.out.println("Неккоректен формат ввода введённых данных. Дата должна быть в формате: dd.mm.yyyy");
            case -4 ->
                    System.out.println("Неккоректен формат ввода введённых данных. Здесь нужно вводить либо f, либо m.");

        }
    }
}
