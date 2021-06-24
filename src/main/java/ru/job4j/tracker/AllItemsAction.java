package ru.job4j.tracker;

public class AllItemsAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        System.out.println("=== All Items ====");
        for (Item foundItems : memTracker.findAll()) {
            System.out.println(foundItems);
        }
        return true;
    }
}
