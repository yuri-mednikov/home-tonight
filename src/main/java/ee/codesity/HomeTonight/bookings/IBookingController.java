package ee.codesity.HomeTonight.bookings;

import io.vertx.ext.web.RoutingContext;

public interface IBookingController {

    void showBookings(RoutingContext context);

}
