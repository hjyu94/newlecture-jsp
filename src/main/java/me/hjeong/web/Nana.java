package me.hjeong.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hi")
public class Nana extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
            한글이 깨지는 두 가지 이유
            (1) 서버에서 한글을 지원하지 않는 문자코드로 인코딩한 경우
            (2) 서버에서는 UTF-8 로 인코딩해서 보냈지만 브라우저가 다른 코드로 잘못 해석한 경우
        */
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        int cnt = Integer.parseInt(req.getParameter("cnt"));
        for(int i=0; i<cnt; ++i) {
            out.println((i+1) + ": 안녕 ~~~");
        }
    }

}
