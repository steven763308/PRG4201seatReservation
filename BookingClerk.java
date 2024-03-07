/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seatreservation;

import java.util.Random;

/**
 *
 * @author user
 */
public class BookingClerk extends Thread {
    private ConcertHall concertHall;

    public BookingClerk(ConcertHall concertHall) {
        this.concertHall = concertHall;
    }

    @Override
    public void run() {
        while (true) {
            
            try{
                Thread.sleep(1500); //sleep time for 1.5 sec
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            
            int seatNumber = (int) (Math.random() * concertHall.getTotalSeats()) + 1; // Random seat number

            if (concertHall.bookSeat(seatNumber)) {
                System.out.println("Clerk " + Thread.currentThread().getId() + " booked seat " + seatNumber + " successfully.");
                concertHall.displaySeats();
                break;
            } else {
                System.out.println("Clerk " + Thread.currentThread().getId() + " failed to book seat " + seatNumber + " (already booked).");
            }
        }
    }
}
