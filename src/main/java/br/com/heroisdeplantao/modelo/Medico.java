package br.com.heroisdeplantao.modelo;
public class Medico {private final int idMedico;private String nomeCompleto,crm,especialidade,telefone,email;
 public Medico(int idMedico,String nomeCompleto,String crm,String especialidade,String telefone,String email){if(idMedico<=0||nomeCompleto==null||nomeCompleto.isBlank()||crm==null||crm.isBlank())throw new IllegalArgumentException("Médico inválido");this.idMedico=idMedico;this.nomeCompleto=nomeCompleto;this.crm=crm;this.especialidade=especialidade;this.telefone=telefone;this.email=email;}
 public int getIdMedico(){return idMedico;}public String getNomeCompleto(){return nomeCompleto;}public String getCrm(){return crm;}public String getEspecialidade(){return especialidade;}public String getTelefone(){return telefone;}public String getEmail(){return email;}
 public void atualizarContato(String telefone,String email){this.telefone=telefone;this.email=email;}
}
