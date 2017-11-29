/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.redesocial.controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Inimigo
 */
@WebServlet(name = "TiposAtividadesControle", urlPatterns = {"/TiposAtividadesControle"})
public class TiposAtividadesControle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String operacao = request.getParameter("operacao");
        
       
            try {
                switch (operacao){
                    case "CriarNovo":
                        this.criarNovo(request, response);
                        break;
                    case "Cadastrar":
                        this.cadastrar(request, response);
                        break;
                    case "Listar":
                        this.listar(request, response);
                        break;
                    case "Excluir":
                        this.excluir(request, response);
                        break;
                    case "Editar":
                        this.editar(request, response);
                        break;
                }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
private void criarNovo(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
           TiposAtividades tiposatividades = new TiposAtividades();

            request.setAttribute("tiposatividades", tiposatividades);
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        mostrar(request, response, "paginas/tiposatividades/cadastro.jsp");
    }
private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        TiposAtividades tiposatividades = new TiposAtividades();

        if (!"".equals(request.getParameter("id").trim())){
            tiposatividades.setId(Integer.parseInt(request.getParameter("id")));
        }

        tiposatividades.setNome(request.getParameter("nome"));

        request.setAttribute("tiposatividades", tiposatividades);

        if (tiposatividades.getId() == null){
            this.inserir(tiposatividades, request, response);
        } else {
            this.alterar(tiposatividades, request, response);
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/tiposatividades/cadastro.jsp");
        rd.forward(request, response);
    }
private void inserir(TiposAtividades tiposatividades, HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            TiposAtividadesBO tiposatividadesBO = new TiposAtividadesBO();
            tiposatividadesBO.inserir(tiposatividades);

            request.setAttribute("mensagem", "Cadastro realizado com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }
    }
private void alterar(TiposAtividades tiposatividades, HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            TiposAtividadesBO tiposatividadesBO = new TiposAtividadesBO();
            tiposatividadesBO.alterar(tiposatividades);

            request.setAttribute("mensagem", "Alteração realizada com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }
    }
private void editar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));

            TiposAtividadesBO tiposatividadesBO = new TiposAtividadesBO();
            TiposAtividades tiposatividades = tiposatividadesBO.selecionar(id);

            request.setAttribute("tiposatividades", tiposatividades);

            request.setAttribute("mensagem", "Registro selecionado com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/tiposatividades/cadastro_tiposatividades.jsp");
        rd.forward(request, response);
    }
private void listar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            TiposAtividadesBO bo = new TiposAtividadesBO();
            List tiposatividades = bo.listar();

            request.setAttribute("lista", tiposatividades);
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher("paginas/paises/listagem_paises.jsp");
        rd.forward(request, response);
    }
private void excluir(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));

            TiposAtividadesBO bo = new TiposAtividadesBO();
            bo.excluir(id);

            request.setAttribute("mensagem", "Excluído com sucesso");
        } catch (Exception ex){
            request.setAttribute("erro", ex.getMessage());
        }

        this.listar(request, response);
    }
} /**
     * Requisições do tipo GET
     * @param request requisição
     * @param response resposta
     * @throws javax.servlet.ServletException se ocorre um erro no Servlet
     * @throws java.io.IOException se ocorre um erro de entrada e saída
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Tratamento dos envios pelo método POST
     * @param request requisição
     * @param response resposta
     * @throws javax.servlet.ServletException se ocorre um erro no Servlet
     * @throws java.io.IOException se ocorre um erro de entrada e saída
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Descrição do Servlet
     * @return descrição
     */
    @Override
    public String getServletInfo() {
        return "Servlet para TiposAtividades";
    }
}
