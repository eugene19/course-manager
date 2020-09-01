package by.epamtc.courses.servlet;

import by.epamtc.courses.servlet.command.Command;
import by.epamtc.courses.servlet.command.CommandProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 8874862373981647120L;

    private CommandProvider provider = new CommandProvider();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter("command");
        Command command = provider.getCommand(commandName);
        command.execute(req, resp);
    }
}
