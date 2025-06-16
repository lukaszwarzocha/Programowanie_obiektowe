
import java.util.Scanner;

public class Run {
    public void RunTask() {

        Tasks task = new Tasks();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=======================");
        System.out.println("Dostepne opcje:");
        System.out.println("1: Zadanie1");
        System.out.println("2: Zadanie2");
        System.out.println("=======================");

        System.out.println("Podaj wybor:");
        int wybor = scanner.nextInt();

        switch(wybor) {
            case 1:
                task.Task1();
                break;
                case 2:
                    task.Task2();
                    break;
                    default:
                        System.out.println("Nie znaleziono takiej opcji");
        }
    }
}
