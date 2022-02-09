## Angular Directives

Angular directives allow us to manipulate the DOM. The directive is a marker on a DOM element that tells Angular to change the appearance, behavior, and layout of the DOM element and its children.  In Angular, most directives begin with ng, where ng stands for Angular, and extend the HTML. 

### Types of Directive 

There are three kinds of directives in Angular:

1. **Component Directives** - Component directives alter the details of how the component should be processed, instantiated, and used at runtime. 

2. **Structural Directives** - Structural directives are used to manipulate and change the structure of the DOM elements. 

3. **Attribute Directives** - Attribute directives are used to change the look and behavior of the DOM elements.

## Structural directives

Structural directives are used for adding, removing, or manipulating DOM elements. Structural directives start with an asterisk (*) followed by a directive name.  There are three built-in structural directives - **ngIf**, **ngFor** and **ngSwitch**.

### ngIf Directive

The `*ngIf` directive allows us to add or remove DOM Elements based upon the Boolean expression. It doesn't hide the elements, but generally adds or removes them physically from the DOM.

*Example:* 
```html
<p *ngIf="true">
  Expression is true, this paragraph is in DOM.
</p>
<p *ngIf="false">
  Expression is false, this paragraph is not in DOM.
</p>
```
We can also have an **else block** associated with an `*ngIf` directive.

*Example:*
```html
<div *ngIf="5>10; else elseBlock">  
5 is greater than 10....
</div>  
<ng-template #elseBlock>  
10 is greater than 5... 
</ng-template>  
```

### ngFor Directive

 The `*ngFor` directive is used to repeat a part of the HTML template once per each item from an iterable list.

 For example, we can iterate an array items defined in *app.component* class.
 ```typescript
 import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  customers : Customer[] = [
    {id : 234 , name: 'John'},
    {id : 235 , name: 'Adam'},
    {id : 236 , name: 'Nick'}
  ];
}
class Customer { 
  id :number;
  name: string;
} 
```
In app. component.html, iterate over the *customers* object using `*ngFor` directive.
```html
<tr *ngFor="let customer of customers;">
  <td>{{customer.id}}</td>
  <td>{{customer.name}}</td>   
</tr>
```

### ngSwitch Directive

The Angular *NgSwitch* has a set of cooperating directives: **NgSwitch**, **NgSwitchCase**, and **NgSwitchDefault**.

The syntax for `ngSwitch` Directive:
```html
<container_element [ngSwitch]="switch_expression">  
    <inner_element *ngSwitchCase="match-1">...</inner_element>  
    <inner_element *ngSwitchCase="match-2">...</inner_element>  
    <inner_element *ngSwitchCase="match-3">...</inner_element>  
    <inner_element *ngSwitchDefault>...</inner_element>  
</container_element>
``` 
*NgSwitch* is an attribute directive that controls the behavior of the other two switch structural directives - *NgSwitchCase* and *NgSwitchDefault*. That's why we write *NgSwitch* as `[ngSwitch]`, *NgSwitchCase* as `*ngSwitchCase`, and *NgSwitchDefault* as `*ngSwitchDefault`.

*NgSwitchCase* displays its element when its value matches the switch value. *NgSwitchDefault* displays its element when no sibling *NgSwitchCase* matches the switch value.

*Example:*
```html
<div class = 'input-num'>
Enter the number<input type='text' [(ngModel)]="num" />
</div>
<div [ngSwitch]="num">
  <div *ngSwitchCase="'1'">You entered - One</div>
  <div *ngSwitchCase="'2'">You entered - Two</div>
  <div *ngSwitchCase="'3'">You entered - Three</div>
  <div *ngSwitchCase="'4'">You entered - Four</div>
  <div *ngSwitchCase="'5'">You entered - Five</div>
  <div *ngSwitchDefault> ...default </div>
</div>
```


### `<ng-template>`  

Structural directives can work with the HTML5 `<ng-template>` element, which is designed to hold template code. 

*Example:*
```html
<ng-template [ngIf]='true'>
  <p>I am the content to show</p>
</ng-template>
```

## Attribute Directives

Attribute directives are used to change the look and behavior of the DOM elements.There are two built-in attribute directives - **ngClass** and **ngStyle**.

### ngClass Directive

The `[ngClass]` directive is used for adding or removing the CSS classes on an HTML element. It allows us to apply CSS classes dynamically based on expression evaluation. 

**Syntax:** `<some-element [ngClass]="value"> ....</some-element>`

The value can be 
* **string** - the CSS classes declared as string. For example, `<some-element [ngClass]="'first second'">...</some-element>` where `first` and `second` are the two CSS Classes delimited by space. Both the `first` and `second` CSS style will be applied to the element.

* **Array** - the CSS classes declared as Array elements. For example,`<some-element [ngClass]="['first', 'second']">...</some-element>` 

* **Object** - in which *keys* are CSS classes and *values* are expression that  evaluates true or false.  The CSS Class applied to the element when the expression evaluates a truthy value, else they will be removed. For example,`<some-element [ngClass]="{'first': true, 'second': true, 'third': false}">...</some-element>`

**Example:**
The CSS classes in the *app.component.css* file:
```css
.red { 
    background-color: red;
}
.size20 {
    font-size: 20px; 
    font-style: italic;
}
```
Using `[ngClass]` directive in the *app.template.html* file, to add or remove CSS Classes on the element.
```html
<h3 [ngClass]="'red'"> Need your attention</h3>
<div [ngClass]="['red','size20']"> Red Background, Text with Size 20px  </div>
<div [ngClass]="{'red':false,'size20':true}">Text with Size 20px</div>
 ```

### ngStyle Directive

The `[ngStyle]` directive allows us to dynamically change the style of HTML element based on the expression.

**Syntax:** `<some-element [ngStyle]="objExp">...</some-element>`

**Example:**
```html
Enter the username: <input type = 'text' [(ngModel)] = 'name'>
<div [ngStyle]="{'background-color':username === 'Admin' ? 'green' : 'red' }"></<div>
```

### Custom Directives

We can create our custom directives to use in the Angular component with the CLI command `ng generate directive <name of the directive>`.

**For example**, When we run this command `ng generate directive text` in a terminal, the CLI creates *text.directive.ts* file and corresponding test file *text.directive.spec.ts* under *src/app* folder in our application. Also, CLI declares this directive class under *AppModule*.

Lets have a look at text.directive.ts file.
```typescript
import { Directive} from '@angular/core';

@Directive({
  selector: '[appText]'
})
export class TextDirective {
	//You can add custom styling of DOM Elements here....
    constructor() {
    
    }
}
```

Then, you use this directive in the template of the root AppComponent and apply the directive as an attribute. 

For Example: `<p appText> Text inside....</p>`

## References
* [Angular Docs - Attribute directives](https://angular.io/guide/attribute-directives)
* [Angular Docs - Structural directives](https://angular.io/guide/structural-directives)
