package br.edu.imepac.clinica_medica.daos;

import br.edu.imepac.clinica_medica.entidades.Paciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO  extends BaseDao {

    public void create(Paciente paciente) throws SQLException {
        String sql = "INSERT INTO Paciente (nome, idade, sexo, cpf, rua, numero, complemento, bairro, cidade, estado, contato, email, dataNascimento) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNome());
            stmt.setInt(2, paciente.getIdade());
            stmt.setString(3, String.valueOf(paciente.getSexo()));
            stmt.setString(4, paciente.getCpf());
            stmt.setString(5, paciente.getRua());
            stmt.setString(6, paciente.getNumero());
            stmt.setString(7, paciente.getComplemento());
            stmt.setString(8, paciente.getBairro());
            stmt.setString(9, paciente.getCidade());
            stmt.setString(10, paciente.getEstado());
            stmt.setString(11, paciente.getContato());
            stmt.setString(12, paciente.getEmail());
            stmt.setDate(13, Date.valueOf(paciente.getDataNascimento()));
            stmt.executeUpdate();
        }
    }

    public Paciente read(int id) throws SQLException {
        String sql = "SELECT * FROM Paciente WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Paciente(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("sexo").charAt(0),
                        rs.getString("cpf"),
                        rs.getString("rua"),
                        rs.getString("numero"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("contato"),
                        rs.getString("email"),
                        rs.getDate("dataNascimento").toLocalDate()
                );
            }
        }
        return null;
    }

    public List<Paciente> readAll() throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM Paciente";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pacientes.add(new Paciente(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("sexo").charAt(0),
                        rs.getString("cpf"),
                        rs.getString("rua"),
                        rs.getString("numero"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("contato"),
                        rs.getString("email"),
                        rs.getDate("dataNascimento").toLocalDate()
                ));
            }
        }
        return pacientes;
    }

    public void update(Paciente paciente) throws SQLException {
        String sql = "UPDATE Paciente SET nome = ?, idade = ?, sexo = ?, cpf = ?, rua = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, contato = ?, email = ?, dataNascimento = ? "
                + "WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNome());
            stmt.setInt(2, paciente.getIdade());
            stmt.setString(3, String.valueOf(paciente.getSexo()));
            stmt.setString(4, paciente.getCpf());
            stmt.setString(5, paciente.getRua());
            stmt.setString(6, paciente.getNumero());
            stmt.setString(7, paciente.getComplemento());
            stmt.setString(8, paciente.getBairro());
            stmt.setString(9, paciente.getCidade());
            stmt.setString(10, paciente.getEstado());
            stmt.setString(11, paciente.getContato());
            stmt.setString(12, paciente.getEmail());
            stmt.setDate(13, Date.valueOf(paciente.getDataNascimento()));
            stmt.setLong(14, paciente.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Paciente WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}
