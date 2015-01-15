package pl.lodz.p.project.core.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lodz.p.project.core.dao.account.UserDao;
import pl.lodz.p.project.core.domain.account.PasswordChangeRequest;
import pl.lodz.p.project.core.domain.account.User;
import pl.lodz.p.project.core.dto.account.PasswordChangeRequestDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.base.AbstractService;
import pl.lodz.p.project.core.util.MailSender;

import javax.annotation.security.PermitAll;
import javax.interceptor.Interceptors;

/**
 *
 * @author Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class PasswordChangeRequestServiceImpl extends AbstractService<PasswordChangeRequest, PasswordChangeRequestDTO> implements PasswordChangeRequestService {

	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private UserDao userDao;
	
	@PermitAll
	@Override
	public void sendPasswordChangeRequest(String passwordResetURL, String email) {
		User user = userDao.findByEmail(email);
		mailSender.sendPasswordChangeRequestMail(passwordResetURL, user);
	}

	@PermitAll
	@Override
	public PasswordChangeRequestDTO getOneById(Long id) {
		return super.getOneById(id);
	}

	@PermitAll
	@Override
	public void delete(Long id) {
		super.delete(id);       
	}
	
}
