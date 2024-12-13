package br.edu.imepac.clinica_medica.daos;

import br.edu.imepac.clinica_medica.entidades.Funcionario;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO extends BaseDao {

    // Método para criar um novo registro de Funcionario no banco de dados
    public void create(Funcionario funcionario) {
        try {
            // SQL para inserir um novo Funcionario
            String sql = "INSERT INTO funcionario (usuario, senha, nome, idade, sexo, cpf, rua, numero, complemento, bairro, cidade, estado, contato, email, data_nascimento, tipo_funcionario, especialidade_id, perfil_id) VALUES (?,? ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            // Preparar a declaração SQL
            PreparedStatement ps = connection.prepareStatement(sql);
            // Definir os valores dos parâmetros
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
            // Executar a declaração SQL
            ps.execute();
        } catch (SQLException ex) {
            // Imprimir a pilha de erros em caso de exceção
            ex.printStackTrace();
        }
    }

    // Método para ler um Funcionario do banco de dados pelo ID
    public Funcionario readById(Long id) {
        try {
            // SQL para selecionar um Funcionario pelo ID
            String sql = "SELECT * FROM funcionario WHERE id = ?";
            // Preparar a declaração SQL
            PreparedStatement ps = connection.prepareStatement(sql);
            // Definir o valor do parâmetro ID
            ps.setLong(1, id);
            // Executar a consulta e obter o resultado
            ResultSet resultSet = ps.executeQuery();
            // Se houver um resultado, criar um objeto Funcionario com os dados
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
            // Imprimir a pilha de erros em caso de exceção
            ex.printStackTrace();
        }
        return null;
    }

    // Método para atualizar um registro de Funcionario no banco de dados
    public void update(Funcionario funcionario) {
        try {
            // SQL para atualizar um Funcionario
            String sql = "UPDATE funcionario SET usuario = ?, senha = ?, nome = ?, idade = ?, sexo = ?, cpf = ?, rua = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, contato = ?, email = ?, data_nascimento = ?, tipo_funcionario = ?, especialidade_id = ?, perfil_id = ? WHERE id = ?";
            // Preparar a declaração SQL
            PreparedStatement ps = connection.prepareStatement(sql);
            // Definir os valores dos parâmetros
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
            // Executar a declaração SQL
            ps.execute();
        } catch (SQLException ex) {
            // Imprimir a pilha de erros em caso de exceção
            ex.printStackTrace();
        }
    }

    // Método para ler todos os registros de Funcionario do banco de dados
    public List<Funcionario> readAll() {
        try {
            // SQL para selecionar todos os Funcionarios
            String sql = "SELECT * FROM funcionario";
            // Preparar a declaração SQL
            PreparedStatement ps = connection.prepareStatement(sql);
            // Executar a consulta e obter o resultado
            ResultSet resultSet = ps.executeQuery();
            // Lista para armazenar os Funcionarios
            List<Funcionario> funcionarios = new ArrayList<Funcionario>();
            // Iterar sobre os resultados e adicionar cada Funcionario à lista
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
            // Retornar a lista de Funcionarios
            return funcionarios;
        } catch (SQLException ex) {
            // Imprimir a pilha de erros em caso de exceção
            ex.printStackTrace();
        }
        return null;
    }

    // Método para deletar um registro de Funcionario do banco de dados pelo ID
    public void delete(Long id) {
        try {
            // SQL para deletar um Funcionario pelo ID
            String sql = "DELETE FROM funcionario WHERE id = ?";
            // Preparar a declaração SQL
            PreparedStatement ps = connection.prepareStatement(sql);
            // Definir o valor do parâmetro ID
            ps.setLong(1, id);
            // Executar a declaração SQL
            ps.execute();
        } catch (SQLException ex) {
            // Imprimir a pilha de erros em caso de exceção
            ex.printStackTrace();
        }
    }

    public Funcionario readByUsuario(String text) {
        try {
            String sql = "SELECT * FROM funcionario WHERE usuario = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, text);
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
}