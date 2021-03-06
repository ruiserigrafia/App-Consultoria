package dao;

import model.Servidor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServidorDao extends ModelDao {

    public ServidorDao() throws Exception {

    }

    public void inserirServidor(Servidor servidor) throws Exception {

        try {
            prepararSQL(
                    "INSERT INTO servidor VALUES (default, ?)"
            );
            getPs().setString(1, servidor.getNome());
            executarSQL();
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            getPs().close();
        }

    }

    public void alterarServidor(Servidor servidor) throws Exception {

        try {
            prepararSQL(
                    "UPDATE servidor SET nome = ? WHERE id = ?"
            );
            getPs().setString(1, servidor.getNome());
            getPs().setInt(2, servidor.getId());
            executarSQL();
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            getPs().close();
        }

    }


    public void deletarServidor(int id) throws Exception {

        try {
            prepararSQL(
                    "DELETE FROM servidor WHERE id = ?"
            );
            getPs().setInt(1, id);
            executarSQL();
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            getPs().close();
        }

    }

    public Servidor pesquisarId(int id) throws Exception{

        try {
            prepararSQL(
                "SELECT * FROM servidor WHERE id = ?"
            );
            getPs().setInt(1, id);
            executarQuerySQL();
            while (getRs().next()) {
                return new Servidor(
                        getRs().getInt(1),
                        getRs().getString(2)
                );
            }
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            getPs().close();
            getRs().close();
        }

        return null;
    }

    public Servidor pesquisarNome(String nome) throws Exception {

        try {

            prepararSQL(
                    "SELECT * FROM servidor WHERE nome = ?"
            );
            getPs().setString(1, nome);
            executarQuerySQL();
            while (getRs().next()) {
                return new Servidor(
                        getRs().getInt(1),
                        getRs().getString(2)
                );
            }
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            getPs().close();
            getRs().close();
        }

        return null;
    }

    public List<Servidor> pesquisarTodos() throws Exception {
        try {
            prepararSQL(
                    "SELECT * FROM servidor"
            );
            executarQuerySQL();
            List<Servidor> servidores = new ArrayList<>();
            while (getRs().next()) {
                servidores.add(
                        new Servidor(
                                getRs().getInt(1),
                                getRs().getString(2)
                        )
                );
            };
            return servidores;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            getPs().close();
            getRs().close();
        }
    }

    public int contarQuantidadeServidores() throws Exception {
        try {

            prepararSQL(
                    "SELECT COUNT(*) FROM servidor"
            );
            executarQuerySQL();
            return (getRs().next())? getRs().getInt(1):0;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            getPs().close();
            getRs().close();
        }

    }
}
