package servlet;

import DTO.ClientDTO;
import DTO.RequestDTO;
import management.implementation.OperatorServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static constants.Constant.*;

@WebServlet(name = "RequestServlet", value = "/request")
public class RequestServlet extends HttpServlet {
    private final OperatorServiceImpl operatorService = new OperatorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RequestDTO> requestList = operatorService.findAllRequests();
        req.setAttribute(REQUESTS, requestList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(REQUEST_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter(ACTION);
        List<ClientDTO> clientList = operatorService.findAllClients();
        req.setAttribute(CLIENTS,clientList);
        switch (action) {
            case ADD:
                saveRequest(req, resp);
                break;
            case DELETE:
                deleteRequest(req, resp);
                break;
//            case SEARCH:
//                searchRequest(req, resp);
//                break;
            case UPDATE:
                updateRequest(req, resp);
                break;
            case ADD_REQUEST_TO_CLIENT:
                addRequestToClient(req, resp);
                break;
        }
    }
    private void saveRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String date = req.getParameter(DATE);
        String requestType = req.getParameter(REQUEST_TYPE);
        operatorService.addRequest(date, requestType);
        resp.sendRedirect(REQUEST);
    }
//    private void searchRequest(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter(ID));
//        Request request = operatorService.searchInRequests(id);
//        req.setAttribute(REQUEST, request);
//        req.getRequestDispatcher(SEARCH_JSP).forward(req, resp);
//    }
    private void deleteRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter(ID));
        operatorService.deleteRequest(id);
        resp.sendRedirect(REQUEST);
    }

    private void updateRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter(ID));
        String date = req.getParameter(DATE);
        String requestType = req.getParameter(REQUEST_TYPE);
        operatorService.updateRequest(id, date, requestType);
        resp.sendRedirect(REQUEST);
    }

    private void addRequestToClient(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter(ID));
        String date = req.getParameter(DATE);
        String requestType = req.getParameter(REQUEST_TYPE);
        operatorService.addRequestToClient(id,date,requestType);
        resp.sendRedirect(REQUEST);
    }
}
