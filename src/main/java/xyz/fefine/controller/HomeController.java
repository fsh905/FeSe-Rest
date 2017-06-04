package xyz.fefine.controller;

import bid.fese.entity.SeResponse;
import xyz.fefine.annotation.Path;

/**
 * Created by feng_sh on 17-6-4.
 * 测试用
 */
public class HomeController {
    @Path("/index")
    public void index(SeResponse response) {
        response.getPrintWriter().write("this is index - 2");
        response.getPrintWriter().flush();
        response.flush();
    }
}
