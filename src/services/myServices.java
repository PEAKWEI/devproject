package services;

import java.util.List;

import com.jfinal.plugin.activerecord.Record;

public interface myServices {
	/*
	 * ���� db��recoder Ĭ�����
	 */
	public List<Record> queryList();
	
	public boolean addUser(Record user);

}
