package com.sp.fanikiwa;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DiaryServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		RunDiary( req,  resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		RunDiary( req,  resp);
	}
	
	private void RunDiary(HttpServletRequest req, HttpServletResponse resp)
	{
//		DiaryComponent dc = new DiaryComponent();
//		dc.RunDiary(new Date());
	}
}
