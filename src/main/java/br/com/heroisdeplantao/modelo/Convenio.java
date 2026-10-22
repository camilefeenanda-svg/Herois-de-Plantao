package br.com.heroisdeplantao.modelo;
public class Convenio {private final int idConvenio;private String nome,tipoPlano,contato;private final Paciente paciente;
 public Convenio(int idConvenio,String nome,String tipoPlano,String contato,Paciente paciente){if(idConvenio<=0||nome==null||nome.isBlank()||paciente==null)throw new IllegalArgumentException("Convênio inválido");this.idConvenio=idConvenio;this.nome=nome;this.tipoPlano=tipoPlano;this.contato=contato;this.paciente=paciente;}
 public int getIdConvenio(){return idConvenio;}public String getNome(){return nome;}public String getTipoPlano(){return tipoPlano;}public String getContato(){return contato;}public Paciente getPaciente(){return paciente;}public void atualizar(String nome,String tipoPlano,String contato){if(nome==null||nome.isBlank())throw new IllegalArgumentException("Nome obrigatório");this.nome=nome;this.tipoPlano=tipoPlano;this.contato=contato;}
}
