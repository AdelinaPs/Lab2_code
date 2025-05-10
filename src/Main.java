import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SECTION_DIVIDER = "\n=========================================\n";

    public static void main(String[] args) {
        runProgram();
        scanner.close();
    }

    private static void runProgram() {
        boolean running = true;
        while (running) {
            try {
                runDotDemo();
                runLineDemo();
                runStudentDemo();
                runAdditionalTasks();
                running = false;
            } catch (InputMismatchException e) {
                handleInputError();
            }
        }
    }

    private static void runDotDemo() {
        printSectionHeader("Задание 1.1");

        Dot[] dots = new Dot[3];
        for (int i = 0; i < dots.length; i++) {
            System.out.printf("Введите x и y точки %d (через пробел): ", i + 1);
            dots[i] = createDotFromInput();
        }

        Arrays.stream(dots).forEach(System.out::println);
    }

    private static void runLineDemo() {
        printSectionHeader("Задание 2.1");

        System.out.println("Первая линия:");
        Line line1 = createLineFromInput();

        System.out.println("Вторая линия:");
        Line line2 = createLineFromInput();

        Line line3 = new Line(line1.getStart(), line2.getEnd());
        System.out.printf("Созданная линия из точек: %s%n", line3);

        modifyAndPrintLines(line1, line2, line3);
    }

    private static void runStudentDemo() {
        printSectionHeader("Задание 3.1");

        Student student = new Student("Вася", new int[]{3, 4, 5});
        Student student1 = new Student("Петя", student.getMarks());
        System.out.printf("%s : %s%n", student, student1);

        modifyAndPrintStudentMarks(student, student1);
    }

    private static void runAdditionalTasks() {
        printSectionHeader("Задание 4");

        System.out.println("Точки для задания 4.1:");
        Dot[] task4Dots = new Dot[3];
        for (int i = 0; i < task4Dots.length; i++) {
            System.out.printf("Введите x и y точки %d (через пробел): ", i + 1);
            task4Dots[i] = createDotFromInput();
        }
        Arrays.stream(task4Dots).forEach(System.out::println);

        printSectionHeader("Линии для задания 4.2");
        Line line41 = createLineFromInput("линии 4.1");
        Line line42 = createLineFromInput("линии 4.2");
        Line line43 = new Line(line41.getStart(), line42.getEnd());
        System.out.printf("Линия 4.3: %s%n", line43);

        printSectionHeader("Задание 5.3");
        Line lengthDemoLine = createLineFromInput("для вычисления длины");
        System.out.printf("Длина линии: %d%n", lengthDemoLine.getLength());
    }

    private static Dot createDotFromInput() {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return new Dot(x, y);
    }

    private static Line createLineFromInput() {
        return createLineFromInput("");
    }

    private static Line createLineFromInput(String lineDescription) {
        System.out.print("Введите x и y для начала " + lineDescription + "(через пробел): ");
        Dot start = createDotFromInput();

        System.out.print("Введите x и y для конца " + lineDescription + "(через пробел): ");
        Dot end = createDotFromInput();

        return new Line(start, end);
    }

    private static void modifyAndPrintLines(Line line1, Line line2, Line line3) {
        line1.setStart(new Dot(line1.getStart().getX() + 1, line1.getStart().getY() + 1));
        line1.setEnd(new Dot(line1.getEnd().getX() + 1, line1.getEnd().getY() + 1));
        line2.setStart(new Dot(line2.getStart().getX() + 1, line2.getStart().getY() + 1));
        line2.setEnd(new Dot(line2.getEnd().getX() + 1, line2.getEnd().getY() + 1));
        line3.setStart(line1.getStart());
        line3.setEnd(line2.getEnd());

        System.out.println("\nПосле изменения координат:");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        line1.setStart(new Dot(line1.getStart().getX() + 1, line1.getStart().getY() + 1));
        line1.setEnd(new Dot(line1.getEnd().getX() + 1, line1.getEnd().getY() + 1));

        System.out.println("\nПосле изменения координат строки 1, не затрагивая строку 3:");
        System.out.println(line1);
        System.out.println(line3);
    }

    private static void modifyAndPrintStudentMarks(Student student, Student student1) {
        int[] student1Marks = student1.getMarks();
        student1Marks[0] = 5;
        student1.setMarks(student1Marks);
        System.out.printf("%s : %s%n", student, student1);

        int[] andreyMarks = Arrays.copyOf(student.getMarks(), student.getMarks().length);
        Student andrey = new Student("Андрей", andreyMarks);
        System.out.printf("До изменений: %s : %s%n", student, andrey);

        int[] vasyaMarks = student.getMarks();
        vasyaMarks[0] = 2;
        student.setMarks(vasyaMarks);
        System.out.printf("После изменений: %s : %s%n", student, andrey);
    }

    private static void printSectionHeader(String title) {
        System.out.println(SECTION_DIVIDER + title + SECTION_DIVIDER);
    }

    private static void handleInputError() {
        System.out.println("Некорректный ввод. Пожалуйста, введите целое число.");
        scanner.next();
    }
}
