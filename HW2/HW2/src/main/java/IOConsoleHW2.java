import java.util.Arrays;
import java.util.Scanner;

public class IOConsoleHW2 {
    private static boolean bool = true;
    private static int  numApart,       // номер квартиры
            countLines,     // количество полос
            numFact,        // число для вычисления факториала
            factorial = 1,  // факториал числа
            sizeArray;      // размер массива
    private static String strConsole;   // строка символов

    // 1. Есть девятиэтажный дом, в котором 4 подъезда. Номер подъезда начинается с единицы.
    // На одном этаже 4 квартиры. Напишите программу которая получит номер квартиры с клавиатуры,
    // и выведет на экран на каком этаже, какого подъезда расположенна эта квартира.
    // Если такой квартиры нет в этом доме то нужно сообщить об этом пользователю.
    static void task1() {

        double countEntrances = 4.0; // количество подьездов
        double countFloors = 9.0; // количество этажей
        double countApart = 4.0; // количество квартир на этаже
        // 36 квартир в подьезде
        // всего 144 квартиры в доме

        Scanner sc = new Scanner(System.in);

        // считывание значения с консоли
        // введенное значение должно быть больше 0
        bool = true;
        do {
            System.out.println("Введите номер квартиры (int): ");
            sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                numApart = sc.nextInt();
                if (numApart <= 0) {
                    System.out.println("Извините, Вы ввели некорректное значение");
                    continue;
                }
                else if (numApart > (countEntrances * countFloors * countApart)){
                    System.out.println("Извините, такой квартиры не существует! Максимальный номер квартиры - " + (int)(countEntrances * countFloors * countApart));
                    continue;
                }
                bool = false;
            } else
                System.out.println("Извините, Вы ввели некорректное значение");
        } while (bool);
        // res_p - вычисление подьезда
        int res_p = (int) Math.ceil((numApart / (countFloors * countApart)));
        // res_e - вычисление этажа
        int res_e = (int) Math.ceil(((numApart - (res_p - 1) * (countFloors * countApart)) / countApart));

        System.out.println(numApart + " квартира находится в " + res_p + " подьезде на " + res_e + " этаже");

    }

    // 2. С помощью циклов нарисовать «обои». Причем количество полос должно вводиться с клавиатуры. В примере 7 полос.\n" +
    // "  ***+++***+++***+++***\n" +
    // "  ***+++***+++***+++*** \n" +
    // "  ***+++***+++***+++*** \n" +
    // "  ***+++***+++***+++*** \n" +
    // "  ***+++***+++***+++*** \n" +
    static void task2() {
        // сохранение шаблона полосы в переменную
        String line = "***+++***+++***+++***";

        Scanner sc = new Scanner(System.in);

        // считывание значения с консоли
        // введенное значение должно быть не меньше 0 (!!! разрешено 0 полос)
        bool = true; // переменная для цикла
        do {
            System.out.println("Введите количество выводимых полос (int): ");
            sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                countLines = sc.nextInt();
                if (countLines < 0) {
                    System.out.println("Извините, Вы ввели некорректное значение");
                    continue;
                }
                bool = false;
            } else
                System.out.println("Извините, Вы ввели некорректное значение");
        } while (bool);

        System.out.println("Обои, в которых количество полос равно " + countLines);
        // вывод полос с помощью цикла
        for (int i = 1; i <= countLines; i++){
            System.out.println(line);
        }
    }

    // 3.Вычислить с помощью цикла факториал числа - n введенного с клавиатуры (4 < n < 16).
    // Факториал числа это произведение всех чисел от этого числа до 1. Например 5!=5*4*3*2*1=120
    static void task3() {
        Scanner sc = new Scanner(System.in);

        // считывание значения с консоли
        // введенное значение должно быть 4 < n < 16
        bool = true;
        do {
            System.out.println("Введите int число n (4 < n < 16) для вычисления его факториала: ");
            sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                numFact = sc.nextInt();
                if (numFact < 5 | numFact > 15) {
                    System.out.println("Извините, Вы ввели некорректное значение");
                    continue;
                }
                bool = false;
            } else
                System.out.println("Извините, Вы ввели некорректное значение");
        } while (bool);

        // вычисление факториала
        // обобщенное правило:  факториал числа 0 равен 1,
        //                      факториал положительного числа равен произведени. натуральных чисел от 1 до самого числа (включая данное число),
        //                      факториала отрицательного числа не существует
        if (numFact == 0)
            factorial = 1;
        else if (numFact > 0) {
            for (int i = 1; i <= numFact; i++){
                factorial *= i;
            }
        } else if (numFact < 0){
            System.out.println("Факториал числа " + numFact + " не существует");
            return;
        }

        System.out.println("Факториал числа " + numFact + "! равен " + factorial);
    }

    // 4.Дан массив {0,5,2,4,7,1,3,19} — написать программу для подсчета нечетных цифр в нем.
    static void task4() {
        int array[] = {0, 5, 2, 4, 7, 1, 3, 19};
        int count = 0; // количество нечетных цифр в массиве

        // 1й способ
        // подсчет нечетных цифр в массиве с помощью foreach
        for(int x: array){
            if((x % 2) != 0) {
                count++;
            }
        }

        /*
        // 2й способ
        // подсчет нечетных цифр в массиве с помощью for
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 != 0){
                count++;
            }
        }
         */

        System.out.println("В массиве " + Arrays.toString(array) + " " + count + " нечетных чисел");
    }

    // 5.Написать код для возможности создания массива целых чисел (размер вводиться с клавиатуры) заполните
    // элементы произвольными числами. Выведите этот массив на экран.
    static void task5() {
        Scanner sc = new Scanner(System.in);

        // считывание значения с консоли
        // введенное значение должно больше 0, так как размер массива не может быть <= 0
        bool = true;
        do {
            System.out.println("Введите размер (int) массива: ");
            sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                sizeArray = sc.nextInt();
                if (sizeArray < 1) {
                    System.out.println("Извините, Вы ввели некорректное значение");
                    continue;
                }
                bool = false;
            } else
                System.out.println("Извините, Вы ввели некорректное значение");
        } while (bool);

        // создание массива
        int array[] = new int[sizeArray];
        // инициализация массива рандомными числами от -100 до 100
        for(int i = 0; i < sizeArray; i++){
            array[i] = (int) (Math.random() * (200 + 1)) - 100; // рандомное число от -100 до 100
        }

        System.out.println("Массив размером " + sizeArray + " заполненный рандомными целыми числами (от -100 до 100) : \n" + Arrays.toString(array));
    }

    // 6.Создать массив случайных чисел (размером 15 элементов). Создайте второй массив в два раза больше, первые 15 элементов
    // должны быть равны элементам первого массива, а остальные элементы заполнить удвоенных значением начальных. Например
    //  Было → {1,4,7,2}
    //  Стало → {1,4,7,2,2,8,14,4}
    static void task6() {
        sizeArray = 15; // размер массива
        // создание массива
        int array[] = new int[sizeArray];

        // 1й способ
        // инициализация первого массива рандомными числами от -100 до 100
        for (int i = 0; i < sizeArray; i++) {
            array[i] = (int) (Math.random() * (200 + 1)) - 100; // рандомное число от -100 до 100
        }

        // создание второго массива, размером в два раза больше первого массива
        int newArray[] = Arrays.copyOf(array, array.length * 2);
        // инициализвация второго массива
        for(int i = 0; i < sizeArray; i++){
            newArray[i + sizeArray] = newArray[i] * 2;
        }

        /*
        // 2й способ
        // заполнение второго массива можно выполнять и при инициализации первого массива
        int newArray[] = Arrays.copyOf(array,sizeArray * 2);
        // инициализация первого массива рандомными числами от -100 до 100
        for (int i = 0; i < sizeArray; i++) {
            array[i] = (int) (Math.random() * (200 + 1)) - 100; // рандомное число от -100 до 100
            // инициализация второго массива
            newArray[i] = array[i];
            newArray[i + sizeArray] = array[i] * 2;
        }
        */

        System.out.println("Исходный массив размерностью " + sizeArray + ", заполненный целыми числами: \n" + Arrays.toString(array));
        System.out.println("Второй массив размерностью " + (sizeArray * 2) + ", в котором первые " + sizeArray + " элементов равны элементам первого массива, а остальные элементы удвоенные значения начальных \n" + Arrays.toString(newArray));
    }

    // 7.Введите строку текста с клавиатуры — реализуйте программу для
    // возможности подсчета количества символа — 'b' в этой строке, с выводом результат на экран.
    static void task7() {
        Scanner sc = new Scanner(System.in);

        // считывание значения с консоли
        System.out.println("Введите строку: ");
        sc = new Scanner(System.in);
        strConsole = sc.nextLine();
        int countSymbol = 0; // количество символов 'b' и 'B' в введенной строке

        // с помощью цикла считывание строки посимвольно
        for(int i = 0; i < strConsole.length(); i++) {
            if (strConsole.charAt(i) == 'b' | strConsole.charAt(i) == 'B')
                countSymbol++;
        }

        System.out.println("В строке \"" + strConsole + "\" количество символов 'b' и 'B' равно " + countSymbol);
    }

    public static void main(String[] args) {
        // IO console dialog
        Scanner sc = new Scanner(System.in);

        // Вывод условий на экран
        System.out.println("Условия заданий:\n" +
                "1.Есть девятиэтажный дом, в котором 4 подъезда. Номер подъезда начинается с единицы.\n" +
                "  На одном этаже 4 квартиры. Напишите программу которая получит номер квартиры с клавиатуры,\n" +
                "  и выведет на экран на каком этаже, какого подъезда расположенна эта квартира.\n" +
                "  Если такой квартиры нет в этом доме то нужно сообщить об этом пользователю.\n" +
                "2. С помощью циклов нарисовать «обои». Причем количество полос должно вводиться с клавиатуры. В примере 7 полос.\n" +
                "  ***+++***+++***+++***\n" +
                "  ***+++***+++***+++*** \n" +
                "  ***+++***+++***+++*** \n" +
                "  ***+++***+++***+++*** \n" +
                "  ***+++***+++***+++*** \n" +
                "3.Вычислить с помощью цикла факториал числа - n введенного с клавиатуры (4<n<16). " +
                "  Факториал числа это произведение всех чисел от этого числа до 1. Например 5!=5*4*3*2*1=120 \n" +
                "4.Дан массив {0,5,2,4,7,1,3,19} — написать программу для подсчета нечетных цифр в нем. \n" +
                "5.Написать код для возможности создания массива целых чисел (размер вводиться с клавиатуры) заполнените " +
                "  элементы произвольными числами. Выведите этот массив на экран. \n" +
                "6.Создать массив случайных чисел (размером 15 элементов). Создайте второй массив в два раза больше, " +
                "  первые 15 элементов должны быть равны элементам первого массива, а остальные элементы заполнить удвоенных значением начальных. Например \n" +
                "  Было → {1,4,7,2} \n" +
                "  Стало → {1,4,7,2,2,8,14,4}\n" +
                "7.Введите строку текста с клавиатуры — реализуйте программу для \n" +
                " возможности подсчета количества символа — 'b' в этой строке, с выводом результат на экран.\n\n" +
                " Для запуска задания введите значение int от 1 - 7 и нажмите ENTER. Для выхода - 0");

        // Выбор задания
        bool = true;
        do {
            sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                IOConsoleHW2 ioconsole = new IOConsoleHW2();
                switch (sc.nextInt()) {
                    case 0:
                        bool = false;
                        break;
                    case 1:
                        ioconsole.task1();
                        bool = false;
                        break;
                    case 2:
                        ioconsole.task2();
                        bool = false;
                        break;
                    case 3:
                        ioconsole.task3();
                        bool = false;
                        break;
                    case 4:
                        ioconsole.task4();
                        bool = false;
                        break;
                    case 5:
                        ioconsole.task5();
                        bool = false;
                        break;
                    case 6:
                        ioconsole.task6();
                        bool = false;
                        break;
                    case 7:
                        ioconsole.task7();
                        bool = false;
                        break;
                    default:
                        System.out.println("Извините, Вы ввели некорректное значение");
                }
            } else
                System.out.println("Извините, Вы ввели некорректное значение");
        } while(bool);
    }
}
