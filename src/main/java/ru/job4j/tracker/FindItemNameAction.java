package ru.job4j.tracker;

public class FindItemNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Item by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String selectName = input.askStr("Enter name: ");
        Item[] found = tracker.findByName(selectName);
        if (found.length == 0) {
            System.out.println("Items not found");
        } else {
            for (Item foundItems : found) {
                System.out.println(foundItems);
            }
        }
        return true;
    }
}
