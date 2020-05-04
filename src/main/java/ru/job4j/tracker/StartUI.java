package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== All Items ====");
                for (Item foundItems : tracker.findAll()) {
                    System.out.println(foundItems);
                    /* System.out.println("ID " + foundItems.getId() + " - " + foundItems.getName());
                    переопределено строкой выше (метод toString() в классе Item)
                    */
                }
            } else if (select == 2) {
                System.out.println("=== Edit Item ====");
                System.out.print("Enter ID: ");
                String selectID = scanner.nextLine();
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.replace(selectID, item);
                if (tracker.replace(selectID, item)) {
                    System.out.println("Item replaced");
                } else {
                    System.out.println("Error: Can not replace Item");
                }
            } else if (select == 3) {
                System.out.println("=== Delete Item ====");
                System.out.print("Enter ID: ");
                String selectID = scanner.nextLine();
                boolean rsl = tracker.delete(selectID);
                if (rsl) {
                    System.out.println("Item deleted");
                } else {
                    System.out.println("Error: Can not delete Item");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.print("Enter ID: ");
                String selectID = scanner.nextLine();
                Item foundItem = tracker.findById(selectID);
                if (foundItem == null) {
                    System.out.println("Item not found");
                } else {
                    System.out.println(foundItem);
                   /* System.out.println("ID " + foundItem.getId() + " - " + foundItem.getName());
                   переопределено строкой выше (метод toString() в классе Item)
                    */
                }
            } else if (select == 5) {
                System.out.println("=== Find Item by name ====");
                System.out.print("Enter name: ");
                String selectName = scanner.nextLine();
                Item[] found = tracker.findByName(selectName);
                if (found.length == 0) {
                    System.out.println("Items not found");
                } else {
                    for (Item foundItems : found) {
                        System.out.println(foundItems);
                       // System.out.println("ID " + foundItems.getId() + " - " + foundItems.getName());
                    }
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

        private void showMenu() {
            System.out.println("Menu.");
            System.out.println("0. Add new Item");
            System.out.println("1. Show all items");
            System.out.println("2. Edit item");
            System.out.println("3. Delete item");
            System.out.println("4. Find item by Id");
            System.out.println("5. Find items by name");
            System.out.println("6. Exit Program");
        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
