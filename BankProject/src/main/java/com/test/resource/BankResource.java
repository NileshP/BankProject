package com.test.resource;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.test.bean.Account;
import com.test.bean.Statement;
import com.test.service.BankService;

@Path("/bank")
public class BankResource {

	BankService bankService = new BankService();

	public BankResource() {

		System.out.println("Bank Resource initiated.... ");

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public void bankmainpage(@Context HttpServletResponse servletResponse)
			throws IOException {

		servletResponse.sendRedirect("../index.html");

	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/statement/{accountNumber}")
	public Statement getStatementForAccount(
			@PathParam("accountNumber") String accountNumber) {

		Statement statement = bankService.getStatement(accountNumber);

		if (statement == null) {

			return new Statement();
		} else {

			return statement;
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/statement/{accountNumber}/{startcount}")
	public Statement getStatementForAccountPag(
			@PathParam("accountNumber") String accountNumber,
			@PathParam("startcount") String startcount) {

		Statement statement = bankService.getStatementPagignated(accountNumber,
				Integer.parseInt(startcount));

		if (statement == null) {

			return new Statement();
		} else {

			return statement;
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/account/details/{accountnumber}")
	public Account getAccountDetails(
			@PathParam("accountnumber") String accountNumber) {

		System.out.println("Bank Resource get account details called.... ");

		Account account = bankService
				.getAccountDeatilsFromAcctNumber(accountNumber);

		if (account == null) {

			return new Account();

		} else {
			return account;
		}

	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String createAccount(@FormParam("accountid") String accountId,
			@FormParam("name") String name, @FormParam("branch") String branch,
			@FormParam("type") String type,
			@Context HttpServletResponse servletResponse) throws IOException {

		System.out.println(accountId + "--------" + name + "------" + branch
				+ "------" + type);

		if (bankService.createNewAccount(accountId, name, branch, type) == null) {

			return "<h2 style='color='red''>Account creation unsuccessful....</h2>";

		} else {

			return "<h2>Account created successfully....</h2>";
		}

	}

	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/account/delete/{accountnumber}")
	public String deleteAccount(@PathParam("accountnumber") String accountNumber) {

		Account account = bankService.deleteAccount(accountNumber);

		if (account == null) {

			return "<h2 style='color:'red''>Account deletion unsuccessful....</h2>";

		} else {

			return "<h2>Account [" + account.getAcctId() + ","
					+ account.getAcctName() + "," + account.getAcctType() + ","
					+ account.getAcctBranch()
					+ "] deleted successfully....</h2>";
		}

	}
}