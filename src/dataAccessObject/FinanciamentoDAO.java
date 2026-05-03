package dataAccessObject;

import model.Apartamento;
import model.Casa;
import model.Financiamento;
import model.Terreno;
import util.ConnectionDB;
import util.InterfaceUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FinanciamentoDAO {
    private Connection connection;

    public FinanciamentoDAO() {
        this.connection = ConnectionDB.getConnection();
    }

    public void salvar(Financiamento f) {
        String pSql = "INSERT INTO financiamentos (tipo_imovel, valor, prazo_em_meses," +
                " juros_anual, area_casa, area_terreno, num_andar, vagas_garagem, zona_local)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"; //Comando Insert Into do Postgre sendo feito por aqui.

        try {
            PreparedStatement stmt = this.connection.prepareStatement(pSql); //Organiza os atributos no DB.

            //Adiciona os valores dos atributos no DB.
            stmt.setDouble(2, f.getValor());
            stmt.setInt(3, f.getPrazoEmMeses());
            stmt.setDouble(4, f.getJurosAnual());

            if (f instanceof Casa) { //Verifica se é uma Instancia de Casa e add os dados do financiamento.
                stmt.setString(1, "Casa");
                stmt.setDouble (5, ((Casa) f).getAreaCasa());
                stmt.setDouble (6, ((Casa) f).getAreaTerreno());
                stmt.setNull(7, java.sql.Types.INTEGER);
                stmt.setNull(8, java.sql.Types.INTEGER);
                stmt.setNull(9, java.sql.Types.VARCHAR);
            }

            if (f instanceof Apartamento) { //Faz o mesmo com a instancia Apartamento.
                stmt.setString(1, "Apartamento");
                stmt.setInt (7, ((Apartamento) f).getNumAndar());
                stmt.setInt(8, ((Apartamento) f).getVagasGaragem());
                stmt.setNull(5, java.sql.Types.NUMERIC);
                stmt.setNull(6, java.sql.Types.NUMERIC);
                stmt.setNull(9, java.sql.Types.VARCHAR);
            }

            if (f instanceof Terreno) { //Faz o mesmo com a instancia Terreno.
                stmt.setString(1, "Terreno");
                stmt.setString(9, ((Terreno) f).getZonaLocal());
                stmt.setNull(5, java.sql.Types.NUMERIC);
                stmt.setNull(6, java.sql.Types.NUMERIC);
                stmt.setNull(7, java.sql.Types.INTEGER);
                stmt.setNull(8, java.sql.Types.INTEGER);

            }
            stmt.executeUpdate(); //envia as informações para o Db do postgre.

        } catch(SQLException e) {
            throw new RuntimeException(InterfaceUser.erro_vermelho + "Erro ao salvar financiamento: " + InterfaceUser.reset + e.getMessage());
        }
    }

    public ArrayList<Financiamento> consultarFinanciamentos() {
        ArrayList<Financiamento> financiamentos = new ArrayList<>();
        String pSql = "SELECT * FROM financiamentos"; //Comando Select sendo feito por aqui.

        try {
            PreparedStatement stmt = this.connection.prepareStatement(pSql); //Pega os dados e organiza na ordem do DB.
            ResultSet rs = stmt.executeQuery(); //Devolve os resultados do banco.

            while (rs.next()) { //Lê cada linha para saber os valores dos atributos.

                String tipo_imovel = rs.getString("tipo_imovel");
                double valor = rs.getDouble("valor");
                int prazoEmMeses = rs.getInt("prazo_em_meses");
                double jurosAnual = rs.getDouble("juros_Anual");

                Financiamento f = null;

                //Cada if tem como principal função verificar qual o tipo digitado e criar um objeto apartir disso.
                if (tipo_imovel.equals("Casa")) {
                    double areaCasa = rs.getDouble("area_casa");
                    double areaTerreno = rs.getDouble("area_terreno");
                    f = new Casa(valor, prazoEmMeses, jurosAnual, areaCasa, areaTerreno); //Cria um novo objeto Casa.
                }

                else if (tipo_imovel.equals("Apartamento")) {
                    int numAndar = rs.getInt("num_andar");
                    int vagasGaragem = rs.getInt("vagas_garagem");
                    f = new Apartamento(valor, prazoEmMeses, jurosAnual, numAndar, vagasGaragem); //Cria um novo objeto Apartamento.
                }

                else if (tipo_imovel.equals("Terreno")) {
                    String zonaLocal = rs.getString("zona_local");
                    f = new Terreno(valor, prazoEmMeses, jurosAnual, zonaLocal); //Cria um novo objeto Terreno.
                }

                if (f != null) {
                    financiamentos.add(f);
                }
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(InterfaceUser.erro_vermelho + "Erro ao buscar financiamentos: " + InterfaceUser.reset + e.getMessage());
        } return financiamentos;
    }

}