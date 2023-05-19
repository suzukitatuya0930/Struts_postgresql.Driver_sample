package org.apache.struts.helloworld.model;

public class UserModel {
	
	 private String name;

	    public UserModel(String name) {
	        this.name = name;
	    }

	    // getterとsetterを定義する
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

}
