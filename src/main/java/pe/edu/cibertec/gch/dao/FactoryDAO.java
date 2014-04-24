package pe.edu.cibertec.gch.dao;

public class FactoryDAO {
    
    public static ProfesorDao getDaoProfesor() {
        return new ProfesorDaoImpl();
    }
    
 //   public static CursoDao getDaoCurso() {
 //       return new CursoDaoImpl();
  //  }
}
