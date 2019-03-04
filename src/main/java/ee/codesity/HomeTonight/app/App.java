package ee.codesity.HomeTonight.app;


import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import ee.codesity.HomeTonight.bookings.IBookingController;
import ee.codesity.HomeTonight.rooms.IRoomsController;
import ee.codesity.HomeTonight.users.IUsersController;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

public class App extends AbstractVerticle {

    @Inject
    private IBookingController bookingController;

    @Inject
    private IRoomsController roomsController;

    @Inject
    private IUsersController usersController;

    private int port;

    public App(AbstractModule provider){
        this.port = (System.getenv("PORT")!=null)? Integer.valueOf(System.getenv("PORT")) : 8080;
        Guice.createInjector(provider).injectMembers(this);
    }

    @Override
    public void start() throws Exception {
        super.start();
        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);

        router.route("/assets/*").handler(StaticHandler.create().setCachingEnabled(false));

        router.get("/").produces("text/html").handler(roomsController::showRooms);
        router.get("/api/rooms").produces("application/json").handler(roomsController::filterRooms);
        router.get("/room/:id").produces("text/html").handler(roomsController::showRoomDetails);
        router.get("/bookings").produces("text/html").handler(bookingController::showBookings);
        router.get("/profile").produces("text/html").handler(usersController::showProfile);

        server.requestHandler(router).listen(port, res->{
            if (res.succeeded()){
                System.out.printf("Application created on port: %d", port);

            } else {
                System.out.println(res.cause().getLocalizedMessage());
            }
        });
    }

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        AppProvider appProvider = new AppProvider(vertx);
        vertx.deployVerticle(new App(appProvider));
    }
}



