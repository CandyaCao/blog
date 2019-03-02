package com.github.candyacao.web;

import com.github.candyacao.config.Config;
import com.github.candyacao.entity.PostEntity;
import com.github.candyacao.entity.UserEntity;
import com.github.candyacao.mapper.PostMapper;
import com.github.candyacao.service.PostService;
import com.github.candyacao.utils.Misc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class PostController {
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/publish", method = {RequestMethod.POST, RequestMethod.GET})
    public String publish(HttpServletRequest request, PostEntity post) {
        String mes = "发布失败！";
        UserEntity me = (UserEntity) request.getSession().getAttribute(Config.SESSION_LOGINED_KEY);
        post.setId(Misc.UUID());
        post.setAuthorID(me.getId());
        post.setCreateDate(new Date());
        if (postService.publish(post) > 0) {
            mes = post.getId();
        }
        return mes;
    }

}
