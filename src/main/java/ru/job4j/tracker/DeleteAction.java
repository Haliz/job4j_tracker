package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        String selectID = input.askStr("Enter ID: ");
        boolean rsl = memTracker.delete(Integer.parseInt(selectID));
        if (rsl) {
            System.out.println("Item deleted");
        } else {
            System.out.println("Error: Can not delete Item");
        }
        return true;
    }
}