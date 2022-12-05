package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class ManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    Ticket t1 = new Ticket(1, 200, "MSC", "SPB", 60);
    Ticket t2 = new Ticket(2, 100, "UFA", "SPB", 120);
    Ticket t3 = new Ticket(3, 300, "MSC", "SPB", 60);
    Ticket t4 = new Ticket(4, 100, "MSC", "SPB", 60);
    Ticket t5 = new Ticket(5, 200, "MSC", "LON", 180);
    Ticket t6 = new Ticket(6, 400, "MSC", "SPB", 60);
    Ticket t7 = new Ticket(7, 600, "LON", "UFA", 180);
    Ticket t8 = new Ticket(8, 500, "MSC", "SPB", 60);

    @BeforeEach
    public void setup() {
        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
        manager.add(t8);
    }


    @Test
    public void testWhenFewTicketsFound() {
        Ticket[] expected = {t4, t3, t8, t6, t1};
        Ticket[] actual = manager.findAll("MSC", "SPB", Ticket::compareTo);
    }
    
}
