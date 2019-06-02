import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TransferenciasPeriodicasComponent } from './transferencias-periodicas.component';

describe('TransferenciasPeriodicasComponent', () => {
  let component: TransferenciasPeriodicasComponent;
  let fixture: ComponentFixture<TransferenciasPeriodicasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TransferenciasPeriodicasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TransferenciasPeriodicasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
