public class UserDao {
    public void add(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/users_db", "root", "Kknnyy0819@@!");

        PreparedStatement ps = c.prepareStatement(
            "INSERT INTO users (id, name, password) VALUES (?, ?, ?)"
        );
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/users_db", "root", "Kknnyy0819@@!");

        PreparedStatement ps = c.prepareStatement(
            "SELECT * FROM users WHERE id=?"
        );
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        User user = null;
        if (rs.next()) {
            user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
        }

        rs.close();
        ps.close();
        c.close();

        return user;
    }
}
