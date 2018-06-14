package app.index;

import app.util.*;
import spark.*;
import java.util.*;
import static app.Application.*;

public class IndexController {
    public static Route serveIndexPage = (Request request, Response response) -> {
        return ViewUtil.render(request, "hello", Path.Template.INDEX);
    };
}
