package lab2;

import java.util.Scanner;

public class ReaderTicket {

    private String readerName;// фамилия читателя
    private String bookAuthor;// автор книги
    private String bookTitle;// название книги
    private String issueDate;// дата выдачи книги (формат дд.мм.гг)

    //Статическое поле: массив объектов
    private static ReaderTicket[] tickets;

    //Статический блок первоначальной инициализации
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

    //Конструктор с параметрами
    public ReaderTicket(String readerName, String bookAuthor,
                        String bookTitle, String issueDate) {
        this.setReaderName(readerName);
        this.setBookAuthor(bookAuthor);
        this.setBookTitle(bookTitle);
        this.setIssueDate(issueDate);
    }

    //Конструктор по умолчанию (ввод с клавиатуры)
    public ReaderTicket() {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.print("Фамилия читателя : ");
        this.setReaderName(sc.nextLine());
        System.out.print("\tАвтор книги    : ");
        this.setBookAuthor(sc.nextLine());
        System.out.print("\tНазвание книги : ");
        this.setBookTitle(sc.nextLine());
        System.out.print("\tДата выдачи    : ");
        this.setIssueDate(sc.nextLine());
    }

    //Переопределение toString()
    @Override
    public String toString() {
        return String.format(
                "Читатель: %-12s | Автор: %-10s | Книга: %-25s | Дата выдачи: %s",
                readerName, bookAuthor, bookTitle, issueDate
        );
    }

    //Геттеры и сеттеры
    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String value) {
        if (value == null || value.trim().isEmpty()) {
            System.out.println("Недопустимое значение: фамилия читателя!");
        } else {
            this.readerName = value.trim();
        }
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String value) {
        if (value == null || value.trim().isEmpty()) {
            System.out.println("Недопустимое значение: автор книги!");
        } else {
            this.bookAuthor = value.trim();
        }
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String value) {
        if (value == null || value.trim().isEmpty()) {
            System.out.println("Недопустимое значение: название книги!");
        } else {
            this.bookTitle = value.trim();
        }
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String value) {
        // простая проверка формата дд.мм.гг
        if (value == null || !value.matches("\\d{2}\\.\\d{2}\\.\\d{2}")) {
            System.out.println("Недопустимое значение: дата должна быть в формате дд.мм.гг!");
        } else {
            this.issueDate = value;
        }
    }

    // СТАТИЧЕСКИЕ МЕТОДЫ КЛАССА
    //1. Заполнение массива с клавиатуры
    public static void fillTickets() {
        System.out.print("Введите количество записей => ");
        int n = (new Scanner(System.in, "cp1251")).nextInt();
        tickets = new ReaderTicket[n];
        System.out.println("Введите информацию о читательских билетах:");
        for (int i = 0; i < tickets.length; i++) {
            System.out.println("Запись " + (i + 1) + " =>");
            tickets[i] = new ReaderTicket();
        }
    }

    //2. Печать массива в табличном виде
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

    //3a. Кто брал книгу Ефремова "Таис Афинская" 15.05.19
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

    // 3b. Количество книг заданного автора
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