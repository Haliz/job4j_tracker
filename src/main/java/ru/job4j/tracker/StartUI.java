package ru.job4j.tracker;



public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== All Items ====");
                for (Item foundItems : tracker.findAll()) {
                    System.out.println(foundItems);
                }
            } else if (select == 2) {
                System.out.println("=== Edit Item ====");
                String selectID = input.askStr("Enter ID: ");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                if (tracker.replace(selectID, item)) {
                    System.out.println("Item replaced");
                } else {
                    System.out.println("Error: Can not replace Item");
                }
            } else if (select == 3) {
                System.out.println("=== Delete Item ====");
                String selectID = input.askStr("Enter ID: ");
                boolean rsl = tracker.delete(selectID);
                if (rsl) {
                    System.out.println("Item deleted");
                } else {
                    System.out.println("Error: Can not delete Item");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                String selectID = input.askStr("Enter ID: ");
                Item foundItem = tracker.findById(selectID);
                if (foundItem == null) {
                    System.out.println("Item not found");
                } else {
                    System.out.println(foundItem);
                }
            } else if (select == 5) {
                System.out.println("=== Find Item by name ====");
                String selectName = input.askStr("Enter name: ");
                Item[] found = tracker.findByName(selectName);
                if (found.length == 0) {
                    System.out.println("Items not found");
                } else {
                    for (Item foundItems : found) {
                        System.out.println(foundItems);
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
