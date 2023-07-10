import { TestBed } from '@angular/core/testing';

import { FoodAppService } from './food-app.service';

describe('FoodAppService', () => {
  let service: FoodAppService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FoodAppService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
