package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Péter on 2016. 03. 16..
 */
@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {
    final static String host = "127.0.0.1";
    final static int port = 6666;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String sCriteria = request.getParameter("sCriteria");
        String sValue = request.getParameter("sValue");

        try {
            if(sValue.isEmpty()){
                out.print("<font color='red'>Empty search value field, please fill it!</font>");
            }
            else {
                response.setContentType("text/html;charset=UTF-8");
                HttpSession session = request.getSession();
                session.setAttribute("sValue", sValue);
                session.setAttribute("sCriteria",sCriteria);
                try {
                    Socket clientSocket = new Socket(host, port);
                    System.out.println("[CLIENT][INFO] - Connected to the server.\n");
                    ObjectOutputStream toServer = new ObjectOutputStream(clientSocket.getOutputStream());
                    ObjectInputStream fromServer = new ObjectInputStream(clientSocket.getInputStream());
                    send(toServer, sValue);
                    out.print("Searching to<font color='blue'> " + sValue + " </font>from CSV file like<font color='blue'> " + sCriteria + "</font><br>");
                    if (fromServer != null){
                        out.print(fromServer);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        } finally {
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public static void send(ObjectOutputStream x, Object object) throws IOException {
        x.write(0);
        x.writeObject(object);
    }
}
