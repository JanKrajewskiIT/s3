package pl.lodz.p.project.core.util;

import java.util.Date;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.dao.account.PasswordChangeRequestDao;
import pl.lodz.p.project.core.dao.account.PendingInvitationDao;
import pl.lodz.p.project.core.domain.account.PasswordChangeRequest;
import pl.lodz.p.project.core.domain.account.PendingInvitation;
import pl.lodz.p.project.core.domain.account.Role;
import pl.lodz.p.project.core.domain.account.User;
import pl.lodz.p.project.core.exception.UniqueConstraintViolationException;

/**
 * Bean responsible for sending mail.
 *
 * @author Łukasz Gadomski
 */
@Component
// TODO @LocalBean
public class MailSender {

	@Autowired
	private PendingInvitationDao pendingInvitationDao;

	@Autowired
	private PasswordChangeRequestDao passwordChangeRequestDao;

	/**
	 * Creates a pending invitation in the DB and sends an invitation mail to
	 * the given e-mail address. Invokes
	 * {@link PendingInvitationFacadeLocal#create(pl.lodz.p.was04.department.core.domain.accountmanagment.headoffice.entity.PendingInvitation)
     * }
	 * .
	 *
	 * @author Łukasz Gadomski
	 * @param registrationURL
	 *            the URL of registration page
	 * @param email
	 *            the e-mail address of the recipient
	 * @param role
	 *            the role that the new user is going to receive
	 */
	public void sendInvitationMail(String registrationURL, String email,
			Role role) {
		try {
			PendingInvitation oldPendingIvInvitation = pendingInvitationDao
					.findByEmail(email);
			if (oldPendingIvInvitation != null) {
				pendingInvitationDao.delete(oldPendingIvInvitation);
			}

			String token = DigestUtils.sha256Hex(email
					+ UUID.randomUUID().toString());
			PendingInvitation pendingInvitation = new PendingInvitation();
			pendingInvitation.setEmail(email);
			pendingInvitation.setRole(role);
			pendingInvitation.setToken(token);
			pendingInvitation.setCreationDate(new Date());
			pendingInvitationDao.save(pendingInvitation);
			Properties properties = new Properties();
			final String username = "was04headoffice@gmail.com";
			final String password = "headoffice04was";
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");
			Session session;
			session = Session.getInstance(properties,
					new javax.mail.Authenticator() {
						@Override
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username,
									password);
						}
					});
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("was04headoffice@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			message.setSubject("Zaproszenie do rejestracji");
			message.setText("\nAdministrator systemu was04headoffice pragnie dodać Cię do systemu. Oto Twój link do rejestracji w systemie:\n"
					+ registrationURL + "?token=" + token + " \n");
			Transport.send(message);
		} catch (MessagingException | UniqueConstraintViolationException ex) {
			Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

	public void sendPasswordChangeRequestMail(String passwordResetURL, User user) {
		try {
			PasswordChangeRequest oldPasswordChangeRequest = passwordChangeRequestDao
					.findByUser(user);
			if (oldPasswordChangeRequest != null) {
				passwordChangeRequestDao.delete(oldPasswordChangeRequest);
			}
			String email = user.getEmail();
			PasswordChangeRequest passwordChangeRequest = new PasswordChangeRequest();
			//TODO passwordChangeRequest.setId(DigestUtils.sha256Hex(user.getEmail() + UUID.randomUUID().toString()));
			passwordChangeRequest.setCreationDate(new Date());
			passwordChangeRequest.setUser(user);
			passwordChangeRequestDao.save(passwordChangeRequest);
			Properties properties = new Properties();
			final String username = "was04headoffice@gmail.com";
			final String password = "headoffice04was";
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");
			Session session;
			session = Session.getInstance(properties,
					new javax.mail.Authenticator() {
						@Override
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username,
									password);
						}
					});
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("was04headoffice@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			message.setSubject("Resetowanie hasła");
			message.setText("\nTa wiadomość została wysłana, ponieważ ktoś chce zresetować hasło do Twojego konta w Systemie Sprzedaży Sieciowej.\nJeśli ta wiadomość jest niepożądana, proszę ją zignorować. W przeciwnym wypadku, link pozwalający na zresetowanie hasła widnieje poniżej:\n"
					+ passwordResetURL
					+ "?id="
					+ passwordChangeRequest.getId()
					+ " \n");
			Transport.send(message);
		} catch (MessagingException | UniqueConstraintViolationException ex) {
			Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}
}
