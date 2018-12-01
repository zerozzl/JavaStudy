package com.zerozzl.study.common.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.zerozzl.study.common.dao.UserDao;
import com.zerozzl.study.common.model.UserDO;
import com.zerozzl.study.lang.db.JdbcUtils;

@Component("userDao")
public class UserDaoImpl implements UserDao {

	@Override
	public List<UserDO> selectAll() {
		String sql = "select * from user";
		List<UserDO> users = new ArrayList<UserDO>();
		try {
			JdbcUtils.init();
			ResultSet res = JdbcUtils.execSelect(sql, null);
			while (res.next()) {
				users.add(new UserDO(res.getInt(1), res.getString(2), res.getInt(3)));
			}
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

}
