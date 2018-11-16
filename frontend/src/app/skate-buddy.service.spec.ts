import { TestBed } from '@angular/core/testing';

import { SkateBuddyService } from './skate-buddy.service';

describe('SkateBuddyService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SkateBuddyService = TestBed.get(SkateBuddyService);
    expect(service).toBeTruthy();
  });
});
