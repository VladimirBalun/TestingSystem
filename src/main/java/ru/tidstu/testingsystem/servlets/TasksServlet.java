package ru.tidstu.testingsystem.servlets;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.tidstu.testingsystem.data.entity.Question;
import ru.tidstu.testingsystem.utils.Olympiad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j
@WebServlet("/TasksServlet/*")
public class TasksServlet extends HttpServlet{

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/root-context.xml");
    private Olympiad olympiad = (Olympiad) appContext.getBean("olympiad");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        int numQuestion = Integer.parseInt(req.getParameter("num_question"));
        Question selectedQuestion = olympiad.getQuestion(numQuestion);
        String json = new Gson().toJson(selectedQuestion);
        resp.getWriter().write(json);
    }

}