/*
 * Copyright (C) 2012 Dimitrios Menounos
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
package memo.web.portal.server;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PortalController {

	@RequestMapping(value = "/home")
	public ModelAndView doHome(HttpServletRequest request) {
		return new ModelAndView("/home");
	}

	@RequestMapping(value = "/testWait")
	public ModelAndView doTestWait(HttpServletRequest request, @RequestParam int timeout) {
		synchronized (this) {
			try {
				wait(timeout);
			}
			catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		return new ModelAndView("/testWait");
	}

	@RequestMapping(value = "/testLogin.pro")
	public ModelAndView doTestLogin(HttpServletRequest request) {
		return new ModelAndView("/testLogin.pro");
	}
}
