package org.lzh.framework.common.web.freemarker;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Description:通过继承freemarker视图解析类org.springframework.web.servlet.view.freemarker.FreeMarkerView
 * 重写exposeHelpers方法，在spring里配置自己的freemarker的视图解析器，在模板中就可以通过${basePath}获取。
 * @author: lizhaohua
 * @date: 15/12/14 下午1:20
 * @version: V1.0
 */
public class MyFreeMarkerView extends FreeMarkerView {
    private static final String CONTEXT_PATH = "bathPath";
    @Override
    protected void exposeHelpers(Map<String, Object> model,
                                 HttpServletRequest request) throws Exception {
        model.put(CONTEXT_PATH, request.getContextPath());
        super.exposeHelpers(model, request);
    }

}