
import br.edu.imepac.clinica_medica.entidades.Especialidade;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeDAO {

    private Connection connection;

    public EspecialidadeDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Especialidade especialidade) throws SQLException {
        String sql = "INSERT INTO Especialidade (nome, descricao) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, especialidade.getNome());
            stmt.setString(2, especialidade.getDescricao());
            stmt.executeUpdate();
        }
    }

    public Especialidade read(int id) throws SQLException {
        String sql = "SELECT * FROM Especialidade WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Especialidade(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("descricao")
                );
            }
        }
        return null;
    }

    public List<Especialidade> readAll() throws SQLException {
        List<Especialidade> especialidades = new ArrayList<>();
        String sql = "SELECT * FROM Especialidade";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                especialidades.add(new Especialidade(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("descricao")
                ));
            }
        }
        return especialidades;
    }

    public void update(Especialidade especialidade) throws SQLException {
        String sql = "UPDATE Especialidade SET nome = ?, descricao = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, especialidade.getNome());
            stmt.setString(2, especialidade.getDescricao());
            stmt.setLong(3, especialidade.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Especialidade WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
