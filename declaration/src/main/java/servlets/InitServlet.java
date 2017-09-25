package servlets;

import dal.DataBase;
import instances.Company;
import instances.Declaration;
import instances.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//@WebServlet("/")
public class InitServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Declaration> listOfDecl = new ArrayList<Declaration>();

        try {
            Connection dbConn = new DataBase().getConnection();
            String sqlQuery = "SELECT c.name, d.date, s.name " +
                    "FROM declarations d " +
                    "INNER JOIN companies c ON c.id = d.comp_id " +
                    "INNER JOIN statuses s ON s.id = d.stat_id";

            Statement statement = dbConn.createStatement();
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                Declaration currDecl = new Declaration();
                currDecl.setCompany(new Company(rs.getString("c.name")));
                currDecl.setDate(Date.valueOf("d.date"));
                currDecl.setStatus(new Status(rs.getString("s.name")));
                listOfDecl.add(currDecl);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("list", listOfDecl);


        req.getRequestDispatcher("index.jsp").forward(req, resp);


    }

}
