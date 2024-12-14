package br.edu.imepac.clinica_medica.daos;

import br.edu.imepac.clinica_medica.entidades.Especialidade;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeDAO extends BaseDao {

    public void create(Especialidade especialidade) {
        String sql = "INSERT INTO Especialidade (nome, descricao) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, especialidade.getNome());
            stmt.setString(2, especialidade.getDescricao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Especialidade read(Long id) {
        String sql = "SELECT * FROM Especialidade WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Especialidade(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("descricao")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Especialidade> readAll() {
        List<Especialidade> especialidades = new ArrayList<>();
        String sql = "SELECT * FROM especialidade";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                especialidades.add(new Especialidade(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("descricao")
                ));
            }
        return especialidades;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Especialidade especialidade) {
        String sql = "UPDATE Especialidade SET nome = ?, descricao = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, especialidade.getNome());
            stmt.setString(2, especialidade.getDescricao());
            stmt.setLong(3, especialidade.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM Especialidade WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}