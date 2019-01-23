import java.io.*;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        writeHtmlTo(response, "/Users/nickmargal/IdeaProjects/ServletPractice/web/view/login-page.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object data = "Lod In";
        Object title = "Welcome";

        request.setAttribute("data", data);
        request.setAttribute("title", title);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(System.getProperty("user.dir"));
        var url = "/result.jsp";

        Object data;
        Object title;

        if (isSuccessfulLoginWith(getUsernameFrom(request), getPAsswordFrom(request))) {
            data = "<h1 style=\"color:green\">LOGGED IN!</h1>";
            title = "Logged in";
        } else {
            data = "<h1 style=\"color:red\">INVALID LOGIN OR PASSWORD</h1>";
            title = "Error";
        }

        request.setAttribute("title", title);
        request.setAttribute("data", data);

        request.getRequestDispatcher(url).forward(request, response);

    }

    private boolean isSuccessfulLoginWith(String login, String password) {
        return login.equals("admin") && password.equals("admin");
    }


    private String getHtmlNamed(String filepath) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader htmlReader = new BufferedReader(new FileReader(new File(filepath)))) {
            htmlReader.lines().forEach(builder::append);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    private void writeHtmlTo(HttpServletResponse response, String filepath) {
        try (BufferedReader htmlReader = new BufferedReader(new FileReader(new File(filepath)));
             PrintWriter out = response.getWriter()) {
            htmlReader.lines().forEach(out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getUsernameFrom(HttpServletRequest request) {
        return request.getParameter("login");
    }

    private String getPAsswordFrom(HttpServletRequest request) {
        return request.getParameter("password");
    }

}

