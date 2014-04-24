package pe.edu.cibertec.gch.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import pe.edu.cibertec.gch.dao.ProfesorDaoImpl;
import pe.edu.cibertec.gch.modelo.Profesor;

public class RegistroProfesorServletTest {
    private RegistroProfesorServlet registroProfesorServlet;
    private HttpServletResponse httpServletResponseMock;
    private HttpServletRequest httpServletRequestMock;
    private RequestDispatcher requestDispatcherMock;

    @Before
    public void setUp() {
        registroProfesorServlet = new RegistroProfesorServlet();
        httpServletRequestMock = mock(HttpServletRequest.class);
        httpServletResponseMock = mock(HttpServletResponse.class);
        requestDispatcherMock = mock(RequestDispatcher.class);
    }

    @Test
    public void sinCodigo() throws Exception {
        when(httpServletRequestMock.getParameter("codigo")).thenReturn("cod");
        when(httpServletRequestMock.getParameter("nombres")).thenReturn(""); //<----- VACIO!!! se prueba
        when(httpServletRequestMock.getParameter("apellidoPaterno")).thenReturn("Perez");
        when(httpServletRequestMock.getParameter("direccion")).thenReturn("Aramburu 1000");
        when(httpServletRequestMock.getParameter("email1")).thenReturn("juanperez@gmail.com");
        when(httpServletRequestMock.getRequestDispatcher("view/profesor/registro.jsp")).thenReturn(requestDispatcherMock);

        registroProfesorServlet.doPost(httpServletRequestMock, httpServletResponseMock);

        verify(requestDispatcherMock).forward(httpServletRequestMock, httpServletResponseMock);
    }

    @Test
    public void cuandoInvocamosDoPost() throws Exception {
        when(httpServletRequestMock.getParameter("codigo")).thenReturn("cod");
        when(httpServletRequestMock.getParameter("nombres")).thenReturn("Juan");
        when(httpServletRequestMock.getParameter("apellidoPaterno")).thenReturn("Perez");
        when(httpServletRequestMock.getParameter("direccion")).thenReturn("Aramburu 1000");
        when(httpServletRequestMock.getParameter("email1")).thenReturn("juanperez@gmail.com");

        registroProfesorServlet.doPost(httpServletRequestMock, httpServletResponseMock);

        verify(httpServletResponseMock).sendRedirect("listarProfesores");
    }
    
    @Test
    public void invocarRegistar() throws Exception {
        ProfesorDaoImpl profesorDAO = new ProfesorDaoImpl();
        
        Profesor profesorMock = mock(Profesor.class);
        
        profesorDAO.registrar(profesorMock);
    }
}
