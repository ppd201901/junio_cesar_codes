import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-tabela-transacoes',
  templateUrl: './tabela-transacoes.component.html',
  styleUrls: ['./tabela-transacoes.component.scss']
})
export class TabelaTransacoesComponent implements OnInit {
  @Input() public transacoes = [];
  constructor() { }

  ngOnInit() {
  }

}
