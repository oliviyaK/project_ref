package servlet;

import DTO.OperatorDTO;
import management.implementation.AdminServiceImpl;
import refrigerator.dao.EntityDaoImplAdmin;
import refrigerator.entity.Operator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static constants.Constant.*;

@WebServlet(name = "AdminServlet", value = "/admin")
public class AdminServlet extends HttpServlet {
    private AdminServiceImpl adminService = new AdminServiceImpl(new EntityDaoImplAdmin());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<OperatorDTO> operatorList = adminService.operatorDTOList();
        req.setAttribute(OPERATOR_LIST, operatorList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(ADMIN_JSP);
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Operator> operatorList = adminService.operatorList();
        req.setAttribute(OPERATOR_LIST, operatorList);
        String action = req.getParameter(ACTION);
        switch (action){
            case "createOperator":
              createOperator(req,resp);
              break;
//            case "updateOperator":
//                updateOperator(req,resp);
//                break;
//            case "deleteOperator":
//                deleteOperator(req,resp);
//                break;
        }
    }

    private void createOperator (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name=req.getParameter(NAME);
       String client=req.getParameter(CLIENT);
       String request=req.getParameter(REQUEST);
        String operation=req.getParameter(OPERATION);

    }
}
