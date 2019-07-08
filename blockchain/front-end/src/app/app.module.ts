import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ViualizadorBlocoComponent } from './componentes/visualizador-bloco/visualizador-bloco.component';
import { VisualizadorCadeiaComponent } from './paginas/visualizador-cadeia/visualizador-cadeia.component';
import { TabelaTransacoesComponent } from './componentes/tabela-transacoes/tabela-transacoes.component';
import { ConfiguracoesComponent } from './paginas/configuracoes/configuracoes.component';
import { CriarTransacaoComponent } from './paginas/criar-transacao/criar-transacao.component';
import { TransacoesPendentesComponent } from './paginas/transacoes-pendentes/transacoes-pendentes.component';
import { FazerMatriculaComponent } from './componentes/fazer-matricula/fazer-matricula.component';

@NgModule({
  declarations: [
    AppComponent,
    ViualizadorBlocoComponent,
    VisualizadorCadeiaComponent,
    TabelaTransacoesComponent,
    ConfiguracoesComponent,
    CriarTransacaoComponent,
    TransacoesPendentesComponent,
    FazerMatriculaComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
