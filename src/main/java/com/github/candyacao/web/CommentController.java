package com.github.candyacao.web;

import com.github.candyacao.config.Config;
import com.github.candyacao.entity.CommentEntity;
import com.github.candyacao.entity.UserEntity;
import com.github.candyacao.service.CommentService;
import com.github.candyacao.utils.Misc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/postComment", method = {RequestMethod.POST, RequestMethod.GET})
    public String addComment(HttpServletRequest request, String postID, CommentEntity comment){
        String msg = "评论发表失败！";
        UserEntity me = (UserEntity)request.getSession().getAttribute(Config.SESSION_LOGINED_KEY);
        if (postID != null && !postID.equals("")){
            comment.setId(Misc.UUID());
            comment.setPostID(postID);
            comment.setCreateDate(new Date());
            comment.setUser(me);
            if (commentService.insert(comment) > 0){
                msg = "评论发表成功！";
            }
        }
        return msg;
    }
}
