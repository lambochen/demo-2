package club.chenlinghong.demo.email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Resource
    MailService mailService;

    @Resource
    TemplateEngine templateEngine;

    @Test
    public void mailService() {

        mailService.mailService();

    }

    @Test
    public void sendSimpleMail(){
        mailService.sendSimpleMail("chenlinghong@126.com","Simple Mail","测试发送简单文本邮件");
    }

    @Test
    public void sendHtmlMail() {
        String content = "</html>\n"+
                "<body>\n"+
                    "<h3> 测试发送ＨＴＭＬ邮件！</h3>\n"+
                "</body>\n"+
                "</html>";
        mailService.sendHtmlMail("chenlinghong@126.com","HTML Mail",content);
    }

    @Test
    public void sendAttachmentsMail() throws MessagingException {
        String filePath = "/home/chenlinghong/project/email/test.txt";
        mailService.sendAttachmentsMail("chenlinghong@126.com","Attachments Mail","测试发送带附件的邮件",filePath);
    }

    @Test
    public void sendInlineResourceMailTest() throws MessagingException {
        String imgPath = "123.jpg";
        String rscId = "image001";
        String content = "<html><body> 这是有图片的邮件:<img src=\'cid:"+rscId+"\'></img></body></html>";
        mailService.sendInlineResourceMail("chenlinghong@126.com","Image Html",content,imgPath,rscId);
    }

    @Test
    public void testTemplateMailTest() throws MessagingException {
        Context context = new Context();
        context.setVariable("id","001");

        String emailContent = templateEngine.process("emailTemplate",context);
        mailService.sendHtmlMail("chenlinghong@126.com","这是一个模板邮件",emailContent);

    }
}