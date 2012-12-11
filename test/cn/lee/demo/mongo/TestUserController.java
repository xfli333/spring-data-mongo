package cn.lee.demo.mongo;

import cn.lee.demo.mongo.controller.UserController;
import cn.lee.demo.mongo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Seven
 * Date: 12-12-11
 * Time: PM4:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestUserController {

    @Resource
    private UserController userController;

    @Resource
    private RequestMappingHandlerAdapter handlerAdapter;

    @Resource
    private RequestMappingHandlerMapping handlerMapping;

    @Test
    public void saveTest() {

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.setRequestURI("http://localhost:9080/mongo/user/test.frm?id=1");
        request.setMethod(RequestMethod.GET.name());
        try {
            HandlerExecutionChain chain = handlerMapping.getHandler(request);
            handlerAdapter.handle(request, response,
                    chain.getHandler());
//
//            Object handler = handlerMapping.getHandler(request).getHandler();
//            handlerAdapter.handle(request, response, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
