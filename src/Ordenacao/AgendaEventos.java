package Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        this.eventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nomeEvento, String descricaoAtracao) {
        eventosMap.put(data, new Evento(nomeEvento, descricaoAtracao));
    }

    public void exibirAgenda() {
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
            LocalDate dataEvento = entry.getKey();
            Evento evento = entry.getValue();
            System.out.println("Data: " + dataEvento + ", Evento: " + evento.getNome() + ", Atração: " + evento.getAtracao());
        }
    }

    public void obterProximoEvento() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        for (Map.Entry<LocalDate, Evento> entry : eventosMap.entrySet()) {
            LocalDate dataEvento = entry.getKey();
            if (dataEvento.isEqual(dataAtual) || dataEvento.isAfter(dataAtual)) {
                proximaData = dataEvento;
                proximoEvento = entry.getValue();
                break;
            }
        }
        if (proximoEvento != null) {
            System.out.println("O próximo evento: " + proximoEvento.getNome() + " acontecerá na data " + proximaData);
        } else {
            System.out.println("Não há eventos futuros na agenda.");
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();


        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JUNE, 28), "Apresentacao Tecnico do Vasco", "Sera na lagoa");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 9, 10), "Jogo do Vasco", "Jogo Importante");
        agendaEventos.adicionarEvento(LocalDate.of(2000, 10, 01), "Lançamento de Camisa", "Nova camisa do Vasco");
        agendaEventos.adicionarEvento(LocalDate.of(2028, Month.SEPTEMBER, 21), "Inauguracao de SAo Januario", "Primeiro jogo novo Sao Januario");
        agendaEventos.adicionarEvento(LocalDate.of(2025, 11, 15), "Vasco da Gama", "Campeao da Libertadores");


        agendaEventos.exibirAgenda();


        agendaEventos.obterProximoEvento();
    }
}