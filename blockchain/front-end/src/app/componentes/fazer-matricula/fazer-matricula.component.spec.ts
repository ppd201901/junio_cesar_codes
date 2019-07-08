import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FazerMatriculaComponent } from './fazer-matricula.component';

describe('FazerMatriculaComponent', () => {
  let component: FazerMatriculaComponent;
  let fixture: ComponentFixture<FazerMatriculaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FazerMatriculaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FazerMatriculaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
