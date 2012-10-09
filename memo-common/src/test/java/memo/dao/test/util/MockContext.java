package memo.dao.test.util;

import java.util.Date;
import java.util.List;

import mojo.dao.AuditContext;
import mojo.dao.model.user.User;
import mojo.dao.model.user.UserGroup;

public class MockContext implements AuditContext {

	private User user;
	private List<UserGroup> userGroups;

	public MockContext() {
		initUser();
	}

	protected void initUser() {
		user = new User();
		user.setFullname("Jesse Blue");
		user.setNickname("Broken Heart");
		user.setEmail("jblue@cavalrycommand.com");
		user.setPassword("J+A=LFE");
		user.setSignUpTime(new Date());

		userGroups = user.getGroups();

		initGroup("Star Sheriffs");
		initGroup("Outriders");
	}

	protected void initGroup(String name) {
		UserGroup group = new UserGroup();
		group.setName(name);
		group.getUsers().add(user);
		user.getGroups().add(group);
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public List<UserGroup> getUserGroups() {
		return userGroups;
	}

	@Override
	public String getRemoteUser() {
		return "foo";
	}

	@Override
	public String getRemoteHost() {
		return "bar";
	}

	@Override
	public boolean isUserInRole(String role) {
		return false;
	}
}
