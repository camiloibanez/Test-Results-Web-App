package com.capgemini.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.training.connection.ConnectionManager;
import com.capgemini.training.model.Client;
import com.capgemini.training.model.CovidTest;
import com.capgemini.training.model.LabTechnician;
import com.capgemini.training.service.ClientService;
import com.capgemini.training.service.ClientServiceImpl;
import com.capgemini.training.service.CovidTestService;
import com.capgemini.training.service.CovidTestServiceImpl;
import com.capgemini.training.service.LabTechnicianService;
import com.capgemini.training.service.LabTechnicianServiceImpl;

@WebServlet("/")
public class CovidTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ClientService clientService;
	private CovidTestService covidTestService;
	private LabTechnicianService labTechService;
	
	private boolean isEmployee;
	HttpSession session;
	
	public void init(ServletConfig config) throws ServletException {
		clientService = new ClientServiceImpl();
		covidTestService = new CovidTestServiceImpl();
		labTechService = new LabTechnicianServiceImpl();
	}
	
	public void destroy() {
		
		try {
			ConnectionManager.getConnection().close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		PrintWriter out = response.getWriter();
		
		String loggedOutRedirect = alertMessage("You are not logged in", "index.jsp");
		
		switch(action) {
			case "/admin_login":
				toAdminLogin(request, response);
				break;
			case "/client_login":
				toClientLogin(request, response);
				break;
			case "/client_signin":
				signInClient(request, response);
				break;
			case "/admin_signin":
				signInAdmin(request, response);
				break;
			case "/updateClientForm":
				try {
					if((boolean) session.getAttribute("isLoggedIn")) {
						updateClientForm(request, response);						
					}
				} catch (Exception e) {
					out.print(loggedOutRedirect);
				}
				break;
			case "/updateEmployeeForm":
				try {
					if((boolean) session.getAttribute("isLoggedIn")) {
						updateEmployeeForm(request, response);						
					}
				} catch (Exception e) {
					out.print(loggedOutRedirect);
				}
				break;

			case "/updateClient":
				try {
					if((boolean) session.getAttribute("isLoggedIn")) {
						updateClient(request, response);						
					}
				} catch (Exception e) {
					out.print(loggedOutRedirect);
				}
				break;
			case "/updateEmployee":
				try {
					if((boolean) session.getAttribute("isLoggedIn")) {
						updateEmployee(request, response);						
					}
				} catch (Exception e) {
					out.print(loggedOutRedirect);
				}
				break;
			case "/newClientAccount":
				createClientAccountForm(request, response);
				break;
			case "/newEmployeeAccount":
				createEmployeeAccountForm(request, response);
				break;
			case "/createClientAccount":
				createClientAccount(request, response);
				break;
			case "/createEmployeeAccount":
				createEmployeeAccount(request, response);
				break;
			case "/new_test":
				try {
					if((boolean) session.getAttribute("isLoggedIn")) {
						newTest(request, response);
					}
				} catch (Exception e) {
					out.print(loggedOutRedirect);
				}
				break;
			case "/check":
				try {
					if((boolean) session.getAttribute("isLoggedIn")) {
						check(request, response);
					}
				} catch (Exception e) {
					out.print(loggedOutRedirect);
				}
				break;
			case "/pending_tests":
				try {
					if((boolean) session.getAttribute("isLoggedIn")) {
						listPendingTests(request, response);
					}
				} catch (Exception e) {
					out.print(loggedOutRedirect);
				}
				break;
			case "/test_history":
				try {
					if((boolean) session.getAttribute("isLoggedIn")) {
						listCompletedTests(request, response);
					}
				} catch (Exception e) {
					out.print(loggedOutRedirect);
				}
			case "/editTest":
				try {
					if((boolean) session.getAttribute("isLoggedIn")) {
						editTestForm(request, response);
					}
				} catch (Exception e) {
					out.print(loggedOutRedirect);
				}
				break;
			case "/updateTest":
				try {
					if((boolean) session.getAttribute("isLoggedIn")) {
						editTest(request, response);
					}
				} catch (Exception e) {
					out.print(loggedOutRedirect);
				}
				break;
			case "/review_tests":
				try {
					if((boolean) session.getAttribute("isLoggedIn")) {
						reviewTests(request, response);
					}
				} catch (Exception e) {
					out.print(loggedOutRedirect);
				}
				break;
			case "/logout":
				logOut(request, response);
				break;
			default:
				break;
		}
		
	}
	
	private void toAdminLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		forwardDispatcher(request, response, "admin_login.jsp");		
	}
	
	private void toClientLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		forwardDispatcher(request, response, "/");		
	}
	
	private void signInClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username").trim();
		String pwd = request.getParameter("password").trim();
		isEmployee = false;
		
		PrintWriter out = response.getWriter();
		
		String incorrectCredentials = alertMessage("Incorrect username and password", "index.jsp");
		
		Client user = clientService.getClientByCredentials(username, pwd);
		
		if (user != null) {
			session = request.getSession();
			
			int clientId = user.getClientId();
			String email = user.getEmail();
			String firstName = user.getFirstName();
			String lastName = user.getLastName();
			
			session.setAttribute("clientId", clientId);
			session.setAttribute("email", email);
			session.setAttribute("username", username);
			session.setAttribute("firstName", firstName);
			session.setAttribute("lastName", lastName);
			session.setAttribute("isEmployee", false);
			session.setAttribute("isLoggedIn", true);
			
			forwardDispatcher(request, response, "new_test.jsp");
		} else {
			out.println(incorrectCredentials);
		}
	}
	
	private void signInAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username").trim();
		String pwd = request.getParameter("password").trim();
		isEmployee = true;
		
		PrintWriter out = response.getWriter();
		
		String incorrectCredentials = alertMessage("Incorrect username and password", "admin_login.jsp");
		
		LabTechnician user = labTechService.getLabTechnicianByCredentials(username, pwd);
		
		if (user != null) {
			session = request.getSession();
			
			int employeeId = user.getEmployeeId();
			String email = user.getEmail();
			
			session.setAttribute("employeeId", employeeId);
			session.setAttribute("email", email);
			session.setAttribute("username", username);
			session.setAttribute("isEmployee", true);
			session.setAttribute("isLoggedIn", true);
			
			forwardDispatcher(request, response, "pending_tests.jsp");
		} else {
			out.println(incorrectCredentials);
		}
	}
	
	public void updateClientForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			
			if((boolean) session.getAttribute("isLoggedIn")) {
				int id = (int) session.getAttribute("clientId");
				Client client = clientService.getCliendById(id);
				System.out.println(client);
				request.setAttribute("user", client);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		forwardDispatcher(request, response, "client_account_info.jsp");
		
	}
	
	public void updateEmployeeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			if((boolean) session.getAttribute("isLoggedIn")) {
				int id = (int) session.getAttribute("employeeId");
				LabTechnician labTech = labTechService.getLabTechnicianById(id);
				System.out.println(labTech);
				request.setAttribute("user", labTech);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		forwardDispatcher(request, response, "emp_account_info.jsp");
		
	}
	
	public void updateClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int clientId = (int) session.getAttribute("clientId");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipCode = request.getParameter("zipcode");
		String insuranceNo = request.getParameter("insuranceNo");
		String phone = request.getParameter("phone");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String cardNo = request.getParameter("cardNo");
		int expMonth = Integer.parseInt(request.getParameter("expMonth"));
		int expYear = Integer.parseInt(request.getParameter("expYear"));
		int securityCode = Integer.parseInt(request.getParameter("securityCode"));
			
		Client client = new Client(email, username, password, clientId, addressLine1,
				addressLine2, city, state, zipCode, insuranceNo, phone,
				firstName, lastName, cardNo, expMonth, expYear, securityCode);
		
		clientService.updateClient(client);
		
		forwardDispatcher(request, response, "client_account_info.jsp");
		
	}
	
	public void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeId = (int) session.getAttribute("employeeId");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");

		LabTechnician labTech = new LabTechnician(email, username, password, employeeId);
		labTechService.updateLabTechnician(labTech);
		
		forwardDispatcher(request, response, "emp_account_info.jsp");
		
	}
	
	public void createClientAccountForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		forwardDispatcher(request, response, "client_account.jsp");
		
	}	
	
	public void createEmployeeAccountForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		forwardDispatcher(request, response, "emp_account.jsp");
		
	}	
	
	public void createClientAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipCode = request.getParameter("zipcode");
		String insuranceNo = request.getParameter("insuranceNo");
		String phone = request.getParameter("phone");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String cardNo = request.getParameter("cardNo");
		int expMonth = Integer.parseInt(request.getParameter("expMonth"));
		int expYear = Integer.parseInt(request.getParameter("expYear"));
		int securityCode = Integer.parseInt(request.getParameter("securityCode"));
			
		Client client = new Client(email, username, password, 0, addressLine1,
				addressLine2, city, state, zipCode, insuranceNo, phone,
				firstName, lastName, cardNo, expMonth, expYear, securityCode);
		clientService.addClient(client);
		
		response.sendRedirect("new_test");
		
	}
	
	public void createEmployeeAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");

		LabTechnician labTech = new LabTechnician(email, username, password, 0);
		labTechService.addLabTechnician(labTech);
		
		response.sendRedirect("pending_tests");
		
	}	
	
	private void newTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		forwardDispatcher(request, response, "new_test.jsp");
	
	}
	
	private void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int clientId = (int) session.getAttribute("clientId");
		
		PrintWriter out = response.getWriter();
		
		if (covidTestService.addCovidTest(clientId)) {
			System.out.println("test added");
			String testAdded = alertMessage("Your new test has been submitted", "review_tests.jsp");

			out.println(testAdded);
		} else {
			System.out.println("test not added");
			String testNotAdded = alertMessage("An error has occurred. Please try submitting your test again.", "new_test.jsp");
			
			out.println(testNotAdded);
		}
		
		
	}
	
	private void listPendingTests(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CovidTest> pendingTests = covidTestService.getAllPendingCovidTests();
		
		request.setAttribute("pendingTests", pendingTests);
		
		forwardDispatcher(request, response, "pending_tests.jsp");
	}
	
	private void listCompletedTests(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CovidTest> completedTests = covidTestService.getCompletedCovidTests();
		
		request.setAttribute("completedTests", completedTests);
		
		forwardDispatcher(request, response, "view_test_history.jsp");
	}
	
	private void editTestForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("testId"));
		
		CovidTest covidTest = covidTestService.getCovidTestById(id);
		
		request.setAttribute("test", covidTest);
		
		forwardDispatcher(request, response, "edit_test.jsp");
	}
	
	private void editTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("testId"));
		String result = request.getParameter("result");
		
		CovidTest covidTest = covidTestService.getCovidTestById(id);
		
		covidTest.setResult(result);
		
		covidTestService.updateCovidTest(covidTest);
		
		response.sendRedirect("test_history");
	}
	
	private void reviewTests(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int clientId = (int) session.getAttribute("clientId");
		
	List<CovidTest> pendingTests = covidTestService.getPendingCovidTestsByClientId(clientId);
	List<CovidTest> completedTests = covidTestService.getCompletedCovidTestsByClientId(clientId);
	
	request.setAttribute("pendingTests", pendingTests);
	request.setAttribute("completedTests", completedTests);
	
	forwardDispatcher(request, response, "review_tests.jsp");
	
	}
	private void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		isEmployee = (boolean) session.getAttribute("isEmployee");

		session.invalidate();

		if(!isEmployee) {
			response.sendRedirect("/CovidTestResults/");	
		} else {
			response.sendRedirect("admin_login");
		}
	}
	
	private String alertMessage(String message, String redirect) {
		String result = "<script type\"text/javascript\">" +
				"alert('" + message + "');" +
				"location='" + redirect + "';" +
				"</script>";
		return result;
	}
	
	private void forwardDispatcher(HttpServletRequest request, HttpServletResponse response, String jsp) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
