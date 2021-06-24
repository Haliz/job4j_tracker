package ru.job4j.tracker;

import java.util.List;

public class FindItemNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Item by name ====";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        String selectName = input.askStr("Enter name: ");
        List<Item> found = memTracker.findByName(selectName);
        if (found.size() == 0) {
            System.out.println("Items not found");
        } else {
            for (Item foundItems : found) {
                System.out.println(foundItems);
            }
        }
        return true;
    }
}
