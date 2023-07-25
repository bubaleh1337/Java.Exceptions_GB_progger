package sem2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
📔 Запишите в файл следующие строки:
Анна=4
Елена=5
Марина=6
Владимир=?
Константин=?
Иван=4
Реализуйте метод, который считывает данные из файла
и сохраняет в двумерный массив (либо HashMap, если студенты с ним знакомы).
В отдельном методе нужно будет пройти по структуре данных,
если сохранено значение ?, заменить его на соответствующее число.
Если на каком-то месте встречается символ, отличный от числа или ?,
бросить подходящее исключение.Записать в тот же файл данные с замененными символами ?.
 */
public class task1 {
    public static void main(String[] args) {
        File file = new File("D:\\Kate\\EDU\\GeekBrains\\lessons\\practice\\Java.Exceptions_GB_progger\\sem2\\names");
        List<String[]> lst = readFile(file);
        changeList(lst);
        writeFile(lst, file);
    }

    public static List<String[]> readFile(File file) {
        List<String[]> list = new ArrayList<>();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line.split("="));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static void changeList(List<String[]> lst) {
        for (String[] el : lst) {
            if (!checkException(el[1]) && !el[1].equals("?")) {
                throw new RuntimeException(el[1]);
            }
            if (el[1].equals("?")) el[1] = String.valueOf(el[0].length());
        }
    }

    public static boolean checkException(String line) {
        try {
            Integer.valueOf(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void writeFile(List<String[]> lst, File file) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (String[] el : lst) {
                bw.write(el[0] + "=" + el[1]);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
