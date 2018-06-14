package ciderblog.index;

import ciderblog.util.*;
import spark.*;
import java.util.*;
import static ciderblog.Application.*;

public class IndexController {
    public static Route serveIndexPage = (Request request, Response response) -> {
        return ViewUtil.render(request, new HashMap<>(), Path.Template.INDEX);
    };
}
