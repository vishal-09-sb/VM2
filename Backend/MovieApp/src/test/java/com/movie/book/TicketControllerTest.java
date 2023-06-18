package com.movie.book;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.moviebookingApp.controller.TicketController;
import com.moviebookingApp.model.Movie;
import com.moviebookingApp.model.Ticket;
import com.moviebookingApp.service.MovieService;
import com.moviebookingApp.service.SessionService;
import com.moviebookingApp.service.TicketService;

@RunWith(MockitoJUnitRunner.class)
public class TicketControllerTest {

    @Mock
    private TicketService ticketService;

    @Mock
    private MovieService movieService;

    @Mock
    private SessionService sessionService;

    @InjectMocks
    private TicketController ticketController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddTicket_Success() throws Exception {
        // Arrange
        int movieId = 1;
        int seatsBooked = 2;
        String userName = "john";

        Movie movie = new Movie();
        movie.setMovieId(movieId);
        movie.setSeatsAvailable(5);

        Ticket ticket = new Ticket();
        ticket.setMovie_id_fk(movieId);
        ticket.setMovieName(movie.getMovieName());
        ticket.setTotalSeat(100);
        ticket.setUserName(userName);
        ticket.setSeatsAvailable(movie.getSeatsAvailable() - seatsBooked);
        ticket.setSeatsBooked(seatsBooked);

        when(movieService.getMovieById(movieId)).thenReturn(movie);
        when(ticketService.addTicket(ticket)).thenReturn(true);

        // Act
        ResponseEntity<?> response = ticketController.addTicket(movieId, seatsBooked, userName);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(ticket, response.getBody());
        verify(movieService).updateMovie(movie);
        verify(ticketService).addTicket(ticket);
    }

    @Test
    public void testAddTicket_SeatsUnavailable() throws Exception {
        // Arrange
        int movieId = 1;
        int seatsBooked = 10;
        String userName = "john";

        Movie movie = new Movie();
        movie.setMovieId(movieId);
        movie.setSeatsAvailable(5);

        when(movieService.getMovieById(movieId)).thenReturn(movie);

        // Act
        ResponseEntity<?> response = ticketController.addTicket(movieId, seatsBooked, userName);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Ticket cannot be created as seats you are trying to book is more than available seats", response.getBody());
        verifyZeroInteractions(ticketService);
    }

    @Test
    public void testAddTicket_MovieNotFound() throws Exception {
        // Arrange
        int movieId = 1;
        int seatsBooked = 2;
        String userName = "john";

        when(movieService.getMovieById(movieId)).thenReturn(null);

        // Act
        ResponseEntity<?> response = ticketController.addTicket(movieId, seatsBooked, userName);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Ticket cannot be created", response.getBody());
        verifyZeroInteractions(ticketService);
    }

    @Test
    public void testGetAllTickets_Success() throws Exception {
        // Arrange
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(new Ticket());
        ticketList.add(new Ticket());

        when(ticketService.getAllTickets()).thenReturn(ticketList);

    }    
}
