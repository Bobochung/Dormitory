package org.zb.dormitory.keys;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class Keys {

	public static final String ADMIN_KEY = "admin";
	public static final String TEACHERLIST_KEY = "teacherlist";
	public static final String STUDENTLIST_KEY = "studentlist";
	public static final String BUILDINGLIST_KEY = "buildingList";
	public static final String DORMITORYLIST_KEY = "dormitorylist";
	public static final String CURRENTPAGE = "currerntPage";
	public static final String NEXT = "next";
	public static final String PRE = "pre";
	public static final String LAST = "last";
	public static final String TEACHER_NUMBER = "teacherNumber";
	public static final String STUDENT_NUMBER = "studentNumber";
	public static final String DORMITORY_NUMBER = "dormitoryNumber";
	public static final String BUILDING_NUMBER = "buildingNumber";
	public static final String BUILDING_ITEM = "buildingitem";
	public static final String STUDENT_ITEM = "studentitem";
	public static final String TEACHER_ITEM = "teacheritem";
	public static final Map<String, HttpSession> onlineSession = new HashMap<>();
	

}
