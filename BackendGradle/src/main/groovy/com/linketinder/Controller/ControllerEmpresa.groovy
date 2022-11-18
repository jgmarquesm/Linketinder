package com.linketinder.Controller

import com.fasterxml.jackson.databind.ObjectMapper
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import static com.linketinder.Services.ServiceEmpresas.cadastrarEmpresa

@WebServlet("/empresas")
class ControllerEmpresa extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int statusCode = 403
        String msgResp = "Acesso Negado"
        resp.setStatus(statusCode)
        PrintWriter response = resp.getWriter()
        response.println("$statusCode - $msgResp")
        response.flush()
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        InputStream inputStream = req.getInputStream()
        ObjectMapper mapper = new ObjectMapper()
        Map<String, Object> jsonMap = mapper.readValue(inputStream, Map.class)

        cadastrarEmpresa(jsonMap)

        resp.setStatus(201)
    }
}
