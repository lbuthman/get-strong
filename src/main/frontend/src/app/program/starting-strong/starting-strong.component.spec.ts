import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StartingStrongComponent } from './starting-strong.component';

describe('StartingStrongComponent', () => {
  let component: StartingStrongComponent;
  let fixture: ComponentFixture<StartingStrongComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StartingStrongComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StartingStrongComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
