package com.linketinder.Controller

import com.fasterxml.jackson.databind.ObjectMapper
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import static com.linketinder.Services.ServiceVagas.*

@WebServlet("/vagas")
class ControllerVagas extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter response = resp.getWriter()
        response.println(listarTodas())
        response.flush()
        resp.setStatus(200)
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        InputStream inputStream = req.getInputStream()
        ObjectMapper mapper = new ObjectMapper()
        Map<String, Object> jsonMap = mapper.readValue(inputStream, Map.class)

        cadastrarVaga(jsonMap)

        resp.setStatus(201)
    }
}
