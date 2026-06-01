package repositorio;
import negocio.ContaAbstrata;
import excecoes.*;

public interface RepositorioContas {
    void inserir(ContaAbstrata conta) throws ContaNaoEncontradaException;
    ContaAbstrata procurar(String numero) throws ContaNaoEncontradaException;
    void remover(String numero) throws ContaNaoEncontradaException;
    void atualizar(ContaAbstrata conta) throws ContaNaoEncontradaException;
    boolean existe(String numero) throws ContaNaoEncontradaException;
} 

/*
Todos os métodos são public e abstract por default 
e não se definem atributos nem construtores
*/