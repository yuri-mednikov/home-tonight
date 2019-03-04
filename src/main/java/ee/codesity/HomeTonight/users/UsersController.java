package ee.codesity.HomeTonight.users;

import io.vertx.core.Vertx;
import io.vertx.ext.web.RoutingContext;

public class UsersController implements IUsersController {

    public UsersController(Vertx vertx){
        System.out.println("Users controller");
    }

    @Override
    public void showProfile(RoutingContext context) {
        context.response().setStatusCode(200).end("This is my profile");
    }
}
