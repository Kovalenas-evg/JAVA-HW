import java.io.*;
import java.util.Scanner;

public class FileWork {
    private static boolean bool, bool1;
    private static boolean createFile = false;

    public static void main(String[] args) {
        // IO console dialog
        Scanner sc = new Scanner(System.in);

        // Вывод условий на экран
        System.out.println(
                        "Написать программу которая будет записывать Ф.И.О. студентов в файл.\n" +
                        "1. Если файла списка студентов еще нет - он должен быть создан автоматически\n" +
                        "2. Добавить возможность добавлять студентов в файл таким образом, чтоб к существующему списку был добавлен новый студент.\n" +
                        "3. Если студент с такой фамилией есть он не добавляется в файл\n" +
                        " Для просмотра списка студентов введите значение int 1, для добавления студента - 2 и нажмите ENTER. Для выхода - 0");

        bool = true;
        do {
            sc = new Scanner(System.in);
            if (sc.hasNextInt()) {

                switch (sc.nextInt()) {
                    case 0:
                        bool = false;
                        break;
                    case 1:
                    {
                        try {
                            if(isExistsFile()){
                                if(!createFile) { // переменная createFile - был ли создан новый файл в связи с его отсутствием
                                    // создание обьекта класса Student
                                    Student student = new Student();
                                    // вызов метода считывания файла
                                    student.ShowListStudents();
                                } else {
                                    System.out.println("В файле нет данных для вывода на экран");
                                }
                            };
                        } catch (IOException e) {
                            System.out.println("Невозможно прочитать файл");
                        }
                        bool = false;
                        break;
                    }
                    case 2:
                    {
                        try {
                            if(isExistsFile()){
                                // создание обьекта класса Student
                                Student student = new Student();
                                // вызов метода считывания файла
                                student.addStudents();
                            };
                        } catch (IOException e) {
                            System.out.println("Невозможна запись в файл");
                        }
                        bool = false;
                        break;
                    }
                    default:
                        System.out.println("Извините, Вы ввели некорректное значение");
                }
            } else
                System.out.println("Извините, Вы ввели некорректное значение");
        } while (bool);

        sc.close();
    }

    static boolean isExistsFile() {
        File file = new File("StudentsList.csv");

        if (!file.exists()) { // проверка существует ли файл
            try{
                file.createNewFile(); // создание файла
                System.out.println("Файл со списком студентов отсутствовал, был создан файл с названием: " + file.getName());
                createFile = true;
            } catch (IOException e) {
                System.out.println("Невозможно создать файл");
                return false;
            }
        }
        return true;
    }
}

