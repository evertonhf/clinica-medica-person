package br.edu.imepac.clinica_medica.daos;

import br.edu.imepac.clinica_medica.entidades.Funcionario;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO extends BaseDao {

    public void create(Funcionario funcionario) {
        try {
            String sql = "INSERT INTO funcionario (usuario, senha, nome, idade, sexo, cpf, rua, numero, complemento, bairro, cidade, estado, contato, email, data_nascimento, tipo_funcionario, especialidade_id, perfil_id) VALUES (?,? ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, funcionario.getUsuario());
            ps.setInt(2, funcionario.getSenha());
            ps.setString(3, funcionario.getNome());
            ps.setInt(4, funcionario.getIdade());
            ps.setString(5, String.valueOf(funcionario.getSexo()));
            ps.setString(6, funcionario.getCpf());
            ps.setString(7, funcionario.getRua());
            ps.setString(8, funcionario.getNumero());
            ps.setString(9, funcionario.getComplemento());
            ps.setString(10, funcionario.getBairro());
            ps.setString(11, funcionario.getCidade());
            ps.setString(12, funcionario.getEstado());
            ps.setString(13, funcionario.getContato());
            ps.setString(14, funcionario.getEmail());
            ps.setDate(15, Date.valueOf(funcionario.getDataNascimento()));
            ps.setString(16, funcionario.getTipoFuncionario());
            ps.setLong(17, funcionario.getEspecialidadeId());
            ps.setLong(18, funcionario.getPerfilId());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Funcionario readById(Long id) {
        try {
            String sql = "SELECT * FROM funcionario WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return new Funcionario(
                        resultSet.getLong("id"),
                        resultSet.getString("usuario"),
                        resultSet.getInt("senha"),
                        resultSet.getString("nome"),
                        resultSet.getInt("idade"),
                        resultSet.getString("sexo").charAt(0),
                        resultSet.getString("cpf"),
                        resultSet.getString("rua"),
                        resultSet.getString("numero"),
                        resultSet.getString("complemento"),
                        resultSet.getString("bairro"),
                        resultSet.getString("cidade"),
                        resultSet.getString("estado"),
                        resultSet.getString("contato"),
                        resultSet.getString("email"),
                        resultSet.getDate("data_nascimento").toLocalDate(),
                        resultSet.getString("tipo_funcionario"),
                        resultSet.getLong("especialidade_id"),
                        resultSet.getLong("perfil_id")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void update(Funcionario funcionario) {
        try {
            String sql = "UPDATE funcionario SET usuario = ?, senha = ?, nome = ?, idade = ?, sexo = ?, cpf = ?, rua = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, contato = ?, email = ?, data_nascimento = ?, tipo_funcionario = ?, especialidade_id = ?, perfil_id = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, funcionario.getUsuario());
            ps.setInt(2, funcionario.getSenha());
            ps.setString(3, funcionario.getNome());
            ps.setInt(4, funcionario.getIdade());
            ps.setString(5, String.valueOf(funcionario.getSexo()));
            ps.setString(6, funcionario.getCpf());
            ps.setString(7, funcionario.getRua());
            ps.setString(8, funcionario.getNumero());
            ps.setString(9, funcionario.getComplemento());
            ps.setString(10, funcionario.getBairro());
            ps.setString(11, funcionario.getCidade());
            ps.setString(12, funcionario.getEstado());
            ps.setString(13, funcionario.getContato());
            ps.setString(14, funcionario.getEmail());
            ps.setDate(15, Date.valueOf(funcionario.getDataNascimento()));
            ps.setString(16, funcionario.getTipoFuncionario());
            ps.setLong(17, funcionario.getEspecialidadeId());
            ps.setLong(18, funcionario.getPerfilId());
            ps.setLong(19, funcionario.getId());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Funcionario> readAll() {
        try {
            String sql = "SELECT * FROM funcionario";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            List<Funcionario> funcionarios = new ArrayList<Funcionario>();
            while (resultSet.next()) {
                funcionarios.add(new Funcionario(
                        resultSet.getLong("id"),
                        resultSet.getString("usuario"),
                        resultSet.getInt("senha"),
                        resultSet.getString("nome"),
                        resultSet.getInt("idade"),
                        resultSet.getString("sexo").charAt(0),
                        resultSet.getString("cpf"),
                        resultSet.getString("rua"),
                        resultSet.getString("numero"),
                        resultSet.getString("complemento"),
                        resultSet.getString("bairro"),
                        resultSet.getString("cidade"),
                        resultSet.getString("estado"),
                        resultSet.getString("contato"),
                        resultSet.getString("email"),
                        resultSet.getDate("data_nascimento").toLocalDate(),
                        resultSet.getString("tipo_funcionario"),
                        resultSet.getLong("especialidade_id"),
                        resultSet.getLong("perfil_id")
                ));
            }
            return funcionarios;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}