import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { VisualizadorCadeiaComponent } from './paginas/visualizador-cadeia/visualizador-cadeia.component';
import { ConfiguracoesComponent } from './paginas/configuracoes/configuracoes.component';
import { CriarTransacaoComponent } from './paginas/criar-transacao/criar-transacao.component';
import { TransacoesPendentesComponent } from './paginas/transacoes-pendentes/transacoes-pendentes.component';

const routes: Routes = [
  {path: '', component: VisualizadorCadeiaComponent},
  {path: 'configuracoes', component: ConfiguracoesComponent},
  {path: 'nova/transacao', component: CriarTransacaoComponent},
  {path: 'nova/transacao/pendentes', component: TransacoesPendentesComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
