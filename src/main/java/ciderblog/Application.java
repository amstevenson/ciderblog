package ciderblog;

import ciderblog.cider.CiderController;
import ciderblog.cider.CiderDao;
import ciderblog.index.IndexController;
import ciderblog.login.LoginController;
import ciderblog.user.UserDao;
import ciderblog.util.Filters;
import ciderblog.util.Path;
import ciderblog.util.ViewUtil;

import static spark.Spark.*;
import static spark.debug.DebugScreen.*;

public class Application {

    // Declare dependencies
    public static CiderDao ciderDao;
    public static UserDao userDao;

    public static void main(String[] args) {

        // Instantiate your dependencies
        ciderDao = new CiderDao();
        userDao = new UserDao();

        // Configure Spark
        port(5000);
        staticFiles.location("/public");
        staticFiles.expireTime(600L);
        enableDebugScreen();

        // Set up before-filters (called before each get/post)
        before("*",                  Filters.addTrailingSlashes);
        before("*",                  Filters.handleLocaleChange);

        // Set up routes
        get(Path.Web.INDEX,          IndexController.serveIndexPage);
        get(Path.Web.CIDERS,          CiderController.fetchAllCiders);
        get(Path.Web.ONE_CIDER,       CiderController.fetchOneCider);
        get(Path.Web.LOGIN,          LoginController.serveLoginPage);
        post(Path.Web.LOGIN,         LoginController.handleLoginPost);
        post(Path.Web.LOGOUT,        LoginController.handleLogoutPost);
        get("*",                     ViewUtil.notFound);

        //Set up after-filters (called after each get/post)
        after("*",                   Filters.addGzipHeader);

    }

}
