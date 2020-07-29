package br.com.caelum.leilao.dominio;

import java.util.*;

public class Avaliador {

    private List<Lance> listaLances;
    private Lance maiorLance;
    private Lance menorLance;

    public void avalia(List<Lance> lances) {
        this.listaLances = new ArrayList<Lance>(lances);
        ordenaListaValoresDecrescentes();
    }

    private void ordenaListaValoresDecrescentes() {
        this.listaLances.sort((leilao1, leilao2) -> Double.compare(leilao2.getValor(), leilao1.getValor()));
    }

    public Lance getMaiorDeTodos() {
        return this.listaLances.get(0);
    }

    public Lance getMenorDeTodos() {
        return this.listaLances.get(listaLances.size() - 1);
    }

    public List<Lance> getTresMaioresLances() {
        if (this.listaLances.size() >= 3) {
            return this.listaLances.subList(0, 3);
        }
        return this.listaLances.subList(0, listaLances.size());
    }

    public List<Lance> getTresMenoresLances() {
        List<Lance> listaLancesReversa = new ArrayList<>(listaLances);
        Collections.reverse(listaLancesReversa);
        if (listaLancesReversa.size() >= 3) {
            return listaLancesReversa.subList(0, 3);
        }
        return listaLancesReversa.subList(0, listaLancesReversa.size());
    }
}
