package lab2;

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
}