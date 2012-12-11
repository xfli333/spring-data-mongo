package cn.lee.demo.mongo;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Seven
 * Date: 12-12-11
 * Time: PM5:04
 */
public class BaseControllerTest {
    @Autowired
    private ApplicationContext applicationContext;

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private RequestMappingHandlerAdapter handlerAdapter;

    @Before
    public void setUp() {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        handlerAdapter = applicationContext.getBean(RequestMappingHandlerAdapter.class);
    }

    protected void execute(MockHttpServletRequest request, MockHttpServletResponse response) {
        try {
            Object handler = this.getHandler(request);
            handlerAdapter.handle(request, response, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected Object getHandler(MockHttpServletRequest request) throws Exception {
        HandlerExecutionChain chain = null;

        Map<String, HandlerMapping> map = applicationContext.getBeansOfType(HandlerMapping.class);
        Iterator<HandlerMapping> itt = map.values().iterator();

        while (itt.hasNext()) {
            HandlerMapping mapping = itt.next();
            chain = mapping.getHandler(request);
            if (chain != null) {
                break;
            }
        }

        if (chain == null) {
            throw new InvalidParameterException("Unable to find handler for request URI: " + request.getRequestURI());
        }

        return chain.getHandler();
    }
}
