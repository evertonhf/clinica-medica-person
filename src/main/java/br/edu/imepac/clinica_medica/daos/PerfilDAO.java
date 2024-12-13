package br.edu.imepac.clinica_medica.daos;

import br.edu.imepac.clinica_medica.entidades.Perfil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PerfilDAO extends BaseDao {


    public void create(Perfil perfil) throws SQLException {
        String sql = "INSERT INTO Perfil (nome, cadastrarFuncionario, lerFuncionario, atualizarFuncionario, deletarFuncionario, listarFuncionario, cadastrarPaciente, lerPaciente, atualizarPaciente, deletarPaciente, listarPaciente, cadastrarConsulta, lerConsulta, atualizarConsulta, deletarConsulta, listarConsulta, cadastrarEspecialidade, lerEspecialidade, atualizarEspecialidade, deletarEspecialidade, listarEspecialidade, cadastrarConvenio, lerConvenio, atualizarConvenio, deletarConvenio, listarConvenio, cadastrarProntuario, lerProntuario, atualizarProntuario, deletarProntuario, listarProntuario) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, perfil.getNome());
            stmt.setBoolean(2, perfil.isCadastrarFuncionario());
            stmt.setBoolean(3, perfil.isLerFuncionario());
            stmt.setBoolean(4, perfil.isAtualizarFuncionario());
            stmt.setBoolean(5, perfil.isDeletarFuncionario());
            stmt.setBoolean(6, perfil.isListarFuncionario());
            stmt.setBoolean(7, perfil.isCadastrarPaciente());
            stmt.setBoolean(8, perfil.isLerPaciente());
            stmt.setBoolean(9, perfil.isAtualizarPaciente());
            stmt.setBoolean(10, perfil.isDeletarPaciente());
            stmt.setBoolean(11, perfil.isListarPaciente());
            stmt.setBoolean(12, perfil.isCadastrarConsulta());
            stmt.setBoolean(13, perfil.isLerConsulta());
            stmt.setBoolean(14, perfil.isAtualizarConsulta());
            stmt.setBoolean(15, perfil.isDeletarConsulta());
            stmt.setBoolean(16, perfil.isListarConsulta());
            stmt.setBoolean(17, perfil.isCadastrarEspecialidade());
            stmt.setBoolean(18, perfil.isLerEspecialidade());
            stmt.setBoolean(19, perfil.isAtualizarEspecialidade());
            stmt.setBoolean(20, perfil.isDeletarEspecialidade());
            stmt.setBoolean(21, perfil.isListarEspecialidade());
            stmt.setBoolean(22, perfil.isCadastrarConvenio());
            stmt.setBoolean(23, perfil.isLerConvenio());
            stmt.setBoolean(24, perfil.isAtualizarConvenio());
            stmt.setBoolean(25, perfil.isDeletarConvenio());
            stmt.setBoolean(26, perfil.isListarConvenio());
            stmt.setBoolean(27, perfil.isCadastrarProntuario());
            stmt.setBoolean(28, perfil.isLerProntuario());
            stmt.setBoolean(29, perfil.isAtualizarProntuario());
            stmt.setBoolean(30, perfil.isDeletarProntuario());
            stmt.setBoolean(31, perfil.isListarProntuario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Perfil> readAll() {
        List<Perfil> perfis = new ArrayList<>();
        String sql = "SELECT * FROM perfil";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Perfil perfil = new Perfil(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getBoolean("cadastrarFuncionario"),
                        rs.getBoolean("lerFuncionario"),
                        rs.getBoolean("atualizarFuncionario"),
                        rs.getBoolean("deletarFuncionario"),
                        rs.getBoolean("listarFuncionario"),
                        rs.getBoolean("cadastrarPaciente"),
                        rs.getBoolean("lerPaciente"),
                        rs.getBoolean("atualizarPaciente"),
                        rs.getBoolean("deletarPaciente"),
                        rs.getBoolean("listarPaciente"),
                        rs.getBoolean("cadastrarConsulta"),
                        rs.getBoolean("lerConsulta"),
                        rs.getBoolean("atualizarConsulta"),
                        rs.getBoolean("deletarConsulta"),
                        rs.getBoolean("listarConsulta"),
                        rs.getBoolean("cadastrarEspecialidade"),
                        rs.getBoolean("lerEspecialidade"),
                        rs.getBoolean("atualizarEspecialidade"),
                        rs.getBoolean("deletarEspecialidade"),
                        rs.getBoolean("listarEspecialidade"),
                        rs.getBoolean("cadastrarConvenio"),
                        rs.getBoolean("lerConvenio"),
                        rs.getBoolean("atualizarConvenio"),
                        rs.getBoolean("deletarConvenio"),
                        rs.getBoolean("listarConvenio"),
                        rs.getBoolean("cadastrarProntuario"),
                        rs.getBoolean("lerProntuario"),
                        rs.getBoolean("atualizarProntuario"),
                        rs.getBoolean("deletarProntuario"),
                        rs.getBoolean("listarProntuario")
                );
                perfis.add(perfil);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return perfis;
    }

    public Perfil read(Long id) {
        String sql = "SELECT * FROM Perfil WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Perfil(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getBoolean("cadastrarFuncionario"),
                        rs.getBoolean("lerFuncionario"),
                        rs.getBoolean("atualizarFuncionario"),
                        rs.getBoolean("deletarFuncionario"),
                        rs.getBoolean("listarFuncionario"),
                        rs.getBoolean("cadastrarPaciente"),
                        rs.getBoolean("lerPaciente"),
                        rs.getBoolean("atualizarPaciente"),
                        rs.getBoolean("deletarPaciente"),
                        rs.getBoolean("listarPaciente"),
                        rs.getBoolean("cadastrarConsulta"),
                        rs.getBoolean("lerConsulta"),
                        rs.getBoolean("atualizarConsulta"),
                        rs.getBoolean("deletarConsulta"),
                        rs.getBoolean("listarConsulta"),
                        rs.getBoolean("cadastrarEspecialidade"),
                        rs.getBoolean("lerEspecialidade"),
                        rs.getBoolean("atualizarEspecialidade"),
                        rs.getBoolean("deletarEspecialidade"),
                        rs.getBoolean("listarEspecialidade"),
                        rs.getBoolean("cadastrarConvenio"),
                        rs.getBoolean("lerConvenio"),
                        rs.getBoolean("atualizarConvenio"),
                        rs.getBoolean("deletarConvenio"),
                        rs.getBoolean("listarConvenio"),
                        rs.getBoolean("cadastrarProntuario"),
                        rs.getBoolean("lerProntuario"),
                        rs.getBoolean("atualizarProntuario"),
                        rs.getBoolean("deletarProntuario"),
                        rs.getBoolean("listarProntuario")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(int id) {
        String sql = "DELETE FROM Perfil WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
