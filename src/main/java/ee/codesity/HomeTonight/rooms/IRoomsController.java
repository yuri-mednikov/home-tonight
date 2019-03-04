package ee.codesity.HomeTonight.rooms;

import io.vertx.ext.web.RoutingContext;

public interface IRoomsController {

    void showRooms(RoutingContext context);

    void showRoomDetails (RoutingContext context);

    void filterRooms (RoutingContext context);
}
