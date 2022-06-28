package Controller;

import Model.Project;
import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjectController {

    public void SalvarCadasto(Project project) {

        String sql = "INSERT INTO cadastros (nome, Password,"
                + "area) VALUES (?, ?, ?)";

        Connection cnn = null;
        PreparedStatement state = null;

        try {
            cnn = ConnectionFactory.getConnection();
            state = cnn.prepareStatement(sql);
            state.setString(1, project.getName());
            state.setString(2, project.getPassword());
            state.setString(3, project.getArea());
            state.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar cadastro", ex);
        } finally {
            ConnectionFactory.closeConnection(cnn, state);
        }
    }

    public void removerCadastro(Project project) {

        String sql = "DELETE FROM cadastros WHERE id = ?";

        Connection cnn = null;
        PreparedStatement state = null;

        try {
            cnn = ConnectionFactory.getConnection();
            state = cnn.prepareStatement(sql);
            state.setInt(1, project.getId());
            state.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao remover cadastro", ex);
        } finally {
            ConnectionFactory.closeConnection(cnn, state);
        }
    }

    public void atualizarCadastro(Project project) throws SQLException {

        String sql = "UPDATE cadastros SET nome = ?,"
                + "Password = ?, area = ?"
                + "WHERE id = ?";

        Connection cnn = null;
        PreparedStatement state = null;

        try {
            cnn = ConnectionFactory.getConnection();
            state = cnn.prepareStatement(sql);
            state.setInt(1, project.getId());
            state.setString(2, project.getName());
            state.setString(3, project.getPassword());
            state.setString(4, project.getArea());
            state.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar cadastro" + ex.getMessage(), ex);
        } finally {
            try {
                if (cnn != null) {
                    cnn.close();
                }
                if (state != null) {
                    state.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("erro ao fechar a conexão com o banco de dados", ex);
            }
        }
    }
}
