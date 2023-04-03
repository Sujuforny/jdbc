import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ostudent implements Operation{

    @Override
    public void showInformention() throws SQLException {
        try (Connection con = ConnectionData.dataSource().getConnection()){
            String selectsql = "SELECT * FROM tb_student";
            PreparedStatement statement= con.prepareStatement(selectsql);
            ResultSet resultSet= statement.executeQuery();
            List<Student> students = new ArrayList<>();
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String className = resultSet.getString("class_name");
                students.add(new Student(id,name,className));
            }
            students.forEach(System.out::println);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Integer id, String name, String className) {
        try(Connection con = ConnectionData.dataSource().getConnection()){
            String insersql = "INSERT INTO tb_student(id,name,class_name) VALUES (?,?,?)";
            PreparedStatement statement = con.prepareStatement(insersql);

            statement.setInt(1,id);
            statement.setString(2,name);
            statement.setString(3,className);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try(Connection con = ConnectionData.dataSource().getConnection()){
            String deletesql = "DELETE FROM tb_student WHERE id="+id;
            PreparedStatement statement = con.prepareStatement(deletesql);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id ,String name ,String className) {
        try(Connection con = ConnectionData.dataSource().getConnection()){
            String updatesql = "UPDATE tb_student"+" SET name = "+name+","+" class_name = "+className+" WHERE id = "+id;
            PreparedStatement statement = con.prepareStatement(updatesql);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void search(Integer ids) {
        try(Connection con = ConnectionData.dataSource().getConnection()){
            String searchsql = "SELECT * FROM tb_student WHERE id="+ids;
            PreparedStatement statement = con.prepareStatement(searchsql);
            ResultSet resultSet= statement.executeQuery();
            List<Student> students = new ArrayList<>();
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String className = resultSet.getString("class_name");
                students.add(new Student(id,name,className));
            }
            students.forEach(System.out::println);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
