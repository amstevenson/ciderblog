package ciderblog.index;

import ciderblog.util.*;
import spark.*;
import java.util.*;
import static ciderblog.Application.*;

public class IndexController {
    public static Route serveIndexPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("users", userDao.getAllUserNames());
        model.put("cider", ciderDao.getRandomCider());
        return ViewUtil.render(request, model, Path.Template.INDEX);
    };
}
