import { Component, OnInit } from '@angular/core';
import { BlockchainService } from 'src/app/services/blockchain.service';

@Component({
  selector: 'app-transacoes-pendentes',
  templateUrl: './transacoes-pendentes.component.html',
  styleUrls: ['./transacoes-pendentes.component.scss']
})
export class TransacoesPendentesComponent implements OnInit {
  public transacoesPendentes = [];
  constructor(private servico: BlockchainService) { 
    this.transacoesPendentes = servico.pegarTransacoesPendentes();
  }

  ngOnInit() {
  }

  minerarTransacoesPendentes() {
    this.servico.minerarTransacoesPendentes();
  }
}
