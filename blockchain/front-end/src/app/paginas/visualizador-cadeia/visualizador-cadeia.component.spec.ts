import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VisualizadorCadeiaComponent } from './visualizador-cadeia.component';

describe('VisualizadorCadeiaComponent', () => {
  let component: VisualizadorCadeiaComponent;
  let fixture: ComponentFixture<VisualizadorCadeiaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VisualizadorCadeiaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VisualizadorCadeiaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
