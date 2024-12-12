package br.edu.imepac.clinica_medica.daos;

import br.edu.imepac.clinica_medica.entidades.Consulta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO extends BaseDao {

    public void create(Consulta consulta) throws SQLException {
        String sql = "INSERT INTO Consulta (dataHorario, sintomas, eRetorno, estaAtiva) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setTimestamp(1, Timestamp.valueOf(consulta.getDataHorario()));
            stmt.setString(2, consulta.getSintomas());
            stmt.setBoolean(3, consulta.eRetorno());
            stmt.setBoolean(4, consulta.estaAtiva());
            stmt.executeUpdate();
        }
    }

    public Consulta read(int id) throws SQLException {
        String sql = "SELECT * FROM Consulta WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Consulta(
                        rs.getLong("id"),
                        rs.getTimestamp("dataHorario").toLocalDateTime(),
                        rs.getString("sintomas"),
                        rs.getBoolean("eRetorno"),
                        rs.getBoolean("estaAtiva")
                );
            }
        }
        return null;
    }

    public List<Consulta> readAll() throws SQLException {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT * FROM Consulta";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                consultas.add(new Consulta(
                        rs.getLong("id"),
                        rs.getTimestamp("dataHorario").toLocalDateTime(),
                        rs.getString("sintomas"),
                        rs.getBoolean("eRetorno"),
                        rs.getBoolean("estaAtiva")
                ));
            }
        }
        return consultas;
    }

    public void update(Consulta consulta) throws SQLException {
        String sql = "UPDATE Consulta SET dataHorario = ?, sintomas = ?, eRetorno = ?, estaAtiva = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setTimestamp(1, Timestamp.valueOf(consulta.getDataHorario()));
            stmt.setString(2, consulta.getSintomas());
            stmt.setBoolean(3, consulta.eRetorno());
            stmt.setBoolean(4, consulta.estaAtiva());
            stmt.setLong(5, consulta.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Consulta WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}
