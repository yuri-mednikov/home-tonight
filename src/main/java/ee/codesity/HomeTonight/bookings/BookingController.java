package ee.codesity.HomeTonight.bookings;

import io.vertx.core.Vertx;
import io.vertx.ext.web.RoutingContext;

public class BookingController implements IBookingController {

    public BookingController(Vertx vertx){
        System.out.println("Bookings controller");
    }

    @Override
    public void showBookings(RoutingContext context) {
        context.response().setStatusCode(200).end("Bookings list");
    }
}
