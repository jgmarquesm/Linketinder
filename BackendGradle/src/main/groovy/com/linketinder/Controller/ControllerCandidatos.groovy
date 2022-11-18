package com.linketinder.Controller

import com.fasterxml.jackson.databind.ObjectMapper
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import static com.linketinder.Services.ServiceCandidatos.cadastrarCandidato
import static com.linketinder.Services.ServiceCandidatos.listarTodos

@WebServlet("/candidatos")
class ControllerCandidatos extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter response = resp.getWriter()
        response.println(listarTodos())
        response.flush()
        resp.setStatus(200)
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        InputStream inputStream = req.getInputStream()
        ObjectMapper mapper = new ObjectMapper()
        Map<String, Object> jsonMap = mapper.readValue(inputStream, Map.class)

        cadastrarCandidato(jsonMap)

        resp.setStatus(201)
    }
}
