package Stagires;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StagiereDaoImpl implements StagiereDao{
    private static final String URL = "jdbc:mysql://localhost:3306/ofppt";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";


    @Override
    public List<Stagiere> fetchall(){
       String query = "select * from stagiere";
        ArrayList<Stagiere> stagieres = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(query) ;
           while (resultSet.next()){
               stagieres.add(mapResultSetTostagiere(resultSet));
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stagieres;
    }

    @Override
    public Stagiere finById(int id) {
        String query = "select * from stagiere where id = ?";
        try{
      Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
      PreparedStatement st = conn.prepareStatement(query);
      st.setInt(1,id);
            ResultSet resultSet = st.executeQuery();
            if(resultSet.next()) {
                return mapResultSetTostagiere(resultSet);
            }

        }catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void addStagiere(Stagiere stagiere) {
        String query = "INSERT INTO stagiere (nom, prénom, age, login, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, stagiere.getName());
            statement.setString(2, stagiere.getLastname());
            statement.setInt(3, stagiere.getAge());
            statement.setString(4, stagiere.getLogin());
            statement.setString(5, stagiere.getPassword());

            statement.executeUpdate();

            // Retrieve the generated ID (if needed)
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                stagiere.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStagiere(Stagiere stagiere) {

        String query = "update stagiere set nom = ?,prénom = ?, age = ?, login = ?, password = ? where id = ?" ;

        try {
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1,stagiere.getName());
            st.setString(2,stagiere.getLastname());
            st.setInt(3,stagiere.getAge());
            st.setString(4,stagiere.getLogin());
            st.setString(5,stagiere.getPassword());
            st.setInt(6, stagiere.getId());
            st.executeUpdate();


        }catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteStagiereById(int id) {
        String query = "DELETE FROM stagiere WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private static Stagiere mapResultSetTostagiere(ResultSet resultSet) throws SQLException {
        Stagiere stagiere = new Stagiere();
        stagiere.setId(resultSet.getInt("id"));
        stagiere.setName(resultSet.getString("nom"));
        stagiere.setLastname(resultSet.getString("prénom"));
        stagiere.setAge(resultSet.getInt("age"));
        stagiere.setLogin(resultSet.getString("login"));
        return stagiere;

    }
}
