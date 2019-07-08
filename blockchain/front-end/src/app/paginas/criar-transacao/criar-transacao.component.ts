import { Component, OnInit } from '@angular/core';
import { BlockchainService } from 'src/app/services/blockchain.service';
import { Transacao } from '@taborda1964/ppdcoin/blockchain'
@Component({
  selector: 'app-criar-transacao',
  templateUrl: './criar-transacao.component.html',
  styleUrls: ['./criar-transacao.component.scss']
})
export class CriarTransacaoComponent implements OnInit {
  public novaTx;
  public chaveCarteira;

  constructor(private servico: BlockchainService) { 
    this.chaveCarteira = this.servico.chavesCarteira[0];
  }

  ngOnInit() {
    this.novaTx = new Transacao();
  }

  criarTransacao() {
    this.novaTx.endOrigem = this.chaveCarteira.publicKey;
    this.novaTx.assinarTransacao(this.chaveCarteira.keyObj);
    this.servico.incluirTransacao(this.novaTx); 
    this.novaTx = new Transacao();
  }
}
