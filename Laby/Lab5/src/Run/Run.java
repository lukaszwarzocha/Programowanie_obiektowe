package Run;

import java.util.Scanner;
import Task.Tasks;

public class Run {

    public void RunTask() {
        Scanner scanner = new Scanner(System.in);
        Tasks tasks = new Tasks();

        System.out.println("Laboratorium 5\n");
        System.out.println("Zadanie 1");
        System.out.println("Zadanie 2");
        System.out.println("Zadanie 3");
        System.out.println("Wybierz zadananie:");
        int wybor = scanner.nextInt();

        switch (wybor) {
            case 1:
                tasks.Task1();
                break;
            case 2:
                tasks.Task2();
                break;
            case 3:
                tasks.Task3();
                break;
            default:
                System.out.println("Nie ma takiego zadania");

        }
    }
}
