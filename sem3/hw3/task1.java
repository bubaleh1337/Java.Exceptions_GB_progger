package sem3.hw3;

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
обработано, пользователю выведено сообщение с информацией, что именно неверно.

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
            printPB(human_info);
        } catch (RuntimeException e) {
            System.out.println();
        }
    }
    // Запрос у пользователя данных:
    public static String[] prompt(String msg) {
        System.out.println(msg);
        return scanner.nextLine().split(" ");
    }
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
        Matcher matcher = Date_PATTERN.matcher(date);
        return matcher.matches();
    }
    public static void printPB(String[] human) {
        for (String s : human) {
            System.out.print(s + " ");
        }
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
