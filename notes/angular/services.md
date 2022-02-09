## Services

* Services are used to organize and share business logic, models, data, or functions with different components of an Angular application. 
* An Angular service is a singleton instance that can be injected into multiple components, where the component utilizes the functions defined in a service class. This allows us to reuse the code.

The following example illustrates why we need a service. For instance, consider an *EmployeeNames* component that displays the employee names. Here we declare the *employees* object array in the class and display the *name* in the template.

```typescript
@Component({
  selector: 'app-employee-names',
  template:`<div>
  <h2> Employee Names</h2>
  <ul *ngFor = "let emp of employees">
    <li> {{ emp.name }} </li>
  </ul>
</div>`,
  styles: []
})
export class EmployeeNamesComponent {
  public employees = [
    {"id" : 12 , "name" : "Chris", "age" : 22 },
    {"id" : 13 , "name" : "Joseph", "age" : 25 },
    {"id" : 14 , "name" : "Alex", "age" : 35 }
  ];
}
```
Consider a scenario, if we need another component to display the employee list with id, name and age. To do so, we create an *EmployeeList* component and in that component also, we'll have the *employees* object array to display each employee's id, name and age.

```typescript
@Component({
  selector: 'app-employee-List',
  template:`<div>
  <h2> Employee List</h2>
  <ul *ngFor = "let emp of employees">
    <li>{{ emp.id }} - {{ emp.name }} - {{ emp.age }}</li>
  </ul>
</div>`,
  styles: []
})
export class EmployeeNamesComponent {
  public employees = [
    {"id" : 12 , "name" : "Chris", "age" : 22 },
    {"id" : 13 , "name" : "Joseph", "age" : 25 },
    {"id" : 14 , "name" : "Alex", "age" : 35 }
  ];
}
```

Here, we are repeating the same *employees* object code in the two components. Also, the component is only responsible for controlling the view's logic, but in our case, it is also responsible for creating data *employees* object. 

So, components can delegate these tasks to services. A service is a class that is used to share data across the multiple components, to implement the application logic, and for external communication.

In Angular, we have a file with ***.service.ts** extension where we define the service class. In that class, we can have a *employees* object code, which later can be injected into the components. We use a **Dependency Injection framework** to inject the service into components in our application.

## Dependency Injection (DI)

**DI as a design pattern** - Consider, we have three classes *Engine*, *Tires*, and *Car*. Let's assume, we need an *Engine* instance and a *Tires* instance to create a *Car* instance. So, the *Car* class has two dependencies - *Engine* and *Tires*.
```typescript
Class Engine{
    constructor(){}
}
Class Tires{
    constructor(){}
}
Class Car{
    engine;
    tires;
    constructor()
    {
        this.engine = new Engine();
        this.tires = new Tires();
    }
}
```
The *Engine* and *Tires* are tightly coupled to the *Car*. For instance, Whenever we change the *Engine* and *Tires* class definition, then we need to manually change the *Car* Class definition.  This problem can be solved by using the **Dependency Injection** design pattern. 

Have a look at this code making use of the **Dependency Injection** design pattern. Instead of creating an instance of the *Engine* and *Tires* classes inside the *Car* constructor, we assign references to passed-in *Engine* and *Tires* objects.
```typescript
Class Car{
    engine;
    tires;
    constructor(engine, tires)
    {
        this.engine = engine;
        this.tires = tires;
    }
}

var engine1 = new Engine(newparameter);
var engine2 = new Engine();
var tires = new Tires();

var myCar = new Car(engine1, tires);
var otherCar = new Car(engine2, tires);
```
**Dependency Injection** allows the class to receive its dependencies from external sources rather than creating them itself.

With DI, we create a *Car* instance by passing the dependencies as parameters. Here the *Car* has only 2 dependencies (*Engine* and *Tires*), but what if the *Car* 10 or 20 dependencies? Then, we would have to create an instance for each of those dependencies before passing them as parameters. And if these dependencies in turn had dependencies on something else then we would have to create *those* dependencies. As the number of dependencies grows, it rapidly becomes difficult to manage the code.

To overcome this, we use **Dependency Injection as a Framework** in Angular. A DI framework uses an **Injector** where we register all those dependencies to be managed. If we need a *Car* instance, the injector will provide the  *Car* instance. The injector is responsible for creating service instances and injecting them into components. 

> **NOTE -** In Angular, dependencies are typically services.

## Using a Service

![](./../images/services.png)


The Injector holds all the services, and registers them at the NgModule or component level based on their **provider**. A provider tells where in our application to register the service. The registered service can be accessed using a **DI token**. A DI token is a lookup key for the registered services. 

The `@Injectable()` decorator marks a class as a service class that can be injected. The `@Injectable()` decorator has a `providedIn` property where we specify the **provider** of the decorated service class with the 'root' as a default, or any other module of our application.

**Example:**

Here, we create an Employee Service that shares the employee object array with the *EmployeeList* and *EmployeeDetail* component.

Run the `ng g s employee` command in the CLI, which creates *employee.service.ts* file and *employee.service.spec.ts* file under src/app folder.

In *employee.service.ts* file, you have a basic structure for an angular service.
```typescript
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor() { }
}
```
An injector provides a **singleton instance of a service**, and can inject this same instance into multiple components. 

A **hierarchy of injectors** at the NgModule and component level can provide different instances of a services to their own components and child components. We can configure injectors with different providers that can provide different implementations of the same services.

If we register the service in the EmployeeListComponent, then the service can be used by EmployeeListComponent and its child components. Other components in our application, can't use this service. If we register the service in the *AppModule*, then the service can be used by all the components in our application.  To register the service, we use `providedIn` property in the `@Injectable()` decorator. 

By default, AngularCLI sets the `providedIn` to 'root' registers the service at the module level.

```
 AppModule <-- EmployeeService 
     |
 AppComponent
     |
     | -----> EmployeeNamesComponent
     |
     | -----> EmployeeListComponent
```

**employee.service.ts** - Here we return the employee object array in the getEmployees(). After injecting this service into the EmployeeListComponent and EmployeeNamesComponent, both can call the `getEmployees()` method which returns employee object array.  
```typescript
@Injectable({ providedIn: 'root' })
export class EmployeeService {
   getEmployees() : object {
    return [
      {"id" : 12 , "name" : "poko", "age" : 22 },
      {"id" : 13 , "name" : "Joseph", "age" : 25 },
      {"id" : 14 , "name" : "Alex", "age" : 35 }
    ];
  }
}
```
When we create an instance of EmployeeService class, Angular injects the *EmployeeService* into that commponent. Here, `_employeeService` is used as a lookup key for the
EmployeeService.

```typescript
 _employeeService : EmployeeService
```
In the EmployeeNamesComponent, we return the employee object array by calling `_employeeService.getEmployees()` method definied inside the *EmployeeService*. Similarly we can access the employee object array in the EmployeeListsComponent. By doing so, EmployeeNamesComponent and EmployeeListsComponent controls only the view logic. 

```typescript
@Component({
  selector: 'app-employee-names',
  template:`<div>
  <h2> Employee Names</h2>
  <ul *ngFor = "let emp of employees">
    <li> {{ emp.name }} </li>
  </ul>
</div>`,
  styles: []
})
export class EmployeeNamesComponent {
    public employees:object =[];
    constructor(private _employeeService : EmployeeService){
            this.employees = _employeeService.getEmployees();
  }
}   
```


## References

* [Angular Docs - Dependency injection in Angular](https://angular.io/guide/dependency-injection)
