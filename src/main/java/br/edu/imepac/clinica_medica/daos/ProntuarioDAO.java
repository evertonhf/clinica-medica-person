package br.edu.imepac.clinica_medica.daos;

import br.edu.imepac.clinica_medica.entidades.Prontuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProntuarioDAO extends BaseDao {


    public void create(Prontuario prontuario) throws SQLException {
        String sql = "INSERT INTO Prontuario (receituario, exames, observacoes) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, prontuario.getReceituario());
            stmt.setString(2, prontuario.getExames());
            stmt.setString(3, prontuario.getObservacoes());
            stmt.executeUpdate();
        }
    }

    public Prontuario read(int id) throws SQLException {
        String sql = "SELECT * FROM Prontuario WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Prontuario(
                        rs.getLong("id"),
                        rs.getString("receituario"),
                        rs.getString("exames"),
                        rs.getString("observacoes")
                );
            }
        }
        return null;
    }

    public List<Prontuario> readAll() throws SQLException {
        List<Prontuario> prontuarios = new ArrayList<>();
        String sql = "SELECT * FROM Prontuario";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                prontuarios.add(new Prontuario(
                        rs.getLong("id"),
                        rs.getString("receituario"),
                        rs.getString("exames"),
                        rs.getString("observacoes")
                ));
            }
        }
        return prontuarios;
    }

    public void update(Prontuario prontuario) throws SQLException {
        String sql = "UPDATE Prontuario SET receituario = ?, exames = ?, observacoes = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, prontuario.getReceituario());
            stmt.setString(2, prontuario.getExames());
            stmt.setString(3, prontuario.getObservacoes());
            stmt.setLong(4, prontuario.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Prontuario WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}
