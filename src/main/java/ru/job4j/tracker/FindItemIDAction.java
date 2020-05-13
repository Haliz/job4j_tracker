package ru.job4j.tracker;

public class FindItemIDAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String selectID = input.askStr("Enter ID: ");
        Item foundItem = tracker.findById(selectID);
        if (foundItem == null) {
            System.out.println("Item not found");
        } else {
            System.out.println(foundItem);
        }
        return true;
    }
}
