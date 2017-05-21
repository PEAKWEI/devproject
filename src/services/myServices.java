package services;

import java.util.List;

import com.jfinal.plugin.activerecord.Record;

public interface myServices {
	/*
	 * 利用 db加recoder 默认设计
	 */
	public List<Record> queryList();
	
	public boolean addUser(Record user);

}
