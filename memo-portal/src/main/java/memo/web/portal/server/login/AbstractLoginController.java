/*
 * Copyright (C) 2010 Dimitrios Menounos
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package memo.web.portal.server.login;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mojo.dao.model.user.User;
import mojo.dao.model.user.User.Gender;
import mojo.dao.service.login.LoginService;
import mojo.web.WebContext;
import mojo.web.WebException;

public class AbstractLoginController {

	@Autowired
	@Qualifier("loginService")
	private LoginService loginService;

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	/**
	 * Handles user logout.
	 */
	@RequestMapping(value = "/exit")
	public ModelAndView doExit(HttpSession session) {
		session.invalidate();
		return new ModelAndView("redirect:/");
	}

	/**
	 * Handles login (internally).
	 */
	protected void signIn(HttpSession session, User user) {
		session.setAttribute(WebContext.CONTEXT_USER_ATTR, user);
		// getLoginService().update(entity); // last sign-in
	}

	protected User extractUser(HttpServletRequest request) {
		String password = str(request.getParameter("password"));
		String nickname = str(request.getParameter("nickname"));
		String fullname = str(request.getParameter("fullname"));
		String email = str(request.getParameter("email"));
		String gender = str(request.getParameter("gender"));
		String birthday = str(request.getParameter("birthday"));
		String country = str(request.getParameter("country"));
		String language = str(request.getParameter("language"));
		String postcode = str(request.getParameter("postcode"));
		String timezone = str(request.getParameter("timezone"));

		if (password == null) {
			throw new WebException("login.register.error.password.empty");
		}

		if (nickname == null) {
			throw new WebException("login.register.error.nickname.empty");
		}

		if (email == null) {
			throw new WebException("login.register.error.email.empty");
		}

		User user = new User();
		user.setPassword(password);
		user.setNickname(nickname);
		user.setFullname(fullname);
		user.setEmail(email);

		if (gender != null) {
			user.setGender(Gender.valueOf(gender));
		}

		if (birthday != null) {
			try {
				DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				user.setBirthday(format.parse(birthday));
			}
			catch (ParseException e) {
				throw new RuntimeException(e);
			}
		}

		if (country != null) {
			user.setCountry(loginService.findCountryByCode(country));
		}

		if (language != null) {
			user.setLanguage(loginService.findLanguageByCode(language));
		}

		user.setPostcode(postcode);
		user.setTimezone(timezone);
		return user;
	}

	/**
	 * Filters out empty strings.
	 */
	protected String str(String str) {
		if (str != null) {
			str = str.trim();

			if (!str.isEmpty()) {
				return str;
			}
		}

		return null;
	}
}
