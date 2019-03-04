package ee.codesity.HomeTonight.rooms;

import io.vertx.core.Vertx;
import io.vertx.ext.web.RoutingContext;

public class RoomsController implements IRoomsController {

    public RoomsController(Vertx vertx){
        System.out.println("Rooms controller");
    }

    @Override
    public void showRooms(RoutingContext context) {
        context.response().setStatusCode(200).end("Rooms list");
    }

    @Override
    public void showRoomDetails(RoutingContext context) {
        context.response().setStatusCode(200).end("One room with id "+context.pathParam("id"));
    }

    @Override
    public void filterRooms(RoutingContext context) {

    }
}
