import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            try {

                // Задание 1.1
                System.out.println("\n=========================================");
                System.out.println("Задание 1.1");
                System.out.println("=========================================\n");
                System.out.print("Введите x и y точки 1 (через пробел): ");
                int x1 = scanner.nextInt();
                int y1 = scanner.nextInt();

                System.out.print("Введите x и y точки 2 (через пробел): ");
                int x2 = scanner.nextInt();
                int y2 = scanner.nextInt();

                System.out.print("Введите x и y точки 3 (через пробел): ");
                int x3 = scanner.nextInt();
                int y3 = scanner.nextInt();

                Dot dot = new Dot(x1, y1);
                Dot dot1 = new Dot(x2, y2);
                Dot dot2 = new Dot(x3, y3);

                System.out.println(dot);
                System.out.println(dot1);
                System.out.println(dot2);


                // Задание 2.1
                System.out.println("\n=========================================");
                System.out.println("Задание 2.1");
                System.out.println("=========================================\n");

                // Ввод для линии 1
                System.out.print("Введите x и y для начала первой линии(через пробел): ");
                int x1Start = scanner.nextInt();
                int y1Start = scanner.nextInt();

                System.out.print("Введите x и y для конца первой линии(через пробел): ");
                int x1End = scanner.nextInt();
                int y1End = scanner.nextInt();

                // Ввод для линии 2
                System.out.print("Введите x и y для начала второй линии(через пробел): ");
                int x2Start = scanner.nextInt();
                int y2Start = scanner.nextInt();

                System.out.print("Введите x и y для конца второй линии(через пробел): ");
                int x2End = scanner.nextInt();
                int y2End = scanner.nextInt();

                // Создание линий с вводом пользователя
                Line line1 = new Line(new Dot(x1Start, y1Start), new Dot(x1End, y1End));
                Line line2 = new Line(new Dot(x2Start, y2Start), new Dot(x2End, y2End));

                System.out.println(line1);
                System.out.println(line2);

                Line line3 = new Line(line1.getStart(), line2.getEnd());
                System.out.println(line3);

                line1.setStart(new Dot(x1Start + 1, y1Start + 1));
                line1.setEnd(new Dot(x1End + 1, y1End + 1));
                line2.setStart(new Dot(x2Start + 1, y2Start + 1));
                line2.setEnd(new Dot(x2End + 1, y2End + 1));

                line3.setStart(line1.getStart());
                line3.setEnd(line2.getEnd());

                System.out.println("\nПосле изменения координат:");
                System.out.println(line1);
                System.out.println(line2);
                System.out.println(line3);

                line1.setStart(new Dot(x1Start + 2, y1Start + 2));
                line1.setEnd(new Dot(x1End + 2, y1End + 2));

                System.out.println("\nПосле изменения координат строки 1, не затрагивая строку 3:");
                System.out.println(line1);
                System.out.println(line3);

                // Задание 3.1
                System.out.println("\n=========================================");
                System.out.println("Задание 3.1");
                System.out.println("=========================================\n");

                // Ввод имени студента
                Student student = new Student("Вася", new int[]{3, 4, 5});
                Student student1 = new Student("Петя", student.getMarks());
                System.out.println(student + " : " + student1);

                int[] student1Marks = student1.getMarks();
                student1Marks[0] = 5;
                student1.setMarks(student1Marks);

                System.out.println(student + " : " + student1); // Результаты студента 1 тоже изменились, так как массивы одинаковые

                // Задание 4
                System.out.println("\n=========================================");
                System.out.println("Задание 4");
                System.out.println("=========================================\n");

                // 4.1
                System.out.print("Введите x и y для точки 1 (через пробел): ");
                int x4 = scanner.nextInt();
                int y4 = scanner.nextInt();

                System.out.print("Введите x и y для точки 2 (через пробел): ");
                int x5 = scanner.nextInt();
                int y5 = scanner.nextInt();

                System.out.print("Введите x и y для точки 3 (через пробел): ");
                int x6 = scanner.nextInt();
                int y6 = scanner.nextInt();

                Dot dot4 = new Dot(x4, y4);
                Dot dot5 = new Dot(x5, y5);
                Dot dot6 = new Dot(x6, y6);

                System.out.println(dot4);
                System.out.println(dot5);
                System.out.println(dot6);

                System.out.println("\n=========================================\n");

                // 4.2
                System.out.print("Введите x и y координаты для начала линии 4.1 (через пробел): ");
                int x41_start = scanner.nextInt();
                int y41_start = scanner.nextInt();

                System.out.print("Введите x и y координаты для конца линии 4.1 (через пробел): ");
                int x41_end = scanner.nextInt();
                int y41_end = scanner.nextInt();

                Line line41 = new Line(new Dot(x41_start, y41_start), new Dot(x41_end, y41_end));
                System.out.println(line41);

                System.out.print("Введите x и y координаты для начала линии 4.2 (через пробел): ");
                int x42_start = scanner.nextInt();
                int y42_start = scanner.nextInt();

                System.out.print("Введите x и y координаты для конца линии 4.2 (через пробел): ");
                int x42_end = scanner.nextInt();
                int y42_end = scanner.nextInt();

                Line line42 = new Line(new Dot(x42_start, y42_start), new Dot(x42_end, y42_end));
                System.out.println(line42);

                System.out.println("Линия 4.3: ");
                Line line43 = new Line(line41.getStart(), line42.getEnd());
                System.out.println(line43);

                // Задание 5.3
                System.out.println("\n=========================================");
                System.out.println("Задание 5.3");
                System.out.println("=========================================\n");

                // Ввод координат начала линии
                System.out.print("Введите x и y начала линии (через пробел): ");
                int startX = scanner.nextInt();
                int startY = scanner.nextInt();

                // Ввод координат конца линии
                System.out.print("Введите x и y конца линии (через пробел): ");
                int endX = scanner.nextInt();
                int endY = scanner.nextInt();

                Line line = new Line(new Dot(startX, startY), new Dot(endX, endY));
                System.out.println(line);

                System.out.println("Длина линии: " + line.getLength());

                break;
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите целое число.");
                scanner.next(); // очистка буфера ввода
            }
        }
    }
}
