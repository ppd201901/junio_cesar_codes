import { Component, OnInit, Injectable } from '@angular/core';

import Web3 from 'web3';

@Component({
  selector: 'app-fazer-matricula',
  templateUrl: './fazer-matricula.component.html',
  styleUrls: ['./fazer-matricula.component.scss']
})
export class FazerMatriculaComponent implements OnInit {
  public web3;
  
  constructor() { }

  ngOnInit() {
    if (typeof this.web3 !== 'undefined') {
      this.web3 =  new Web3(this.web3.currentProvider);
    } else {
        this.web3 = new Web3("http://localhost:8545");
    }
    console.log(this.web3)
  }

}
