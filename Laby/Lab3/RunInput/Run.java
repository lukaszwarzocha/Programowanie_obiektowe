package RunInput;

import Task.Tasks;
import java.util.Scanner;

public class Run {

    public void RunTask() {

        Tasks tasks = new Tasks();
        Input input = new Input();

        System.out.println("Laboratorium 3\n");
        System.out.println("Zadanie 1");
        System.out.println("Zadanie 2");
        System.out.println("Zadanie 3");
        System.out.println("Zadanie 4");
        System.out.println("Zadanie 5");
        System.out.println("Wybierz zadananie:");

        int wybor = input.InputInt();
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
            case 4:
                tasks.Task4();
                break;
                case 5:
                    System.out.println(tasks.Task5());
                    break;
           default:
                System.out.println("Nie ma takiego zadania");

        }
    }
    }