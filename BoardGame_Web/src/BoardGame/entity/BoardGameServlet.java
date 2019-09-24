package BoardGame.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;





//githubtest
@WebServlet("/BoardGameServlet")
public class BoardGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String CONTENT_TYPE = "text/html; charset=UTF-8";
	UserDao userDao=null;
	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		Gson gson = new Gson();
		BufferedReader br = request.getReader();
		StringBuilder jsonIn = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null) {
			jsonIn.append(line);
		}

		JsonObject jsonObject = gson.fromJson(jsonIn.toString(), JsonObject.class);
		if (userDao == null) {
			userDao = new UserDaoMySqlImpl();
		}

		String action = jsonObject.get("action").getAsString();
	        if (action.equals("notificationInsert")) {
			String notificationJson = jsonObject.get("notification").getAsString();
			System.out.println("notificationJson = " + notificationJson);
			Notification notification = gson.fromJson(notificationJson, Notification.class);
			int count = 0;
			if (action.equals("notificationInsert")) {
				count = userDao.insert(notification);
			} 
			writeText(response, String.valueOf(count));
		} 
		    if (action.equals("findByUserName")) {
			String userJson = jsonObject.get("user").getAsString();
			User user = gson.fromJson(userJson, User.class);
			User user1 = userDao.findByUserName(user.getUserName());
			if (user1 != null & user1.getPassword().equals(user.getPassword())) {
				writeText(response, gson.toJson(user1));
			}
			} 
		}
	private void writeText(HttpServletResponse response, String outText) throws IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.print(outText);
		System.out.println("output: " + outText);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (userDao == null) {
			userDao = new UserDaoMySqlImpl();
		}
	}

}
