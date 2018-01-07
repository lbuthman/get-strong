import { TestBed, inject } from '@angular/core/testing';

import { StartingStrongService } from './starting-strong.service';

describe('StartingStrongService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [StartingStrongService]
    });
  });

  it('should be created', inject([StartingStrongService], (service: StartingStrongService) => {
    expect(service).toBeTruthy();
  }));
});
