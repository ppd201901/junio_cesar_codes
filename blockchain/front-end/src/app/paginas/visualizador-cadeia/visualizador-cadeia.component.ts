import { Component, OnInit } from '@angular/core';
import { BlockchainService } from 'src/app/services/blockchain.service';
import Web3 from 'web3';


@Component({
  selector: 'app-visualizador-cadeia',
  templateUrl: './visualizador-cadeia.component.html',
  styleUrls: ['./visualizador-cadeia.component.scss']
})
export class VisualizadorCadeiaComponent implements OnInit {
  public web3;
  public contratoAbi;
  public contrato;
  public blocos = [];
  public blocoSelecionado = null;
  constructor(private servico: BlockchainService) { 
    this.blocos = servico.obterBlocos();
    console.log(this.blocos)
    this.blocoSelecionado = this.blocos[0];
  }

  ngOnInit() {
        
  }

  exibirTransacoes(bloco) {
    console.log(bloco)
    this.blocoSelecionado = bloco;
  }
}
