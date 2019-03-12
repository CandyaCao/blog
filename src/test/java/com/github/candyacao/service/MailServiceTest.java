package com.github.candyacao.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {
    @Autowired
    private MailService mailService;

    @Test
    public void testSimpleMail() throws Exception {
        mailService.sendSimpleMail("exfly@outlook.com","你好啊，张海飞","哈哈哈哈哈哈，我做完了定时和发邮件的任务了，不过现在是分别实现了，不知道该怎么整合呢");
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("564650950@qq.com","test simple mail",content);
    }
    @Test
    public void sendAttachmentsMail() {
        String filePath="D:\\简历\\1.jpg";
        mailService.sendAttachmentsMail("564650950@qq.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }
    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "D:\\简历\\1.jpg";

        mailService.sendInlineResourceMail("564650950@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }
}
