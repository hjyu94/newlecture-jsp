package me.hjeong.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        /*
            멀티 바이트 문자 전송 문제: 사용자로부터 값 입력 받아서 전송하기
            톰캣의 기본 방식은 사용자가 입력한 값을 ISO-8859-1 방식으로 디코딩함.
            사용자가 입력한 값을 UTF-8 로 받아볼 것임을 설정해줘야 한다.
         */
        req.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        String title = req.getParameter("title");
        String content = req.getParameter("content");
        out.println("title: " + title);
        out.println("content: " + content);
    }

}
