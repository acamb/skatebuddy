import {animate, group, state, style, trigger, transition, stagger, query} from "@angular/animations";

export const animations =
  trigger('routeAnimations', [
    transition('* => *', [
        query('div',[
        style({opacity: 0, transform: 'translateY(100px)'}),
        stagger(-10, [
          animate('400ms cubic-bezier(1, 0.70, 0.85, 1)', style({opacity: 1, transform: 'none'}))
        ])
      ],{optional: true})])
    ])

