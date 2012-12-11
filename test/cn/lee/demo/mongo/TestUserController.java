package cn.lee.demo.mongo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: Seven
 * Date: 12-12-11
 * Time: PM4:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestUserController extends BaseControllerTest {

    private Executor executor = Executors.newFixedThreadPool(10);
    private String id;

    @Test
    public void saveTest() {
        for (int i = 0; i < 10; i++) {
            id = i + "";
            executor.execute(new Runnable() {
                @Override
                public int hashCode() {
                    return super.hashCode();
                }

                @Override
                public void run() {
                    test(id + "");
                }
            });
        }
    }

    private void test(String id) {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.setRequestURI("/user/test.frm");
        request.addParameter("id", id);
        request.setMethod(RequestMethod.GET.name());
        this.execute(request, response);
    }


}
