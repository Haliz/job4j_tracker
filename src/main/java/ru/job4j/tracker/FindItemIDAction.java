package ru.job4j.tracker;

public class FindItemIDAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        String selectID = input.askStr("Enter ID: ");
        Item foundItem = memTracker.findById(Integer.parseInt(selectID));
        if (foundItem == null) {
            System.out.println("Item not found");
        } else {
            System.out.println(foundItem);
        }
        return true;
    }
}
