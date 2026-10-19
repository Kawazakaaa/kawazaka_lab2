package lab2;

import java.util.Scanner;

public class CountryService {

    private static ReaderTicket[] tickets;

    static {
        tickets = new ReaderTicket[] {
                new ReaderTicket("Иванов",      "Ефремов",   "Таис Афинская",       "16.05.19"),
                new ReaderTicket("Петрова",     "Ефремов",   "Таис Афинская",       "15.05.19"),
                new ReaderTicket("Сидоров",     "Толстой",   "Война и мир",         "10.03.19"),
                new ReaderTicket("Кузнецова",   "Ефремов",   "Лезвие бритвы",       "22.06.20"),
                new ReaderTicket("Смирнов",     "Пушкин",    "Евгений Онегин",      "01.02.21"),
                new ReaderTicket("Иванов",      "Ефремов",   "Таис Афинская",       "15.05.19"),
                new ReaderTicket("Морозова",    "Булгаков",  "Мастер и Маргарита",  "12.09.20")
        };
    }

    public static void printTickets() {
        System.out.println("\n Список читательских билетов");
        if (tickets == null || tickets.length == 0) {
            System.out.println("Массив пуст!");
            return;
        }
        for (ReaderTicket t : tickets) {
            System.out.println(t);
        }
    }
    public static void whoTookEfremovTais() {
        System.out.println("\nЧитатели, бравшие \"Таис Афинская\" Ефремова 15.05.19");
        final String AUTHOR = "Ефремов";
        final String TITLE  = "Таис Афинская";
        final String DATE   = "15.05.19";
        boolean found = false;

        for (ReaderTicket t : tickets) {
            if (t.getBookAuthor().equalsIgnoreCase(AUTHOR)
                    && t.getBookTitle().equalsIgnoreCase(TITLE)
                    && t.getIssueDate().equals(DATE)) {
                System.out.println(t.getReaderName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Таких читателей не найдено.");
        }
    }
    public static void countBooksByAuthor() {
        System.out.print("\nВведите автора для подсчёта книг => ");
        Scanner sc = new Scanner(System.in);
        String author = sc.nextLine().trim();

        int count = 0;
        for (ReaderTicket t : tickets) {
            if (t.getBookAuthor().equalsIgnoreCase(author)) {
                count++;
            }
        }
        System.out.println("Количество книг автора \"" + author + "\": " + count);
    }
    public static void sortReadersByBookCountDesc() {
        //Подсчитываем количество книг для каждого уникального читателя
        //Для простоты используем два параллельных массива
        String[] names  = new String[tickets.length];
        int[]    counts = new int[tickets.length];
        int unique = 0;

        for (ReaderTicket t : tickets) {
            int idx = -1;
            for (int i = 0; i < unique; i++) {
                if (names[i].equalsIgnoreCase(t.getReaderName())) {
                    idx = i;
                    break;
                }
            }
            if (idx == -1) {
                names[unique] = t.getReaderName();
                counts[unique] = 1;
                unique++;
            } else {
                counts[idx]++;
            }
        }

        //Сортировка пузырьком по убыванию количества книг
        for (int i = 0; i < unique - 1; i++) {
            for (int j = 0; j < unique - 1 - i; j++) {
                if (counts[j] < counts[j + 1]) {
                    int tmpC = counts[j];
                    counts[j] = counts[j + 1];
                    counts[j + 1] = tmpC;

                    String tmpN = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tmpN;
                }
            }
        }

        System.out.println("\n Читатели по убыванию количества выданных книг");
        for (int i = 0; i < unique; i++) {
            System.out.printf("Читатель: %-12s | Книг: %d%n", names[i], counts[i]);
        }
    }
    public static void fillTickets() {
        System.out.print("Введите количество записей => ");
        int n = (new Scanner(System.in)).nextInt();
        tickets = new ReaderTicket[n];
        System.out.println("Введите информацию о читательских билетах:");
        for (int i = 0; i < tickets.length; i++) {
            System.out.println("Запись " + (i + 1) + " =>");
            tickets[i] = new ReaderTicket();
        }
    }
    // HOBOE: добавлено в ветке refactor/extract-country-service
    public static boolean removeByReaderName(String readerName) {
        if (tickets == null) return false;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i].getReaderName().equalsIgnoreCase(readerName)) {
                ReaderTicket[] newTickets = new ReaderTicket[tickets.length - 1];
                for (int j = 0, k = 0; j < tickets.length; j++) {
                    if (j != i) newTickets[k++] = tickets[j];
                }
                tickets = newTickets;
                return true;
            }
        }
        return false;
    }

    public static int count() {
        return tickets == null ? 0 : tickets.length;
    }
    public static ReaderTicket searchByName(String name) {
        System.out.println("Поиск читателя: " + name);
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i].getReaderName().equals(name)) {
                return tickets[i];
            }
        }
        return null;
    }
}