/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package seatreservation;

/**
 *
 * @author user
 */
public class SeatReservation {

    public static void main(String[] args) {
        ConcertHall concertHall = new ConcertHall(10); // Create a concert hall with 10 seats
        BookingClerk[] clerks = new BookingClerk[5]; // Array to hold booking clerks

        // Create and start booking clerks
        for (int i = 0; i < clerks.length; i++) {
            clerks[i] = new BookingClerk(concertHall);
            clerks[i].start();
        }

        // Wait for all clerks to finish
        for (BookingClerk clerk : clerks) {
            try {
                clerk.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Display the final state of seat reservations
        concertHall.displaySeats();
    }
}