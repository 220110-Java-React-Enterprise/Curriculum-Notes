## Testing in Angular with Jasmine & Karma

Testing often for each feature is important because it helps the design of implementations. It allows for refactoring (changes to pre-existing code). It also helps while adding brand new features since you can ensure you are not breaking any existing code by testing. Tests are also useful documentation and helps make developers more confident about their code. Angular uses the [Jasmine test framework](https://jasmine.github.io/) and [Karma](https://karma-runner.github.io/1.0/index.html), a task runner, for running the tests.

##### Jasmine
Jasmine is a behavior-driven development framework for testing JavaScript code. It does not depend on any other JavaScript frameworks. It does not require a DOM. And it has a clean, obvious syntax so that you can easily write tests.

##### Karma
Karma uses a configuration file in order to set the startup file, the reporters, the testing framework, the browser among other things.

##### Step By Step guide to Component Testing

* Create the function you want to create in the appropriate component.

```typescript
@Component({
  selector: 'lightswitch-comp',
  template: `
    <button (click)="clicked()">Click me!</button>
    <span>{{message}}</span>`
})
export class LightswitchComponent {
  isOn = false;
  clicked() { this.isOn = !this.isOn; }
  get message() { return `The light is ${this.isOn ? 'On' : 'Off'}`; }
}
```
In this case the function is called clicked and it toggles a light switch on and off when the user clicks the button.

* Go to the automatically generated spec.ts file in the component.

```typescript
describe('LightswitchComp', () => {
  it('#clicked() should toggle #isOn', () => {
    const comp = new LightswitchComponent();
    expect(comp.isOn).toBe(false, 'off at first');
    comp.clicked();
    expect(comp.isOn).toBe(true, 'on after click');
    comp.clicked();
    expect(comp.isOn).toBe(false, 'off after second click');
  });

  it('#clicked() should set #message to "is on"', () => {
    const comp = new LightswitchComponent();
    expect(comp.message).toMatch(/is off/i, 'off at first');
    comp.clicked();
    expect(comp.message).toMatch(/is on/i, 'on after clicked');
  });
});
```

Now there is a test for the click function. When testing using Karma, this test should be automatically detected and run.

* Run all tests using 'ng test'
This should run all the tests present and output something similar to below on the console.

```console
10% building modules 1/1 modules 0 active
...INFO [karma]: Karma v1.7.1 server started at http://0.0.0.0:9876/
...INFO [launcher]: Launching browser Chrome ...
...INFO [launcher]: Starting browser Chrome
...INFO [Chrome ...]: Connected on socket ...
Chrome ...: Executed 3 of 3 SUCCESS (0.135 secs / 0.205 secs)
```
A web browser tab should open with the Jasmine HTML Reporter like the picture below.

![](https://angular.io/generated/images/guide/testing/initial-jasmine-html-reporter.png)

Testing of services is similar. For other cases please reference [Angular Docs Extra Testing](https://angular.io/guide/testing#more-information-on-testing)
