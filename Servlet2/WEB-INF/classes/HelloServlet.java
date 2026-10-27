import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (age > 18) {
            out.println("<h2>Hello" + name);
            out.println("You are eligible for voting");
            out.println("</h2>");

        } else {
            out.println("<h2>Hello" + name);
            out.println("You are not eligible for voting");
            out.println("</h2>");
        }

        out.close();
    }

}
