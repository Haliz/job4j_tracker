package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String selectID = input.askStr("Enter ID: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(selectID, item)) {
            System.out.println("Item replaced");
        } else {
            System.out.println("Error: Can not replace Item");
        }
        return true;
    }
}
