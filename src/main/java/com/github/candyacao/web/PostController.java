package com.github.candyacao.web;

import com.github.candyacao.config.Config;
import com.github.candyacao.entity.PostEntity;
import com.github.candyacao.entity.TagEntity;
import com.github.candyacao.entity.UserEntity;
import com.github.candyacao.service.PostService;
import com.github.candyacao.service.TagService;
import com.github.candyacao.utils.Misc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private TagService tagService;

    /**
     * 发表post
     * @param request
     * @param post
     * @param tagNames
     * @return
     */
    @RequestMapping(value = "/publish", method = {RequestMethod.POST, RequestMethod.GET})
    public String publish(HttpServletRequest request, PostEntity post, String[] tagNames) {
        String mes = "发布失败！";
        UserEntity me = (UserEntity) request.getSession().getAttribute(Config.SESSION_LOGINED_KEY);
        String uuid = Misc.UUID();
        post.setId(uuid);
        post.setAuthorID(me.getId());
        post.setCreateDate(new Date());
        for (int i = 0; i < tagNames.length ; i++) {
            TagEntity tag = tagService.selectByName(tagNames[i]);
            if (tag != null){
                tagService.linkToPost(tag.getId(), uuid);
            }else {
                String uuid1 = Misc.UUID();
                tagService.insert(new TagEntity(uuid1, tagNames[i]));
                tagService.linkToPost(uuid1,uuid);
            }
        }
        if (postService.publish(post) > 0) {
            mes = post.getId();
        }
        return mes;
    }

    /**
     * 获取当前用户的所有posts
     * @param request
     * @return
     */
    @Cacheable(value="post-key")
    @RequestMapping(value="/post", method = {RequestMethod.POST, RequestMethod.GET})
    public List<PostEntity> getPosts(HttpServletRequest request){
        UserEntity me = (UserEntity) request.getSession().getAttribute(Config.SESSION_LOGINED_KEY);
        return postService.getPosts(me.getId());
    }

    /**
     * 根据postID获得post
     * @param id
     * @return
     */
    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public PostEntity post(@PathVariable String id) {
        return postService.select(id);
    }

}
