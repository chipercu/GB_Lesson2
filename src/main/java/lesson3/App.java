package lesson3;

import java.util.HashSet;

public class App {

    private static final String[] texts = {
            "спать", "завтракать", "обедать", "вставать", "работать", "завтракать", "вставать",
            "вставать", "завтракать", "обедать", "обедать", "вставать", "работать", "спать", "завтракать"
    };


    public static void main(String[] args) {
        // 1. первая задача
        System.out.println(firstTask(texts));
        // 2. вторая задача
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("user1", 1111111);
        phoneBook.add("user2", 2222222);
        phoneBook.add("user3", 3333333);
        phoneBook.add("user1", 4444444);

        String name = "user1";
        System.out.println(name + " - " + phoneBook.get(name));
    }

    /**
     * Первая задача
     * метод принимает массив строк, делает подсчет одинаковых строк и возвращает список уникальных строк этого массива
     *
     * @param texts
     * @return
     */
    public static HashSet<String> firstTask(String[] texts) {
        final HashSet<String> set = new HashSet<>();
        for (String str : texts) {
            int count = 0;
            if (!set.contains(str)) {
                set.add(str);
                for (String text : texts) {
                    if (str.equalsIgnoreCase(text)) {
                        count++;
                    }
                }
                System.out.println(str + " - " + count);
            }
        }
        return set;
    }
}
