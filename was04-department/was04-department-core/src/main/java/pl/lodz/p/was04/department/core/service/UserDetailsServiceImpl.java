package pl.lodz.p.was04.department.core.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pl.lodz.p.was04.department.core.dao.account.UserDao;
import pl.lodz.p.was04.department.core.domain.account.User;

/**
 * 
 * @author Milczu
 *
 */
@Named
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Inject
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		LOGGER.debug("loadUserByUsername: {}", login);
		User user = userDao.findByEmail(login);
		if (user == null) {
			LOGGER.warn("User not found: {}", login);
			throw new UsernameNotFoundException("Username " + login + " not exists");
		}

		return user;
	}

}
