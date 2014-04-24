package pe.edu.cibertec.gch.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.cibertec.gch.modelo.Profesor;
import pe.edu.cibertec.gch.utils.MyAnnotation;

public class ProfesorDaoImpl implements ProfesorDao {

    @Override
    public void registrar(Profesor profesor) {
        //super.guardar(profesor);
        
        Class<?> res = profesor.getClass();
        for(Field f: res.getDeclaredFields()) {
            if (f.isAnnotationPresent(MyAnnotation.class)) {
                f.setAccessible(true);
                String value;
                try {
                    value = f.get(profesor).toString();
                    System.out.println("Annotated field: "+f.getName()+": "+value);
                } catch (Exception e) {
                    Logger.getLogger(ProfesorDaoImpl.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }

        Contenedor.PROFESORES.add(profesor);
    }
    
    private void guardarLocal(Profesor profesor) {
        
        
    }
    
    private String getValueFromField(Profesor entity, Field field) throws Exception {
        Class<?> res = entity.getClass();
        for(Method method: res.getMethods()) {
            if(method.getName().equalsIgnoreCase("get"+field.getName())) {
                Object value = method.invoke(entity);
                return value != null ? value.toString() : "NULL";
            }
        }
        throw new IllegalAccessException("No getter found for field: "+field.getName());
    }
    
    @Override
    public void actualizar(Profesor profesor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void eliminarSegun(String codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Profesor> listarTodo() {
        return Contenedor.PROFESORES;
    }

    /**
    * @deprecated  As of release 1.3, replaced by {@link #getPreferredSize()}
    */
    @Deprecated
    @Override
    public List<Profesor> listarSegun(String nombres, String apellidoPaterno, String apellidoMaterno) {
        List<Profesor> profesores = new LinkedList();
        for (Profesor profesor : Contenedor.PROFESORES) {
            boolean nombreCoincide = nombres == null 
                    || nombres.isEmpty()
                    || profesor.getNombres().toLowerCase(Locale.ENGLISH)
                    .contains(nombres.toLowerCase(Locale.ENGLISH));
            boolean apellidoPaternoCoincide = apellidoPaterno == null 
                    || apellidoPaterno.isEmpty()
                    || profesor.getApellidoPaterno().toLowerCase(Locale.ENGLISH)
                    .contains(apellidoPaterno.toLowerCase(Locale.ENGLISH));
            boolean apellidoMaternoCoincide = apellidoMaterno == null 
                    || apellidoMaterno.isEmpty() 
                    || profesor.getApellidoMaterno().toLowerCase(Locale.ENGLISH)
                    .contains(apellidoMaterno.toLowerCase(Locale.ENGLISH));
            if (nombreCoincide && apellidoPaternoCoincide && apellidoMaternoCoincide) {
                profesores.add(profesor);
            }
        }
        return profesores;
    }

    @Override
    public Profesor obtenerSegun(String codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static class Contenedor {

        private static List<Profesor> PROFESORES = new LinkedList<Profesor>();
    }
    
    @Override
    public void decirHola() {
        
    }
}
