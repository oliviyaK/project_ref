package servlet;

import DTO.RefrigeratorDTO;
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

@WebServlet(name = "RefrigeratorServlet", value = "/refrigerator")
public class RefrigeratorServlet extends HttpServlet {
    private final OperatorServiceImpl refrigeratorService = new OperatorServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RefrigeratorDTO> refrigeratorList = refrigeratorService.findAllRefrigerators();
        req.setAttribute(REFRIGERATORS, refrigeratorList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(REFRIGERATOR_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter(ACTION);
        List<RequestDTO> requestList = refrigeratorService.findAllRequests();
        req.setAttribute(REQUESTS,requestList);
        switch (action) {
            case ADD:
                saveRefrigerator(req, resp);
                break;
            case DELETE:
                deleteRefrigerator(req, resp);
                break;
            case UPDATE:
                updateRefrigerator(req, resp);
                break;
            case ADD_REFRIGERATORS_TO_REQUEST:
                addRefrigeratorsToRequest(req, resp);
                break;
        }
    }
    private void saveRefrigerator(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String brand = req.getParameter(BRAND);
        String model = req.getParameter(MODEL);
        String comment = req.getParameter(COMMENT);
        refrigeratorService.addRefrigerator(brand, model, comment);
        resp.sendRedirect(REFRIGERATOR);
    }
    private void deleteRefrigerator(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int id = Integer.parseInt(req.getParameter(ID));
        refrigeratorService.deleteRefrigerator(id);
        resp.sendRedirect(REFRIGERATOR);
    }

    private void updateRefrigerator(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int id = Integer.parseInt(req.getParameter(ID));
        String brand = req.getParameter(BRAND);
        String model = req.getParameter(MODEL);
        String comment = req.getParameter(COMMENT);
        refrigeratorService.updateRefrigerator(id, brand, model, comment);
        resp.sendRedirect(REFRIGERATOR);
    }

    private void addRefrigeratorsToRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter(ID));
        String brand = req.getParameter(BRAND);
        String model = req.getParameter(MODEL);
        String comment = req.getParameter(COMMENT);
        refrigeratorService.addRefrigeratorsToRequest(id, brand, model, comment);
        resp.sendRedirect(REQUEST);
    }
    }

