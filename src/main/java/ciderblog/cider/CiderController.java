package ciderblog.cider;

import ciderblog.login.*;
import ciderblog.util.*;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;

import static ciderblog.Application.ciderDao;
import static ciderblog.util.JsonUtil.dataToJson;
import static ciderblog.util.RequestUtil.*;

public class CiderController {

    public static Route fetchAllCiders = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);
        if (clientAcceptsHtml(request)) {
            HashMap<String, Object> model = new HashMap<>();
            model.put("ciders", ciderDao.getAllCiders());
            return ViewUtil.render(request, model, Path.Template.CIDERS_ALL);
        }
        if (clientAcceptsJson(request)) {
            return dataToJson(ciderDao.getAllCiders());
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };

    public static Route fetchOneCider = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);
        if (clientAcceptsHtml(request)) {
            HashMap<String, Object> model = new HashMap<>();
            Cider cider = ciderDao.getCiderByName(getParamName(request));
            model.put("cider", cider);
            return ViewUtil.render(request, model, Path.Template.CIDERS_ONE);
        }
        if (clientAcceptsJson(request)) {
            return dataToJson(ciderDao.getCiderByName(getParamName(request)));
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };
}
