package br.com.heroisdeplantao.servico;
import br.com.heroisdeplantao.modelo.*;
import br.com.heroisdeplantao.repositorio.RepositorioEmMemoria;
import java.time.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
class ConsultaServicoTest {
  private ConsultaServico servico;
  private Paciente paciente, outroPaciente;
  private Medico medico, outroMedico;
  private final LocalDate data=LocalDate.of(2027,2,10);
  private final LocalTime hora=LocalTime.of(9,30);
  @BeforeEach void iniciar(){
    servico=new ConsultaServico(new RepositorioEmMemoria<>());
    paciente=new Paciente(1,"Ana","111",LocalDate.of(1990,1,1),"F","","","","",false);
    outroPaciente=new Paciente(2,"João","222",LocalDate.of(1991,1,1),"M","","","","",false);
    medico=new Medico(1,"Dra. Maria","CRM-1","Clínica","","");
    outroMedico=new Medico(2,"Dr. Paulo","CRM-2","Clínica","","");
  }
  @Test void agendaConsultaEmHorarioLivre(){Consulta c=new Consulta(1,data,hora,paciente,medico); assertDoesNotThrow(()->servico.agendar(c)); assertEquals(Consulta.Status.AGENDADA,c.getStatus());}
  @Test void rejeitaMesmoMedicoNoMesmoHorario(){servico.agendar(new Consulta(1,data,hora,paciente,medico)); assertThrows(IllegalArgumentException.class,()->servico.agendar(new Consulta(2,data,hora,outroPaciente,medico)));}
  @Test void rejeitaMesmoPacienteNoMesmoHorario(){servico.agendar(new Consulta(1,data,hora,paciente,medico));assertThrows(IllegalArgumentException.class,()->servico.agendar(new Consulta(2,data,hora,paciente,outroMedico)));}
  @Test void permiteDoisMedicosEPacientesDiferentes(){servico.agendar(new Consulta(1,data,hora,paciente,medico));assertDoesNotThrow(()->servico.agendar(new Consulta(2,data,hora,outroPaciente,outroMedico)));}
  @Test void permiteNovoAgendamentoAposCancelamento(){servico.agendar(new Consulta(1,data,hora,paciente,medico));servico.cancelar(1);assertDoesNotThrow(()->servico.agendar(new Consulta(2,data,hora,paciente,medico)));}
  @Test void rejeitaIdDuplicado(){servico.agendar(new Consulta(1,data,hora,paciente,medico));assertThrows(IllegalArgumentException.class,()->servico.agendar(new Consulta(1,data.plusDays(1),hora,outroPaciente,outroMedico)));}
  @Test void rejeitaCancelamentoDeConsultaInexistente(){assertThrows(IllegalArgumentException.class,()->servico.cancelar(99));}
  @Test void rejeitaSegundoCancelamento(){servico.agendar(new Consulta(1,data,hora,paciente,medico));servico.cancelar(1);assertThrows(IllegalStateException.class,()->servico.cancelar(1));}
}
