package pe.edu.cibertec.gch.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.dao.FactoryDAO;
import pe.edu.cibertec.gch.dao.ProfesorDao;
import pe.edu.cibertec.gch.modelo.Profesor;

/**
 * Servlet para registrar un profesor.
 */
@WebServlet(name = "RegistroProfesorServlet", urlPatterns = {"/registrarProfesor"})
public class RegistroProfesorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContadorUsuario contador = ContadorUsuario.instancia();
        contador.sumar();
        System.out.println("********* Conteo ="+contador.getContador());
                
        req.setCharacterEncoding("UTF-8");

        String codigo = req.getParameter("codigo"),
                nombres = req.getParameter("nombres"),
                apellidoPaterno = req.getParameter("apellidoPaterno"),
                apellidoMaterno = req.getParameter("apellidoMaterno"),
                direccion = req.getParameter("direccion"),
                referencia = req.getParameter("referencia"),
                telefono1 = req.getParameter("telefono1"),
                telefono2 = req.getParameter("telefono2"),
                telefono3 = req.getParameter("telefono3"),
                email1 = req.getParameter("email1"),
                email2 = req.getParameter("email2"),
                email3 = req.getParameter("email3"),
                fechaNacimiento = req.getParameter("fechaNacimiento"),
                sexo = req.getParameter("sexo"),
                estadoCivil = req.getParameter("estadoCivil");

        // se validan los parametros recibidos
        if (sonDatosValidos(codigo, nombres, apellidoPaterno, apellidoMaterno, direccion, referencia, telefono1, telefono2, telefono3, email1, email2, email3, fechaNacimiento, sexo, estadoCivil)) {
            
            //ProfesorDao profesorDao = new ProfesorDaoImpl();
            ProfesorDao profesorDao = FactoryDAO.getDaoProfesor();
            
            // si es conforme, se registra en la fuente de datos
            profesorDao.registrar(new Profesor(codigo, nombres, apellidoPaterno, apellidoMaterno, direccion, referencia, telefono1, telefono2, telefono3, email1, email2, email3, fechaNacimiento, sexo, estadoCivil));
            resp.sendRedirect("listarProfesores");
        } else {
            // si hay algunos campos invalidos, se retorna
            req.setAttribute("mensaje", "Hay errores en los datos enviados");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/profesor/registro.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    private boolean sonDatosValidos(String codigo, String nombres, String apellidoPaterno, String apellidoMaterno, String direccion, String referencia, String telefono1, String telefono2, String telefono3, String email1, String email2, String email3, String fechaNacimiento, String sexo, String estadoCivil) {
        boolean esValido = true;
        // TODO solo se valida que no sean vacios, sin embargo la logica de 
        // validacion deberia incluir otros aspectos
        if (codigo == null || codigo.isEmpty()) {
            esValido = false;
        } else if (nombres == null || nombres.isEmpty()) {
            esValido = false;
        } else if (apellidoPaterno == null || apellidoPaterno.isEmpty()) {
            esValido = false;
        } else if (direccion == null || direccion.isEmpty()) {
            esValido = false;
        } else if (email1 == null || email1.isEmpty()) {
            esValido = false;
        }
        return esValido;
    }
}
