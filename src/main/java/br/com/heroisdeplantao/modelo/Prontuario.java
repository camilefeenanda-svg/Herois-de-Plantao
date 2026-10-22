package br.com.heroisdeplantao.modelo;
import java.util.ArrayList;import java.util.Collections;import java.util.List;
public class Prontuario {private final int idProntuario;private final Paciente paciente;private final List<String> registros=new ArrayList<>();
 public Prontuario(int idProntuario,Paciente paciente){if(idProntuario<=0||paciente==null)throw new IllegalArgumentException("Prontuário inválido");this.idProntuario=idProntuario;this.paciente=paciente;}
 public int getIdProntuario(){return idProntuario;}public Paciente getPaciente(){return paciente;}public void adicionarRegistro(String diagnostico,String descricao){if(diagnostico==null||diagnostico.isBlank()||descricao==null||descricao.isBlank())throw new IllegalArgumentException("Registro incompleto");registros.add("Diagnóstico: "+diagnostico+" | Descrição: "+descricao);}
 public List<String> getRegistros(){return Collections.unmodifiableList(registros);}public String consultar(){return String.join("\n",registros);}
}
