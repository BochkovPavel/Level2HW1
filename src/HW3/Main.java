package HW3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Item1 Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        // Посчитать сколько раз встречается каждое слово.
        String[] strArray = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday",
                "Wednesday", "Thursday", "Saturday", "Sunday"};
        System.out.println(Arrays.toString(strArray));
        Set<String> setArray = new HashSet<>(Arrays.asList(strArray));
        Map<String, Integer> mapArray = new HashMap<>();
        System.out.println(setArray.toString());
        for (String s : strArray) {
            mapArray.put(s, mapArray.getOrDefault(s, 0) + 1);
        }
        System.out.println(mapArray);
        //Item2 Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
        // В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get()
        // искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
        // (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
        PhoneBook book = new PhoneBook();
        book.add("Pavel", "89130087283");
        book.add("Pavel", "89130087284");
        book.add("Pavel", "89130087287");
        book.add("Ivan", "89130087293");
        book.add("Liza", "89130087273");
        book.add("Liza", "89130087278");
        book.get("Pavel");
        book.get("Liza");
        book.get("FFF");

    }
}
