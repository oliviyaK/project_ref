package servlet;

import DTO.RefrigeratorDTO;
import management.implementation.OperatorServiceImpl;
import refrigerator.entity.Detail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static constants.Constant.*;

@WebServlet(name = "PartServlet", value = "/part")
public class PartServlet extends HttpServlet {

    private final OperatorServiceImpl partService = new OperatorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Detail> detailListList = partService.findAllDetails();
        req.setAttribute(PARTS, detailListList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PART_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter(ACTION);
        List<RefrigeratorDTO> refrigeratorList = partService.findAllRefrigerators();
        req.setAttribute(REFRIGERATORS, refrigeratorList);
        switch (action) {
            case ADD:
                savePart(req, resp);
                break;
            case DELETE:
                deletePart(req, resp);
                break;
            case UPDATE:
                updatePart(req, resp);
                break;
            case ADD_PART_TO_REFRIGERATOR:
                addPartToRefrigerator(req, resp);
                break;
        }
    }

    private void savePart(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String name = req.getParameter(NAME);
        String price = req.getParameter(PRICE);
        partService.addDetail(name, price);
        resp.sendRedirect(PART);
    }

    private void deletePart(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int id = Integer.parseInt(req.getParameter(ID));
        partService.deleteDetail(id);
        resp.sendRedirect(PART);
    }

    private void updatePart(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int id = Integer.parseInt(req.getParameter(ID));
        String name = req.getParameter(NAME);
        String price = req.getParameter(PRICE);
        partService.updateDetail(id, name, price);
        resp.sendRedirect(PART);
    }

    private void addPartToRefrigerator(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int id = Integer.parseInt(req.getParameter(ID));
        String name = req.getParameter(NAME);
        String price = req.getParameter(PRICE);
        partService.addPartToRefrigerator(id, name, price);
        resp.sendRedirect(REFRIGERATOR);
    }
}


