package com.github.candyacao.web;

import com.github.candyacao.config.Config;
import com.github.candyacao.entity.PostLike;
import com.github.candyacao.entity.UserEntity;
import com.github.candyacao.enums.LikedStatusEnum;
import com.github.candyacao.service.PostLikeService;
import com.github.candyacao.utils.Misc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PostLikeController {
    @Autowired
    private PostLikeService postLikeService;
    @RequestMapping(value = "/addLike", method = {RequestMethod.POST, RequestMethod.GET})
    public String addLike(HttpServletRequest request, String postID){
        String msg = "点赞失败！";
        UserEntity me = (UserEntity)request.getSession().getAttribute(Config.SESSION_LOGINED_KEY);
        if (postID != null && !postID.equals("")){
            PostLike postLike = new PostLike(Misc.UUID(), me.getId(), postID);
            postLike.setStatus(LikedStatusEnum.LIKE.getCode());
            if (postLikeService.saveLike(postLike) > 0){
                msg = "点赞成功！";
            }
        }
        return msg;
    }
    @RequestMapping(value = "/delLike", method = {RequestMethod.POST, RequestMethod.GET})
    public String delLike(HttpServletRequest request, String postID){
        String msg = "取消失败！";
        UserEntity me = (UserEntity)request.getSession().getAttribute(Config.SESSION_LOGINED_KEY);
        if (postID != null && !postID.equals("")){
            PostLike postLike = new PostLike(Misc.UUID(), me.getId(), postID);
            postLike.setStatus(LikedStatusEnum.UNLIKE.getCode());
            if (postLikeService.delLike(postLike) > 0){
                msg = "取消成功！";
            }
        }
        return msg;
    }
}
