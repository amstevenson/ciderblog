package ciderblog;

import ciderblog.index.IndexController;
import ciderblog.util.Filters;
import ciderblog.util.Path;

import static spark.Spark.*;
import static spark.debug.DebugScreen.*;

public class Application {

    public static void main(String[] args) {

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

    }

}
