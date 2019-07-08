import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViualizadorBlocoComponent } from './visualizador-bloco.component';

describe('ViualizadorBlocoComponent', () => {
  let component: ViualizadorBlocoComponent;
  let fixture: ComponentFixture<ViualizadorBlocoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViualizadorBlocoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViualizadorBlocoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
