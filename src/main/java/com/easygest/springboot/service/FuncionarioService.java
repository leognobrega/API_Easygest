package com.easygest.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygest.springboot.model.Funcionario;
import com.easygest.springboot.model.Usuario;
import com.easygest.springboot.repository.FuncionarioRepository;
import com.easygest.springboot.repository.UsuarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // LISTAR
    public List<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }

    // SALVAR
    public Funcionario salvar(Funcionario funcionario) {

        // busca o usuário correto no banco (FK segura)
        Usuario usuario = usuarioRepository.findById(
                funcionario.getUsuario().getCodUsuario()
        ).orElseThrow();

        funcionario.setUsuario(usuario);

        return funcionarioRepository.save(funcionario);
    }

    // BUSCAR POR ID
    public Funcionario buscarPorId(Long codFuncionario) {

        return funcionarioRepository.findById(codFuncionario)
                .orElseThrow();
    }

    // ATUALIZAR
    public Funcionario atualizar(Long codFuncionario, Funcionario funcionario) {

        Funcionario funcionarioExistente = buscarPorId(codFuncionario);

        funcionarioExistente.setNomeFuncionario(funcionario.getNomeFuncionario());
        funcionarioExistente.setCpfFuncionario(funcionario.getCpfFuncionario());
        funcionarioExistente.setCtpsFuncionario(funcionario.getCtpsFuncionario());
        funcionarioExistente.setCargoFuncionario(funcionario.getCargoFuncionario());
        funcionarioExistente.setSalarioFuncionario(funcionario.getSalarioFuncionario());
        funcionarioExistente.setDataAdmissaoFuncionario(funcionario.getDataAdmissaoFuncionario());
        funcionarioExistente.setDataDemissaoFuncionario(funcionario.getDataDemissaoFuncionario());

        // atualiza o usuário corretamente (FK)
        if (funcionario.getUsuario() != null) {

            Usuario usuario = usuarioRepository.findById(
                    funcionario.getUsuario().getCodUsuario()
            ).orElseThrow();

            funcionarioExistente.setUsuario(usuario);
        }

        return funcionarioRepository.save(funcionarioExistente);
    }

    // DELETAR
    public void deletar(Long codFuncionario) {

        funcionarioRepository.deleteById(codFuncionario);
    }
}