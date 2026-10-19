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
}