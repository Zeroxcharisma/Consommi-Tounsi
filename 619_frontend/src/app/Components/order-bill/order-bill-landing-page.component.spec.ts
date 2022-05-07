import { TestBed } from '@angular/core/testing';
import { OrderBillLandingPage } from './order-bill-landing-page.component';

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [
        OrderBillLandingPage
      ],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(OrderBillLandingPage);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'consomitounsiapp'`, () => {
    const fixture = TestBed.createComponent(OrderBillLandingPage);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('consomitounsiapp');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(OrderBillLandingPage);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('.content span')?.textContent).toContain('consomitounsiapp app is running!');
  });
});
