## Single Page Application

A [Single Page Application](https://en.wikipedia.org/wiki/Single-page_application#:~:text=A%20single%2Dpage%20application%20(SPA,browser%20loading%20entire%20new%20pages.)) (SPA) is a web application that fits on a **single page in the browser**. All our JavaScript, HTML, CSS code retrieved by the browser with a **single page load**. Navigation between pages performed **without refreshing the whole page**. SPA uses AJAX and HTML5 to build responsive web applications. 

**Examples of single-page apps** - Gmail, Google Maps, Facebook, Twitter, Trello, etc.,

**Advantages of SPAs**

* **Fast and responsive** -  SPAs update only the required content instead of the entire page for each request to the server.  The HTML/CSS/Scripts are only loaded once throughout the lifespan of an application. Only data is transmitted back and forth. This significantly improves the website’s speed.

* **Caching capabilities** - SPA sends a request to the server and caches all received data locally. Then it can reuse this data and work even offline. If a user has poor connectivity, local data can be synchronized with the server when the connection allows.

* SPA provides a **pleasant user experience** on desktops as well as on mobile phones, since it only changes the content and not the page.

**Disadvantages of SPAs**

* Doesn’t Perform Well With **SEO** ([Search engine optimization](https://en.wikipedia.org/wiki/Search_engine_optimization)).
* **Security** - SPAs are less secure towards [Cross-site scripting](https://en.wikipedia.org/wiki/Cross-site_scripting) (XSS) attacks.
* While overall performance is better, more data is frontloaded which can make the first page load a little slower


Frameworks like AngularJS, Angular, Ember.js, ExtJS, Knockout.js, Meteor.js, React and Vue.js uses SPA principles to create a web application.

## References

* [What Is a Single Page Application and Why Do People Like Them so Much?](https://www.bloomreach.com/en/blog/2018/07/what-is-a-single-page-application.html)
* [Video Tutuorial- SPA](https://www.youtube.com/watch?v=F_BYg2QGsC0)
