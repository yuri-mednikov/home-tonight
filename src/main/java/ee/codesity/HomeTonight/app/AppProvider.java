package ee.codesity.HomeTonight.app;

import com.google.inject.AbstractModule;
import ee.codesity.HomeTonight.bookings.BookingController;
import ee.codesity.HomeTonight.bookings.IBookingController;
import ee.codesity.HomeTonight.rooms.IRoomsController;
import ee.codesity.HomeTonight.rooms.RoomsController;
import ee.codesity.HomeTonight.users.IUsersController;
import ee.codesity.HomeTonight.users.UsersController;
import io.vertx.core.Vertx;

public class AppProvider extends AbstractModule {

    private Vertx vertx;

    public AppProvider(Vertx vertx){
        this.vertx = vertx;
    }

    @Override
    protected void configure() {
        super.configure();
        bind(IBookingController.class).toInstance(new BookingController(vertx));
        bind(IRoomsController.class).toInstance(new RoomsController(vertx));
        bind(IUsersController.class).toInstance(new UsersController(vertx));
    }
}
