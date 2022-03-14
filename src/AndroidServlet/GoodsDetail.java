package AndroidServlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class GoodsDetail extends HttpServlet{
    public void init() throws ServletException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html");

    }

    public void destroy(){

    }
}
