package servlet;

import com.google.gson.Gson;
import entity.SessionInfo;
import entity.Visit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class VisitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionInfo.countIncrement();
        PrintWriter responseBody = resp.getWriter();
        List<Visit> list = SessionInfo.getVisitsList();
        resp.setContentType("application/json");
        String body = new Gson().toJson(list);
        responseBody.println(body);
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionInfo.countIncrement();
        String name = req.getParameter("name");
        String city = req.getParameter("city");
        SessionInfo.addNewVisit(new Visit(name, LocalDateTime.now().toString(), city));
    }
}
