import { Injectable } from '@angular/core';
import {CadeiaBlocos } from '@taborda1964/ppdcoin/blockchain'
import EC from "elliptic";
@Injectable({
  providedIn: 'root'
})
export class BlockchainService {
  public instanciaCadeiaBlocos = new CadeiaBlocos();
  public chavesCarteira = []; 
  constructor() { 
    this.instanciaCadeiaBlocos.dificuldades = 1;
    this.instanciaCadeiaBlocos.minerarTransacoesPendentes('meu-endereco');
    this.gerarChavesCarteira();
  }

  obterBlocos() {
    return this.instanciaCadeiaBlocos.cadeia;
  }
  gerarChavesCarteira() {
    const ec = EC.ec('secp256k1');
    const chave = ec.genKeyPair();
    this.chavesCarteira.push({
      keyObj: chave,
      publicKey: chave.getPublic('hex'),
      privateKey: chave.getPrivate('hex')
    });
  }

  incluirTransacao(tx) {
    this.instanciaCadeiaBlocos.adicionarTransacao(tx);
  }

  pegarTransacoesPendentes() {
    return this.instanciaCadeiaBlocos.transacoesPendentes;
  }

  minerarTransacoesPendentes() {
    this.instanciaCadeiaBlocos.minerarTransacoesPendentes(this.chavesCarteira[0].publicKey)
  }

  
}
