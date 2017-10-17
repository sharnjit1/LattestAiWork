
package e;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
class Mailer{

    public static void send(String from,String password,String to,String sub, String msg) {
        Properties props= new Properties();
        props.put("mail.smtp.host","smtp.gmail.com");
                props.put("mail.smtp.socketFactory.port","465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.port","465");

        //get session
        Session session=Session.getDefaultInstance(props,
                new javax.mail.Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(from,password);
                }});
        //comose mesage
        try{
            MimeMessage message =new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);
            //send message
            Transport.send(message);
            System.out.println("message sent successfully");
        }catch(MessagingException e){throw new RuntimeException(e);}
        
        
    }
     
} 
    
    
public class gmail {
    public static void main(String[] args) {
        //from,password,to,subject,mesage
        Mailer.send("arshdeep0509@gmail.com","arshdeep12a","s.aashima1997@gmail.com","have a great day","how r u?");
     //change from,password and to   
    }
    
}
