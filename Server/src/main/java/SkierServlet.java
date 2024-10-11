import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/skiers/*")

public class SkierServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain");
        String urlPath = req.getPathInfo();

        // 检查URL是否存在
        if (urlPath == null || urlPath.isEmpty()) {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            res.getWriter().write("Missing parameters");
            return;
        }

        // 分割 URL 路径
        String[] urlParts = urlPath.split("/");

        // 验证 URL 是否有效
        if (!isUrlValid(urlParts)) {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            res.getWriter().write("Invalid URL");
        } else {
            res.setStatus(HttpServletResponse.SC_OK);
            res.getWriter().write("It works! GET request handled successfully.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 处理POST请求，假设你在POST请求的body中发送JSON数据
        res.setContentType("application/json");
        res.setStatus(HttpServletResponse.SC_CREATED);
        res.getWriter().write("{ \"status\": \"Lift ride recorded successfully.\" }");
    }

    // 验证 URL 的方法
    private boolean isUrlValid(String[] urlPath) {
        // 根据实验要求，可以在这里实现URL的具体验证规则
        // 例如，/skiers/{resortID}/seasons/{seasonID}/days/{dayID}/skiers/{skierID}
        if (urlPath.length == 8) {
            // 检查是否符合期望的路径结构
            // [ , resortID, seasons, seasonID, days, dayID, skiers, skierID ]
            try {
                Integer.parseInt(urlPath[1]); // resortID
                Integer.parseInt(urlPath[3]); // seasonID
                Integer.parseInt(urlPath[5]); // dayID
                Integer.parseInt(urlPath[7]); // skierID
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }
}
