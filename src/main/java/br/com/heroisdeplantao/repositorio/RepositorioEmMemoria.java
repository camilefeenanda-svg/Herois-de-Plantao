package br.com.heroisdeplantao.repositorio;
import java.util.*;
public class RepositorioEmMemoria<T> implements Repositorio<T>{private final Map<Integer,T> dados=new LinkedHashMap<>();public void salvar(int id,T entidade){if(entidade==null)throw new IllegalArgumentException("Entidade nula");dados.put(id,entidade);}public Optional<T> buscarPorId(int id){return Optional.ofNullable(dados.get(id));}public List<T> listar(){return new ArrayList<>(dados.values());}public void excluir(int id){dados.remove(id);}}
