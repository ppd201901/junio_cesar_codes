import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-visualizador-bloco',
  templateUrl: './visualizador-bloco.component.html',
  styleUrls: ['./visualizador-bloco.component.scss']
})
export class ViualizadorBlocoComponent implements OnInit {
  @Input() public bloco;
 
  constructor() { }

  ngOnInit() {
  }

}
