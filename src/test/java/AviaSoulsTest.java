import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import ru.netology.AviaSouls;
import ru.netology.Ticket;
import ru.netology.TicketTimeComparator;

import java.util.Arrays;

public class AviaSoulsTest {
    Ticket ticket = new Ticket("Москва", "Волгоград", 3500, 8, 14); //6
    Ticket ticket2 = new Ticket("Москва", "Санкт-Петербург", 1500, 12, 15); //3
    Ticket ticket3 = new Ticket("Москва", "Воронеж", 4500, 7, 16); //9
    Ticket ticket4 = new Ticket("Москва", "Элиста", 3000, 20, 22); //2
    Ticket ticket5 = new Ticket("Москва", "Элиста", 2500, 4, 8); //4
    Ticket ticket6 = new Ticket("Москва", "Элиста", 2000, 6, 9); //3


    @Test
    public void shouldCompare() {
        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(ticket);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        Ticket[] tickets = {ticket, ticket2, ticket3};
        Arrays.sort(tickets);

        Ticket[] expected = {ticket2, ticket, ticket3};
        Ticket[] actual = tickets;
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWithNoTickets() {
        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(ticket);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);


        Ticket[] expected = new Ticket[0];
        Ticket[] actual = aviaSouls.search("Москва", "Париж");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSort() {
        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(ticket);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);


        Ticket[] expected = {ticket5, ticket4};
        Ticket[] actual = aviaSouls.search("Москва", "Элиста");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldComparatorWork() {
        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(ticket);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] tickets = {ticket, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(tickets, timeComparator);

        Ticket[] expected = {ticket4, ticket2, ticket5, ticket, ticket3};
        Ticket[] actual = tickets;
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSortWithComparator() {
        AviaSouls aviaSouls = new AviaSouls();


        aviaSouls.add(ticket);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4, ticket6, ticket5};
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Элиста", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }


}
