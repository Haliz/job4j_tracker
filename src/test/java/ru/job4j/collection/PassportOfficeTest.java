package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void get() {
        Citizen citizen1 = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen2 = new Citizen("1234", "Igor Khalizev");
        PassportOffice office = new PassportOffice();
        office.add(citizen1);
        office.add(citizen2);
        Citizen exp = office.get("1234");
        assertThat(exp.getUsername(), is("Igor Khalizev"));
    }
}
