package br.com.redesocial.modelo.bo;

import br.com.redesocial.modelo.dao.UsuarioDAO;
import br.com.redesocial.modelo.dto.Usuario;

/**
 * Define as regras de negócio para os usuários
 * @author Ronneesley Moura Teles
 * @since 27/07/2017
 */
public class UsuarioBO extends BOCRUDBase<Usuario, UsuarioDAO> {
    @Override
    protected UsuarioDAO instanciarDAO() {
        return new UsuarioDAO();
    }

    @Override
    protected void validar(Usuario dto) throws Exception {
        //Validações
        if (dto.getNome().trim().equals("")) throw new Exception("Preencha o nome do usuário");
        
        if (dto.getEmail().trim().equals("")) throw new Exception("Preencha o e-mail do usuário");
        
        if (dto.getSenha().trim().equals("")) throw new Exception("Preencha a senha do usuário");
        
        if (dto.getTelefone().trim().equals("")) throw new Exception("Preencha o telefone do usuário");
        
        if (dto.getNascimento() == null) throw new Exception("Preencha a data de nascimento do usuário");
        
        if (dto.getSexo() == null) throw new Exception("Preencha o sexo do usuário");
        
        if (dto.getDataCadastro() == null) throw new Exception("Preencha a data de cadastro do usuário");
        
        if (dto.getStatus() == null) throw new Exception("Preencha o status do usuário");
        
        if (dto.getFoto() == null) throw new Exception("Preencha a foto de perfil do usuário");
        
        //Validação de chave estrangeira
        if (dto.getCidade() == null) throw new Exception("Preencha a cidade do usuário");
    }

    @Override
    protected void validarChavePrimaria(Usuario dto) throws Exception {
        if (dto.getId() == null) throw new Exception("Preencha o campo id");
    }
}
