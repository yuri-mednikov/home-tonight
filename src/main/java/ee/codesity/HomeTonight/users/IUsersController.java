package ee.codesity.HomeTonight.users;

import io.vertx.ext.web.RoutingContext;

public interface IUsersController {

    void showProfile (RoutingContext context);
}
