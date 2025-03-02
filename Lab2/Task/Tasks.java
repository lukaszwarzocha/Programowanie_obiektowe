package Task;

import java.util.Scanner;

public class Tasks {

    public void Task1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wspolczynnik a:");
        double a = scanner.nextDouble();
        System.out.println("Podaj wspolczynnik b:");
        double b = scanner.nextDouble();
        System.out.println("Podaj wspolczynnik c:");
        double c = scanner.nextDouble();

        double wynik = Math.pow(b, 2) - 4 * a * c;

        if (wynik > 0) {
            System.out.println("Wynik to: " + wynik + " zatem rownanie kwadratowe ma dwa rozwiazania");
        } else if (wynik < 0) {
            System.out.println("Wynik to " + wynik + " zatem rownanie kwadratowe nie ma rozwiazan");
        } else {
            System.out.println("Wynik to" + wynik + " zatem rownanie kwadratowe ma jedno rozwiazanie");
        }
        scanner.close();
    }


    public String Task2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wartosc x:");
        double x = scanner.nextDouble();

        String wynik = "Wynik funkcji a(x) to: " + funA(x) + "\n" + " Wynik funkcji b(x) to: " + funB(x) + "\n" + "Wynik funkcji c(x) to: " + funC(x);

        scanner.close();
        return wynik;
    }

    public static double funA(double x) {
        if (x > 0) {
            return 2 * x;
        } else if (x < 0) {
            return -3 * x;
        } else {
            return 0;
        }
    }

    public static double funB(double x) {
        if (x >= 1) {
            return x * x;
        } else {
            return x;
        }
    }

    public static double funC(double x) {
        if (x > 2) {
            return 2 + x;
        } else if (x == 2) {
            return 8;
        } else {
            return x - 4;
        }
    }


public String Task3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj x:");
        double x = scanner.nextDouble();
        System.out.println("Podaj y:");
        double y = scanner.nextDouble();
        System.out.println("Podaj z:");
        double z = scanner.nextDouble();

        String wynik = "Liczby w kolejnosci od najmniejszej do najwiekszej: "+sortowanie(x,y,z);
        return wynik;
}
public static String sortowanie(double x, double y, double z) {
        double temp;

        if (x > y) {
            temp = x;
            x = y;
            y = temp;
        }
        if (y > z) {
            temp = y;
            y = z;
            z = temp;
        }
        if (x > y) {
            temp = x;
            x = y;
            y = temp;
        }

        return x + " " + y + " " + z;
}
public String Task4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Czy pada deszcz?");
        boolean deszcz = scanner.nextBoolean();
        System.out.println("Czy jest autobus?");
        boolean autobus = scanner.nextBoolean();

        String wynik = sprawdzenie1(deszcz,autobus);
        return wynik;
}
public static String sprawdzenie1(boolean deszcz, boolean autobus){
      if (deszcz && autobus){
          return "Weź parasol.\n Dostaniesz się na uczelnie";
      }
      else if (deszcz && !autobus){
          return "Nie dostaniesz sie na uczelnie.";
      }
      else if (!deszcz && autobus){
          return "Dostaniesz sie na uczelnie.\n Milego dnia i pieknej pogody.";
      }
      else {
          return "";
      }
}
public String Task5() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Czy jest znizka na samochod:");
        boolean znizka = scanner.nextBoolean();
        System.out.println("Czy otrzymales premie:");
        boolean premia = scanner.nextBoolean();

        String wynik = sprawdzenie2(znizka, premia);
        return wynik;
}
public static String sprawdzenie2(boolean znizka, boolean premia){
         if (!znizka && !premia) {
        return "Zakup samochodu trzeba odlozyc na pozniej...\nZnizki na samochod nie ma";
         }
        else if (!znizka || premia) {
            return "Mozesz kupic samochod!\nZnizki na samochod nie ma";
        }
        else if (znizka || premia) {
            return "Mozesz kupic samochod!";
        }
        else {
            return "";
        }
}
public static void Task6(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadz liczbe a:");
        double a = scanner.nextDouble();
        System.out.println("Wprowadz liczbe b:");
        double b = scanner.nextDouble();

        System.out.println("Wybierz opcje:");
        System.out.println("1.Dodawanie");
        System.out.println("2.Odejmowanie");
        System.out.println("3.Mnozenie");
        System.out.println("4.Dzielenie");
        System.out.println("5.Reszta z dzielenia");

        int wybor = scanner.nextInt();
        double result = 0;

        switch (wybor) {
            case 1:
                result = a + b;
                System.out.println("Wynik dodawania"+result);
                break;
            case 2:
                result = a - b;
                System.out.println("Wynik odejmowania"+result);
                break;
                case 3:
                    result = a * b;
                    System.out.println("Wynik mnozenia"+result);
                    break;
                    case 4:
                        result = a / b;
                        System.out.println("Wynik dzielenia"+result);
                        break;
                        case 5:
                            result = a % b;
                            System.out.println("Wynik reszta dzielenia"+result);
                            break;
                            default:
                                System.out.println("Nie ma takiej opcji!");
        }

}
}

