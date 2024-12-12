package br.edu.imepac.clinica_medica.daos;

import br.edu.imepac.clinica_medica.entidades.Convenio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConvenioDAO extends BaseDao {

    public void create(Convenio convenio) throws SQLException {
        String sql = "INSERT INTO Convenio (nome, descricao) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, convenio.getNome());
            stmt.setString(2, convenio.getDescricao());
            stmt.executeUpdate();
        }
    }

    public Convenio read(int id) throws SQLException {
        String sql = "SELECT * FROM Convenio WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Convenio(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("descricao")
                );
            }
        }
        return null;
    }

    public List<Convenio> readAll() throws SQLException {
        List<Convenio> convenios = new ArrayList<>();
        String sql = "SELECT * FROM Convenio";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                convenios.add(new Convenio(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("descricao")
                ));
            }
        }
        return convenios;
    }

    public void update(Convenio convenio) throws SQLException {
        String sql = "UPDATE Convenio SET nome = ?, descricao = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, convenio.getNome());
            stmt.setString(2, convenio.getDescricao());
            stmt.setLong(3, convenio.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Convenio WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}
