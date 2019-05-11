package com.example.demo.sendmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class MailService {
    @Autowired
    JavaMailSender javaMailSender;

    /**
     *
     * @param from
     * @param to
     * @param cc
     * @param subject
     * @param content
     * 简单发邮件
     */
    public void sendSimpleMail(String from,String to,String cc,String subject,String content){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setCc(cc);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);

        javaMailSender.send(simpleMailMessage);
    }

    /**
     *
     * @param from
     * @param to
     * @param subject
     * @param content
     * @param file
     * 带附件的邮件
     */
    public void sendAttachFileMail(String from,String to,String subject,String content,File file){

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            helper.addAttachment(file.getName(),file);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendMailWithImg(String from,String to,String subject,String content,String[] srcPath,String[] resIds){
        if(srcPath.length != resIds.length){
            System.out.println("发送失败");
            return;
        }

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);

            for(int i=0; i < srcPath.length; i++){
                FileSystemResource res = new FileSystemResource(new File(srcPath[i]));
                helper.addInline(resIds[i],res);
            }
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("发送失败");
        }
    }
}
