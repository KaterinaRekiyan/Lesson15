package ru.netology;

public class TicketRepository {

    private Ticket[] tickets  = new Ticket[0];

    public void add(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tickets.length] = ticket;
        tickets = tmp;
    }

    public void removeById (int removeId) {
        if (findById(removeId) == null) {
            throw new NotFoundException(removeId);
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int indexToInsert = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != removeId) {
                tmp[indexToInsert] = ticket;
                indexToInsert++;
            }
        }
        tickets = tmp;
    }

    private Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if(ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public Ticket[] findAll() {
        return tickets;
    }
}
