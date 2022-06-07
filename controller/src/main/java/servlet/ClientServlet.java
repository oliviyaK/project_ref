package servlet;

import DTO.ClientDTO;
import management.implementation.OperatorServiceImpl;
import refrigerator.entity.Client;
import refrigerator.entity.Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static constants.Constant.*;
@WebServlet(name = "ClientServlet", value = "/client")
public class ClientServlet extends HttpServlet {
    public static final String ADD_REQUEST = "addRequest";
    private final OperatorServiceImpl clientService = new OperatorServiceImpl();
    private final OperatorServiceImpl requestService = new OperatorServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Client> clientList = clientService.findAllClients();
        req.setAttribute(CLIENTS, clientList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(CLIENT_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter(ACTION);
        List<Request> requestList = requestService.findAllRequests();
        req.setAttribute(REQUESTS,requestList);
        switch (action) {
            case ADD:
                saveClient(req, resp);
                break;
            case DELETE:
                deleteClient(req, resp);
                break;
            case SEARCH:
                searchClient(req, resp);
                break;
            case UPDATE:
                updateClient(req, resp);
                break;

        }
    }

    private void saveClient(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter(NAME);
        String surname = req.getParameter(SURNAME);
        String address = req.getParameter(ADDRESS);
        String phone = req.getParameter(PHONE);
        String comment = req.getParameter(COMMENT);
        clientService.clientCreation(name, surname, address, phone, comment);
        resp.sendRedirect(CLIENT);
    }

    private void searchClient(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter(ID));
        Request request = clientService.searchInRequests(id);
        req.setAttribute(REQUEST, request);
        req.getRequestDispatcher(SEARCH_JSP).forward(req, resp);
    }

    private void deleteClient(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter(ID));
        clientService.deleteClientsById(id);
        resp.sendRedirect(CLIENT);
    }

    private void updateClient(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter(ID));
        String name = req.getParameter(NAME);
        String surname = req.getParameter(SURNAME);
        String address = req.getParameter(ADDRESS);
        String phone = req.getParameter(PHONE);
        String comment = req.getParameter(COMMENT);
        clientService.updateClient(id, name, surname, address, phone, comment);
        resp.sendRedirect(CLIENT);
    }

}

