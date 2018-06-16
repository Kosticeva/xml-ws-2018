import { TestBed, inject } from '@angular/core/testing';

import { AccomService } from './accom.service';

describe('AccomService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AccomService]
    });
  });

  it('should be created', inject([AccomService], (service: AccomService) => {
    expect(service).toBeTruthy();
  }));
});
