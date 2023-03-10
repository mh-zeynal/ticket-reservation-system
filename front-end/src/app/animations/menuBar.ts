import {animate, state, style, transition, trigger} from "@angular/animations";

export const menuBarAnimations = {
  animation: [
    trigger('showHide', [
      state('show', style({
        height: '95vh'
      })),
      state('hide', style({
        height: '75px'
      })),
      transition('show => hide', [
        animate('0.7s ease-in')
      ])
    ]),
    trigger('opacityChange', [
      state('increaseOpacity', style({
        opacity: '1',
      })),
      state('decreaseOpacity', style({
        opacity: '0',
      })),
      transition('increaseOpacity => decreaseOpacity', [
        animate('0.5s 0.5s ease-in')
      ]),
      transition('decreaseOpacity => increaseOpacity', [
        animate('0.5s 0.5s ease-out')
      ])
    ]),
    trigger('displayChange', [
      state('showDisplay', style({
        display: 'inline-flex'
      })),
      state('hideDisplay', style({
        display: 'none'
      })),
      transition('showDisplay => hideDisplay', [
        animate('0.3s ease-in')
      ])
    ])
  ]
}
