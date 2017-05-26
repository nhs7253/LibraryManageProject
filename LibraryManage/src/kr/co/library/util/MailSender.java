package kr.co.library.util;
import java.util.Date;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class MailSender {
	private static MailSender instance = new MailSender();
	
	private Properties p;
	private MimeMessage msg;
	
	private MailSender(){
		p = System.getProperties();
        p.put("mail.smtp.starttls.enable", "true");     // gmail은 무조건 true 고정
        p.put("mail.smtp.host", "smtp.gmail.com");      // smtp 서버 주소
        p.put("mail.smtp.auth","true");                 // gmail은 무조건 true 고정
        p.put("mail.smtp.port", "587");  				// gmail 포트
        msg = new MimeMessage(Session.getDefaultInstance(p, new MyAuthentication()));
	}
	
	public static MailSender getInstance(){
		return instance;
	}
	
    public void sendMail(String recipientEmail, String content) {
                  System.out.println("MailSender" + "!!!!!!!!!!!!!!!");
        try{
            //편지보낸시간
            msg.setSentDate(new Date());
             
            InternetAddress from = new InternetAddress() ;
            from = new InternetAddress("ste38274<ste38274@gmail.com>");
            // 이메일 발신자
            msg.setFrom(from);
            // 이메일 수신자
            InternetAddress to = new InternetAddress(recipientEmail); //ex) temp@naver.com
            msg.setRecipient(Message.RecipientType.TO, to);
            // 이메일 제목
            msg.setSubject("예약하신 도서 대기 안내", "UTF-8");
            // 이메일 내용
            msg.setText("예약하신 도서 ("+content+")가 도서관에 반납되었습니다.", "UTF-8");
            // 이메일 헤더
            msg.setHeader("content-Type", "text/html");
            //메일보내기
            javax.mail.Transport.send(msg);
             
        }catch (AddressException addr_e) {
            addr_e.printStackTrace();
        }catch (MessagingException msg_e) {
            msg_e.printStackTrace();
        }
    }
 
}
 
 
class MyAuthentication extends Authenticator {
    PasswordAuthentication pa;
    public MyAuthentication(){
        String id = "ste38274@gmail.com";       // 구글 ID
        String pw = "ste38274!";          // 구글 비밀번호
 
        // ID와 비밀번호를 입력한다.
        pa = new PasswordAuthentication(id, pw);    
    }
    // 시스템에서 사용하는 인증정보
    public PasswordAuthentication getPasswordAuthentication() {
        return pa;
    }
}

