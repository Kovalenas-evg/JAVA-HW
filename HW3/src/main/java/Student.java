import java.io.*;
import java.util.Scanner;

class Student {
    private String firstName;
    private String lastName;
    private String middleName;
    private boolean bool;
    private String arrFioColumn[] = {"lastName", "firstName", "middleName"};

    // сеттеры и геттеры ()
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    void ShowListStudents() throws IOException {
        // поток, который подключается к текстовому файлу
        FileReader fr = new FileReader("StudentsList.csv");
        // соединяем FileReader с BufferedReader
        BufferedReader reader = new BufferedReader(fr);

        // переменная для считывания данных построчно с файла
        String line;

        Student student = new Student();
        line = reader.readLine(); // считывание первой строки с файла
        if ((line) == null) {
            System.out.println("В файле нет данных для вывода на экран");
        } else {
            do {
                String arr[] = line.split("\\|");
                if (arr.length != arrFioColumn.length) {
                    System.out.println("Некорректная строка: " + line);
                } else {
                    student.setLastName(arr[0]);
                    student.setFirstName(arr[1]);
                    student.setMiddleName(arr[2]);

                    System.out.println(arrFioColumn[0] + ": " + student.getLastName() +
                            " | " + arrFioColumn[1] + ": " + student.getFirstName() +
                            " | " + arrFioColumn[2] + ": " + student.getMiddleName());
                }
            }
            while ((line = reader.readLine()) != null);
        }
        reader.close();
    }

    void addStudents() throws IOException {
        String strConsole; // вводимое значение
        String strFile; // строка, которая будет записана в файл
        Scanner sc = new Scanner(System.in);

        Student student = new Student();
        System.out.println("В файле разделитель полей символ | \nПоэтому в вводимых значениях данный символ будет АВТОМАТИЧЕСКИ УДАЛЯТСЯ!!!");

        // считывание ФИО с консоли и его преобразование:
        // удаление символа "|",
        // удаление лишних пробелов,
        // формирование каждого слова в формате: первая буква в верхем регистре, все остальные в нижнем регистре
        for (int j = 0; j < 3; j++) {
            bool = true;
            do {
                System.out.println("Введите " + arrFioColumn[j] + ": ");
                sc = new Scanner(System.in);
                try {
                    // считывание с консоли
                    strConsole = (sc.nextLine().trim()).replaceAll("\\|", "");
                    // удаление лишних пробелов
                    while (strConsole.indexOf("  ") != -1) {
                        strConsole = strConsole.replaceAll("  ", " ");
                    }

                    // если введено пусто или только пробелы, или только символы |
                    if (strConsole.equals("")) {
                        System.out.println("Введенно некоректное значение");
                        continue;
                    }

                    // формирование каждого слова в формате: первая буква в верхем регистре, все остальные в нижнем регистре
                    String arr[] = strConsole.split(" ");

                    StringBuilder stringBuilder = new StringBuilder();

                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = (arr[i].substring(0, 1).toUpperCase()) + (arr[i].substring(1).toLowerCase());
                        stringBuilder.append(arr[i] + " ");
                    }
                    // присвоение полю обьекта значение с консоли
                    if (arrFioColumn[j].equalsIgnoreCase("lastName")) {
                        student.setLastName(stringBuilder.toString().trim());
                    } else if (arrFioColumn[j].equalsIgnoreCase("firstName")) {
                        student.setFirstName(stringBuilder.toString().trim());
                    } else if (arrFioColumn[j].equalsIgnoreCase("middleName")) {
                        student.setMiddleName(stringBuilder.toString().trim());
                    } else {
                        System.out.println("Ошибка!!!");
                    }
                    //student.setLastName(stringBuilder.toString().trim());
                    bool = false;

                } catch (Exception e) {
                    continue;
                }
            } while (bool);
        }

        // закрытие сканера
        sc.close();

        // проверка на существование в файле
        FileReader fr = new FileReader("StudentsList.csv");  // поток, который подключается к текстовому файлу
        BufferedReader reader = new BufferedReader(fr);  // соединяем FileReader с BufferedReader

        boolean isExistsLastNameInFile = false;  // наличие Фамилии в файле

        String line, lastNameFile;

        while ((line = reader.readLine()) != null) { // считываем строки и парсим в массив строк
            String arr[] = line.split("\\|");

            if (arr.length == arrFioColumn.length) {
                lastNameFile = arr[0].trim();
                // удаление лишних пробелов
                while (lastNameFile.indexOf("  ") != -1) {
                    lastNameFile = lastNameFile.replaceAll("  ", " ");
                }

                // Если такая фамилия есть в файле
                if (lastNameFile.equalsIgnoreCase(student.getLastName())) {
                    isExistsLastNameInFile = true;
                    break;
                }
            }
        }

        // если не дублируется запись, то записываем в файл
        if (!isExistsLastNameInFile) {
            // формирование строки в файл
            strFile = student.getLastName() + "|" + student.getFirstName() + "|" + student.getMiddleName();

            reader = new BufferedReader(new FileReader("StudentsList.csv"));

            try {
                FileWriter fw = new FileWriter("StudentsList.csv", true);
                // если файл не пустой, то вставка с новой строки
                if (reader.readLine() != null) {
                    fw.write("\n" + strFile);
                } else {
                    fw.write(strFile);
                }

                System.out.println("Студента добавлено в файл: " + strFile);
                fw.close();
            } catch (FileNotFoundException e) {
                System.out.println("Невозможно записать в файл");
            }
        } else {
            System.out.println("Фамилия студента уже есть в файле: " + student.getLastName() + ". Данного студента не добавлено в файл");
        }

        reader.close();
    }
}