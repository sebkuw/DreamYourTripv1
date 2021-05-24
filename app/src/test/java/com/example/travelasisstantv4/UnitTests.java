package com.example.travelasisstantv4;

import com.example.travelasisstantv4.trip.Trip;
import com.example.travelasisstantv4.trip.TripStop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UnitTests {
    private Trip trip, trip2;
    private TripStop tripStop, tripStop2, tripStop3, tripStop4;

    @Before
    public void setUp() {
        trip = new Trip();
        tripStop = new TripStop();

        trip2 = new Trip();
        tripStop2 = new TripStop();
        tripStop3 = new TripStop();
        tripStop4 = new TripStop();
        tripStop2.setCost(1);
        tripStop3.setCost(2);
        tripStop4.setCost(3);
        trip2.addTripStop(tripStop2);
        trip2.addTripStop(tripStop3);
        trip2.addTripStop(tripStop4);

        System.out.println("Ready for testing");
    }

    @After
    public void tearDown() {
        System.out.println("Done with testing");
    }

    @Test
    public void testCostSum() {
        tripStop.setCost(100);
        trip.addTripStop(tripStop);
        assertEquals("Trip cost should equals like trip stop cos", tripStop.getCost(), trip.getCostSum(), 0.0);
    }

    @Test
    public void testTripStopOrder() {
        assertTrue("Last trip stop order should be equals tripStops size",
                trip2.getTripStops().size() == trip2.getTripStops().get(trip2.getTripStops().size() - 1).getOrder());
    }

    @Test
    public void testDeleteTripStopOrder() {
        trip2.deleteTripStop(tripStop2);
        assertTrue(trip2.getTripStops().get(0).getOrder() == 0);
    }

    @Test
    public void testTripCostDeleteTripStop() {
        trip2.deleteTripStop(tripStop2);
        assertTrue(trip2.getCostSum() == tripStop3.getCost() + tripStop4.getCost());
    }
}