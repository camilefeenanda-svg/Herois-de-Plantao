package br.com.heroisdeplantao.modelo;
import java.time.LocalDate;
public class Paciente {
 private final int idPaciente; private String nome,cpf,sexo,telefone,email,endereco,alergias; private LocalDate dataNascimento; private boolean temConvenio;
 public Paciente(int idPaciente,String nome,String cpf,LocalDate dataNascimento,String sexo,String telefone,String email,String endereco,String alergias,boolean temConvenio){if(idPaciente<=0||nome==null||nome.isBlank()||cpf==null||cpf.isBlank()||dataNascimento==null)throw new IllegalArgumentException("Dados obrigatórios de paciente inválidos");this.idPaciente=idPaciente;this.nome=nome;this.cpf=cpf;this.dataNascimento=dataNascimento;this.sexo=sexo;this.telefone=telefone;this.email=email;this.endereco=endereco;this.alergias=alergias;this.temConvenio=temConvenio;}
 public int getIdPaciente(){return idPaciente;} public String getNome(){return nome;} public String getCpf(){return cpf;} public LocalDate getDataNascimento(){return dataNascimento;} public String getSexo(){return sexo;} public String getTelefone(){return telefone;} public String getEmail(){return email;} public String getEndereco(){return endereco;} public String getAlergias(){return alergias;} public boolean isTemConvenio(){return temConvenio;}
 public void atualizarContato(String telefone,String email,String endereco){this.telefone=telefone;this.email=email;this.endereco=endereco;} public void setTemConvenio(boolean temConvenio){this.temConvenio=temConvenio;}
}
