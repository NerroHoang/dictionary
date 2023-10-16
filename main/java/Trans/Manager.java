package Trans;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import Common.Validation;
import java.util.Scanner;

public class Manager {

    private HashMap<String, String> hm;
    private Scanner scanner;
    public void run() {
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    addNewWord(hm);
                    break;
                case 2:
                    deleteWord(hm);
                    break;
                case 3:
                    translate(hm);
                    break;
                case 4:
                    scanner.close();
                    return;
            }
        }
    }
    //display  menu
    public int menu() {
        System.out.println("1. Add new word.");
        System.out.println("2. Delete word.");
        System.out.println("3. Search word.");
        System.out.println("4. Exit.");
        System.out.print("Enter your choice: ");
        int choice = Validation.checkInputIntLimit(1, 4);
        return choice;
    }

    //add new word
    public void addNewWord(HashMap<String, String> hm) {
        System.out.print("Enter Enlish: ");
        String english = Validation.checkInputString();
        if (!checkKeywordExist(hm, english)) {
            if (!Validation.checkInputYN()) {
                return;
            }
        }
        System.out.print("Enter Vietnamese: ");
        String vietnam = Validation.checkInputString();
        //check key word english exist or not
        hm.put(english, vietnam);
        System.err.println("Add successful.");
    }

    //delete word
    public void deleteWord(HashMap<String, String> hm) {
        System.out.print("Enter english: ");
        String english = Validation.checkInputString();
        hm.remove(english);
        System.err.println("Delete successful.");
    }

    //translate
    public void translate(HashMap<String, String> hm) {
        System.out.print("Enter english: ");
        String english = Validation.checkInputString();
        Set<Map.Entry<String, String>> entries = hm.entrySet();
        for (Map.Entry entry : entries) {
            if (entry.getKey().equals(english)) {
                System.out.println("Vietnamese: " + entry.getValue());
                return;
            }
        }
        System.err.println("Not found in data");
    }

    //check key englist exist
    public boolean checkKeywordExist(HashMap<String, String> hm, String english) {
        Set set = hm.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            if (english.equalsIgnoreCase(mentry.getKey().toString())) {
                return false;
            }
        }
        return true;
    }

}
