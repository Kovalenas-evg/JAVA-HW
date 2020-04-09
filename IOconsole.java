import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

public class IOconsole {
    private static int task, a, b, c;
    private static String num1, num2, result;
    private static boolean bool;

    // 1. Найти максимум из 3-х чисел (if else)
    static void task1(int inputV){
        Scanner sc = new Scanner(System.in);

        if(inputV == 1) {
            bool = true;
            do {
                System.out.println("Введите int число a: ");
                sc = new Scanner(System.in);
                if (sc.hasNextInt()) {
                    a = sc.nextInt();
                    bool = false;
                } else
                    System.out.println("Извините, Вы ввели некорректное значение");
            } while(bool);

            bool = true;
            do {
                System.out.println("Введите int число b: ");
                sc = new Scanner(System.in);
                if (sc.hasNextInt()) {
                    b = sc.nextInt();
                    bool = false;
                } else
                    System.out.println("Извините, Вы ввели некорректное значение");
            } while(bool);

            bool = true;
            do {
                System.out.println("Введите int число c: ");
                sc = new Scanner(System.in);
                if (sc.hasNextInt()) {
                    c = sc.nextInt();
                    bool = false;
                } else
                    System.out.println("Извините, Вы ввели некорректное значение");
            } while(bool);
        }
        else {
            // Целочисленное значение в интервале [ -100; +100]
            a = (int) (Math.random() * (200 + 1)) - 100;
            b = (int) (Math.random() * (200 + 1)) - 100;
            c = (int) (Math.random() * (200 + 1)) - 100;
        }

        System.out.println("Число a = " + a + ", b = " + b + ", c = " + c);
        if (a >= b) {
            if (a >= c)
                System.out.println("Максимальное число " + a);
            else
                System.out.println("Максимальное число " + c);
        }
        else {
            if (b >= c)
                System.out.println("Максимальное число " + b);
            else
                System.out.println("Максимальное число " + c);
        }
    }

    // 2. Дано 2 числа типа String и вернуть их сумму тоже в String
    static void task2(int inputV){
        Scanner sc = new Scanner(System.in);
        if(inputV == 1) {
            bool = true;
            do {
                try {
                    System.out.println("Введите число a: ");
                    sc = new Scanner(System.in);
                    num1 = sc.nextLine();
                    a = Integer.parseInt(num1);
                    bool = false;
                } catch (NumberFormatException e) {
                    System.out.println("Извините, Вы ввели некорректное значение");
                }
            } while(bool);

            bool = true;
            do {
                try {
                    System.out.println("Введите число b: ");
                    sc = new Scanner(System.in);
                    num2 = sc.nextLine();
                    a = Integer.parseInt(num2);
                    bool = false;
                } catch (NumberFormatException e) {
                    System.out.println("Извините, Вы ввели некорректное значение");
                }
            } while(bool);
        }
        else {
            char[] chars = "1234567890".toCharArray();
            StringBuilder sb = new StringBuilder(5);
            Random random = new Random();

            for (int i = 0; i < 5; i++) {
                char c = chars[random.nextInt(chars.length)];
                sb.append(c);
            }
            String num1 = sb.toString();
            System.out.println(num1);

            sb.setLength(0);
            for (int i = 0; i < 5; i++) {
                char c = chars[random.nextInt(chars.length)];
                sb.append(c);
            }
            String num2 = sb.toString();
            System.out.println(num2);
        }

        result = Long.toString( Long.parseLong(num1) +  Long.parseLong(num2));
        System.out.println("Сумма чисел a = " + num1 + " и b " + num2 + " равна " + result);
    }

        // 3. Определить четное или нечетное число. Если четное вывести true если не четное false
        static void task3(int inputV){
            Scanner sc = new Scanner(System.in);
            if(inputV == 1) {
                bool = true;
                do {
                    System.out.println("Введите int число a: ");
                    sc = new Scanner(System.in);
                    if (sc.hasNextInt()) {
                        a = sc.nextInt();
                        bool = false;
                    } else
                        System.out.println("Извините, Вы ввели некорректное значение");
                } while (bool);
            }
            else {
                // Целочисленное значение в интервале [ -100; +100]
                a = (int) (Math.random() * (200 + 1)) - 100;
            }

            result = ((a % 2) == 0) ? "четное" : "нечетное";
            System.out.println("Число a = " + a + " является " + result);
        }

        // 4. Есть 2 стороны параллелограмма. Найти площадь параллелограмма
        static void task4(int inputV){
            Scanner sc = new Scanner(System.in);
            if(inputV == 1) {
                bool = true;
                do {
                    System.out.println("Введите сторону a: ");
                    sc = new Scanner(System.in);
                    // Если введеное значение стороны а не числового типа или значение равно <= 0, то сообщение об ошибке
                    if (sc.hasNextInt()) {
                        a = sc.nextInt();
                        if (a > 0)
                            bool = false;
                        else
                            System.out.println("Извините, Вы ввели некорректное значение");
                    } else
                        System.out.println("Извините, Вы ввели некорректное значение");
                } while(bool);

                bool = true;
                do {
                    sc = new Scanner(System.in);
                    System.out.println("Введите сторону b: ");
                        // Если введеное значение стороны b не числового типа или значение равно <= 0, то сообщение об ошибке
                    if (sc.hasNextInt()) {
                        b = sc.nextInt();
                        if(b > 0)
                            bool = false;
                        else
                            System.out.println("Извините, Вы ввели некорректное значение");
                    } else
                        System.out.println("Извините, Вы ввели некорректное значение");
                } while(bool);

                bool = true;
                do {
                    sc = new Scanner(System.in);
                    // Если введеное значение угла не числового типа, или значение равно <= 0, или >= 180, то сообщение об ошибке
                    System.out.println("Введите угол между сторонами: ");
                    if (sc.hasNextInt()) {
                        c = sc.nextInt();
                        if (c > 0 & c < 180)
                            bool = false;
                        else
                            System.out.println("Извините, Вы ввели некорректное значение");
                    } else
                        System.out.println("Извините, Вы ввели некорректное значение");
                } while(bool);
            }
            else {
                // Целочисленное значение сторон в интервале [ 1; +100]
                // Целочисленное значение угла в интервале [1; +179]
                a = (int) (Math.random() * (99)) + 1;
                b = (int) (Math.random() * (99)) + 1;
                c = (int) (Math.random() * (178)) + 1;
            }

            double S;
            if(c == 90)
                S = a * b;
            else
                S = a * b * Math.sin(Math.toRadians(c));

            System.out.println("Сторона a = " + a + ", b = " + b + ", угол между ними равен " + c +" градусов. \nПлощадь параллелограмма равна " + S);
        }

        // Написать программу которая вычислит и выведет на экран площадь треугольника если известны его стороны.
        static void task5(int inputV){
            // Формула Герона
            // S = √p(p - a)(p - b)(p - c)
            // p - полупериметр, p=(a+b+c)/2
            Scanner sc = new Scanner(System.in);
            if(inputV == 1) {
                bool = true;
                do {
                    System.out.println("Введите положительное int число a: ");
                    sc = new Scanner(System.in);
                    if (sc.hasNextInt()) {
                        a = sc.nextInt();
                        if (a > 0)
                            bool = false;
                        else
                            System.out.println("Извините, Вы ввели некорректное значение");
                    } else
                        System.out.println("Извините, Вы ввели некорректное значение");
                } while(bool);

                bool = true;
                do {
                    System.out.println("Введите положительное int число b: ");
                    sc = new Scanner(System.in);
                    if (sc.hasNextInt()) {
                        b = sc.nextInt();
                        if (b > 0)
                            bool = false;
                        else
                            System.out.println("Извините, Вы ввели некорректное значение");
                    } else
                        System.out.println("Извините, Вы ввели некорректное значение");
                } while(bool);

                bool = true;
                do {
                    System.out.println("Введите положительное int число c: ");
                    sc = new Scanner(System.in);
                    if (sc.hasNextInt()) {
                        c = sc.nextInt();
                        if (c > 0)
                            bool = false;
                        else
                            System.out.println("Извините, Вы ввели некорректное значение");
                    } else
                        System.out.println("Извините, Вы ввели некорректное значение");
                } while(bool);
            }
            else {
                // Целочисленное значение в интервале [ 1; +100]
                a = (int) (Math.random() * (99)) + 1;
                b = (int) (Math.random() * (99)) + 1;
                c = (int) (Math.random() * (99)) + 1;
            }

            double p = (double)(a + b + c) / 2;
            double S = (double)Math.sqrt(p * (p - a) * (p - b) * (p - c));

            System.out.println("Сторона a = " + a + ", b = " + b + ", c = " + c +". \nПлощадь треугольника равна " + S);
        }

    public static void main(String[] args)  {
        // IO console dialog
        Scanner sc = new Scanner(System.in);

        // Вывод условий на экран
        System.out.println("Условия заданий:\n" +
                "1. Найти максимум из 3-х чисел (if else)\n" +
                "2. Дано 2 числа типа String и вернуть их сумму тоже в String\n" +
                "3. Определить четное или нечетное число. Если четное вывести true если не четное false\n" +
                "4. Есть 2 стороны параллелограмма. Найти площадь параллелограмма\n" +
                "5. Написать программу которая вычислит и выведет на экран площадь треугольника если известны его стороны.\n" +
                "Для запуска задания введите значение int от 1 - 5 и нажмите ENTER. Для выхода - 0");

        // Выбор задания
        bool = true;
        do {
            sc = new Scanner(System.in);
            if (sc.hasNextInt()) {

                task = sc.nextInt();
                switch (task) {
                    case 0:
                        bool = false;
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        System.out.println("Для ручного ввода параметров введите значение int 1, для рандомных значений - значение int 2 и нажмите ENTER. Для выхода - 0");
                        bool = false;
                        break;
                    default:
                        System.out.println("Извините, Вы ввели некорректное значение");
                }
            } else
                System.out.println("Извините, Вы ввели некорректное значение");
        } while(bool);

        // Выбор способа инициализации значений
        bool = true;
        do {
            sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                int inputV = sc.nextInt();
                switch (inputV){
                    case 0:
                        bool = false;
                        break;
                    case 1:
                    case 2:
                        IOconsole ioconsole = new IOconsole();
                        if(task == 1)
                            ioconsole.task1(inputV);
                        else if(task == 2)
                            ioconsole.task2(inputV);
                        else if(task == 3)
                            ioconsole.task3(inputV);
                        else if(task == 4)
                            ioconsole.task4(inputV);
                        else ioconsole.task5(inputV);
                        bool = false;
                        break;
                    default:
                        System.out.println("Извините, Вы ввели некорректное значение");
                }
            } else
            System.out.println("Извините, Вы ввели некорректное значение");
        } while(bool);

        sc.close();
    }
}
