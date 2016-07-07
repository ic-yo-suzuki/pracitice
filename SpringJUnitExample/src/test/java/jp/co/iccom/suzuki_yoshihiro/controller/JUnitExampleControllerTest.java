package jp.co.iccom.suzuki_yoshihiro.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jp.co.iccom.suzuki_yoshihiro.Mapper.UserMapper;
import jp.co.iccom.suzuki_yoshihiro.entity.UserEntity;
import jp.co.iccom.suzuki_yoshihiro.service.BatisDbConnectionTestService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-application-config.xml" })
public class JUnitExampleControllerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Autowired
	private JUnitExampleController jUnitExample;
	@Test
	public void ModelAndViewのgetViewNameメソッドで取得したView名を調べる() {
		String actual = jUnitExample.showMessage().getViewName();
		String expected = "showMessage";

		assertThat(actual, is(expected));
	}

	@Test
	public void Serviceクラスのメソッドをコントローラーから呼び出せる(){
		String actual = (String)jUnitExample
				.showMessage()
				.getModel().get("message");
		String expected = "子安由。";

		assertThat(actual, is(expected));
	}

	@Autowired
	private BatisDbConnectionTestService batisDbConnectionTestService;
//	@SuppressWarnings("unused")
//	@Autowired
//	private UserMapper userMapper;

	@Test
	public void Serviceクラスのメソッドを直接呼び出す(){
		int actual = (int)batisDbConnectionTestService.getUser(46).getId();
		int expected = 46;

		assertThat(actual, is(expected));
	}

	@Test
	public void Mockitのテスト(){
		List<UserEntity> stublist = new ArrayList<UserEntity>();
		UserEntity user = new UserEntity();
		user.setBranchId(1);
		user.setDepartmentId(1);
		user.setBranchName("本社");
		user.setDepartmentName("人事総務部");
		user.setElapsedTime(10000000000L);
		user.setElapsedTimeText(user.getElapsedTime());
		user.setId(100);
		try {
			user.setLastLoginDate(new SimpleDateFormat().parse("2016-05-05 00:00:00"));
		} catch (java.text.ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		user.setLoginId("test");
		user.setName("テストユーザー");
		user.setStatus(true);

		stublist.add(user);

		UserMapper mockUserMapper = mock(UserMapper.class);
		when(mockUserMapper.getUser(anyInt())).thenReturn((UserEntity) stublist);

		SqlSession mockSqlSession = mock(SqlSession.class);
		when(mockSqlSession.getMapper(UserMapper.class)).thenReturn(mockUserMapper);

		batisDbConnectionTestService.session = mockSqlSession;

		UserEntity actual = batisDbConnectionTestService.getUser(46);
		assertThat(actual, is(stublist.get(0)));

	}

}
