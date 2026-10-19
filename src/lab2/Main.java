package lab2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        cycle:
        while (true) {
            System.out.println("1. Заполнить массив");
            System.out.println("2. Распечатать");
            System.out.println("3. Кто брал \"Таис Афинская\" Ефремова 15.05.19");
            System.out.println("4. Количество книг заданного автора");
            System.out.println("5. Упорядочить читателей по убыванию количества книг");
            System.out.println("6. Выход");
            System.out.print("Выберите пункт меню (1..6): ");

            int a = sc.nextInt();
            sc.nextLine();

            switch (a) {
                case 1: CountryService.fillTickets(); break;
                case 2: CountryService.printTickets(); break;
                case 3: CountryService.whoTookEfremovTais(); break;
                case 4: CountryService.countBooksByAuthor(); break;
                case 5: CountryService.sortReadersByBookCountDesc(); break;
                default: break cycle;
            }
        }
        System.out.println("Работа завершена.");
    }
}