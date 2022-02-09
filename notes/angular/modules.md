# Modules
## @NgModule

Every Angular application consists of at least one module, the root module. We bootstrap that module to launch the application.

NgModules are TypeScript classes decorated with the [@NgModule](https://angular.io/api/forms/NgModel) decorator imported from the `@angular/core` package.

NgModule takes metadata and describes how to compile a component's template and how to create an injector at runtime. It identifies the module's own components, directives, and pipes and makes them public through the export property which can be used by external components.

The Angular CLI generates the basic *AppModule* (src/app/app.module.ts file) when creating a new application.

```typescript
// imports
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

// @NgModule decorator with its metadata
@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
```

`@NgModule` takes the below metadata to launch the application:

* **declarations** —  contains a list of components, directives, and pipes, which belong to this module. 

* **imports** —  contains a list of modules, which are used by the component templates in this module reference.  For example, we import *BrowserModule* to have browser-specific services such as DOM rendering, sanitization, and location. 

* **providers** — the list of service providers that the application needs.

* **bootstrap** — contains the root component of the application

Angular CLI creates an application with one component (AppComponent), so it is in both the declarations and the bootstrap arrays.

## Bootstrapping in Angular:

The steps involved in starting an angular application:

* The *main.ts* is an entry point of an angular application.
* Then, we bootstrap an angular application and we pass *app.module.ts* as an argument. In *app.module.ts*, we tell the Angular to bootstrap the *AppComponent*.
* Then, Angular analyzes this *AppComponent* and knows there is an `app-root` selector defined.
* Now, Angular able to handle `app-root` in the *index.html* file.
* Finally, the *index.html* file is loaded on the browser.

## References

* [Angular Docs - NgModules](https://angular.io/guide/ngmodules)
* [Angular Docs - Launching your app with a root module](https://angular.io/guide/bootstrapping)
