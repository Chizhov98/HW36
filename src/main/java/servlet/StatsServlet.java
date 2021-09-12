package servlet;

import com.google.gson.Gson;
import entity.SessionInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class StatsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionInfo.countIncrement();
        PrintWriter responseBody = resp.getWriter();
        int requestCount = SessionInfo.getCounter();
        resp.setContentType("application/json");
        String body = new Gson().toJson(requestCount);
        responseBody.println(body);
        resp.setStatus(200);
    }
}
