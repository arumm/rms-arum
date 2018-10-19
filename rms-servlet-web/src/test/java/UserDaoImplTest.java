import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.mitrais.rms.dao.DataSourceFactory;
import com.mitrais.rms.dao.UserDao;
import com.mitrais.rms.dao.impl.UserDaoImpl;
import com.mitrais.rms.model.User;

public class UserDaoImplTest {
	private static UserDao userDao;

	@BeforeClass
	public static void initEmp() {
		userDao = new UserDaoImpl();
	}

	@Before
	public void connectionTest() throws SQLException {
		DataSourceFactory.getConnection();
		System.out.println("Connection...");
	}

	@After
	public void findAllTest() {
		List<User> userList = userDao.findAll();
		userList.forEach(user -> {
			System.out.println(user.getUserName());
		});
	}

	@Ignore
	@Test
	public void saveTest() {
		User user = new User();
		user.setUserName("arumxccx");
		user.setPassword("12345");
		boolean res = userDao.save(user);
		assertTrue(res);
	}

	@Ignore
	@Test
	public void updateTest() {
		User user = new User();
		user.setId(new Long(6));
		user.setUserName("ArumM");
		user.setPassword("12345");
		boolean res = userDao.update(user);
		assertTrue(res);
	}

	@Test
	public void findByUserNameTest() {
		Optional<User> userOpt = userDao.findByUserName("Arum");
		User user = userOpt.get();
		assertEquals("Arum", user.getUserName());
	}

	@Ignore
	@Test
	public void deleteTest() {
		User user = new User();
		user.setId(new Long(7));
		boolean res = userDao.delete(user);
		assertTrue(res);
	}

}