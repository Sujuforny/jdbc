import java.sql.SQLException;

public interface Operation {
      public void showInformention() throws SQLException;
      public void insert(Integer id,String name,String className);
      public void delete(Integer id);
      public  void update(Integer id ,String name ,String className);
      public  void search(Integer id);
}
