import java.sql.SQLException;

public class main{
    public static void main(String[] arg) throws ClassNotFoundException,SQLException{
    UserDao dao=new UserDao();

    User user=new User();
    user.setId("whiteship");
    user.setName("백기선");
    user.setPassword("married");

    dao.add(user);

    System.out.println(user.getId()+" 등록성공!");
}
}