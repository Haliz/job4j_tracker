package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(Integer.parseInt(item.getId())), is(item));
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(Integer.parseInt(item.getId()));
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void checkFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("Саша");
        tracker.add(item1);
        Item item2 = new Item("Ваня");
        tracker.add(item2);
        Item item3 = new Item("Вася");
        tracker.add(item3);
        List<Item> exp = List.of(item1, item2, item3);
        assertThat(exp, is(tracker.findAll()));
    }

    @Test
    public void checkFindName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("Саша");
        tracker.add(item1);
        Item item2 = new Item("Ваня");
        tracker.add(item2);
        Item item3 = new Item("Вася");
        tracker.add(item3);
        List<Item> exp = new ArrayList<>();
        exp.add(item2);
        assertThat(exp, is(tracker.findByName("Ваня")));
    }

    @Test
    public void whenReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(Integer.parseInt(id), bugWithDesc);
        assertThat(tracker.findById(Integer.parseInt(id)).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        tracker.delete(Integer.parseInt(id));
        assertThat(tracker.findById(Integer.parseInt(id)), is(nullValue()));
    }

    @Test
    public void findById() {
        SqlTracker tracker = new SqlTracker(connection);
            Item item = new Item("name");
            tracker.add(item);
            int id = Integer.parseInt(item.getId());
            assertThat(tracker.findById(id).getName(), is(item.getName()));
    }

}
