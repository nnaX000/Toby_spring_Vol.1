import java.sql.SQLException;

public class main{
    public static void main(String[] arg) throws ClassNotFoundException,SQLException{
    UserDao dao=new UserDao();

    User user=new User();
    user.setId("나요k");
    user.setName("김나");
    user.setPassword("0819");

    dao.add(user);

    System.out.println(user.getId()+" 등록성공!");
    
    User user2=dao.get(user.getId());
    System.out.println(user2.getName());
    System.out.println(user2.getPassword());
    
    System.out.println(user2.getId());
    
    }
}