import { Component, OnInit } from '@angular/core';
import { BlockchainService } from 'src/app/services/blockchain.service';

@Component({
  selector: 'app-configuracoes',
  templateUrl: './configuracoes.component.html',
  styleUrls: ['./configuracoes.component.scss']
})
export class ConfiguracoesComponent implements OnInit {
  public cadeia;
  constructor(private servico:BlockchainService) { 
    this.cadeia = servico.instanciaCadeiaBlocos;
  }

  ngOnInit() {
  }

}
