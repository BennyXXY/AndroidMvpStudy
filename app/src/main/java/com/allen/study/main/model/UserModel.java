package com.allen.study.main.model;

/**
 * 用户信息模型
 * Created by ChenRan on 2016-2-25.
 */
public class UserModel implements IUser {

	private String name;
	private int age;

	public UserModel(String name,int age){
		this.name = name;
		this.age = age;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getAge() {
		return age;
	}
}
