package services.impl;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import services.myServices;

public class myServicesImpl implements myServices {

	public List<Record> queryList() {
	List<Record> list = Db.find("select * from user where id >?",1);
	return list;
	}

	public boolean addUser(Record user) {
		Db.save("user", user);
		return false;
	}

}
