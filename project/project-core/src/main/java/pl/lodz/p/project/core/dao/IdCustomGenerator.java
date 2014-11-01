package pl.lodz.p.project.core.dao;


/**
 *
 * @author Milczu
 */
public class IdCustomGenerator { /* TODO implements IdentifierGenerator {

    @Override
    public Serializable generate(SessionImplementor session, Object o) throws HibernateException {
        Connection connection = session.connection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT prefixed_seq('goods_seq') as id");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String id = rs.getString("id");
                System.out.println("Generated ID: " + id);
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new HibernateException( "Unable to generate Stock Code Sequence");
        }
        return null;
    }*/

}
