package br.com.heroisdeplantao.modelo;
import java.time.LocalDate;import java.time.LocalTime;
public class Consulta {public enum Status{AGENDADA,CANCELADA}private final int idConsulta;private final LocalDate data;private final LocalTime hora;private final Paciente paciente;private final Medico medico;private Status status=Status.AGENDADA;
 public Consulta(int idConsulta,LocalDate data,LocalTime hora,Paciente paciente,Medico medico){if(idConsulta<=0||data==null||hora==null||paciente==null||medico==null)throw new IllegalArgumentException("Consulta inválida");this.idConsulta=idConsulta;this.data=data;this.hora=hora;this.paciente=paciente;this.medico=medico;}
 public int getIdConsulta(){return idConsulta;}public LocalDate getData(){return data;}public LocalTime getHora(){return hora;}public Paciente getPaciente(){return paciente;}public Medico getMedico(){return medico;}public Status getStatus(){return status;}public void cancelar(){if(status==Status.CANCELADA)throw new IllegalStateException("Consulta já cancelada");status=Status.CANCELADA;}
}
