/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seatreservation;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author user
 */

public class ConcertHall {
    private final ConcurrentHashMap<Integer, Boolean> seats;
    private final int totalSeats; // Add this line to store the total number of seats

    public ConcertHall(int totalSeats) {
        this.totalSeats = totalSeats; // Initialize totalSeats
        this.seats = new ConcurrentHashMap<>();
        for (int i = 1; i <= totalSeats; i++) {
            seats.put(i, false); // Initialize all seats as unbooked
        }
    }

    public synchronized boolean bookSeat(int seatNumber) {
        if (!seats.get(seatNumber)) { // Check if the seat is available
            seats.put(seatNumber, true); // Mark the seat as booked
            return true;
        } else {
            return false; // Seat is already booked
        }
    }

    public synchronized void displaySeats() {
        seats.forEach((seatNumber, isBooked) -> {
            System.out.println("Seat " + seatNumber + ": " + (isBooked ? "Booked" : "Available"));
        });
    }

    public int getTotalSeats() { // Add this method to return the total number of seats
        return totalSeats;
    }
}