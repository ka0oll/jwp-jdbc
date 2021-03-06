package core.mvc;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;

public class JsonView implements View {

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("utf-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(createBody(model));
    }

    private String createBody(Map<String, ?> model) {
        if (model.isEmpty()) {
            return StringUtils.EMPTY;
        }

        Object target = model;
        if (model.size() == 1) {
            target = model.values().iterator().next();
        }
        return JsonUtils.toJson(target);
    }
}
