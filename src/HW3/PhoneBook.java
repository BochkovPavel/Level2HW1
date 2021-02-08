package HW3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    Map<String, String> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add (String name, String phoneNumber){
        phoneBook.put(name, phoneBook.getOrDefault(name, "") + phoneNumber + "; ");

    }
    public void get(String name){
        String strNumber = "";
        if (phoneBook.containsKey(name)){
            System.out.println(name + ": " + phoneBook.get(name));
        }else{
            System.out.printf("Контакт с именем \"%s\" не найден!\n", name);
        }


    }



}
