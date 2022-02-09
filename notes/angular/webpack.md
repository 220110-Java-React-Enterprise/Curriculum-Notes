## Webpack

In our web application, we use many javascript files that are added into the HTML pages via `<script>` tags.  For each user request, the browser loads these bunch of script files inside the HTML page. This is inefficient as it reduces the page speed since the browser requests each script file separately.

This can be solved by **bundling** several files together into one file to be downloaded by the browser in one single request.

**Module bundlers** are used to bundle a group of JavaScript modules with their dependencies and merge them into a single file in the correct order, which can be executed by the browser.

[Webpack](https://webpack.js.org/) is a powerful static module bundler for JavaScript applications that packages all modules in our application into a bundle and serves it to the browser.

Webpack builds a [dependency graph](https://webpack.js.org/concepts/dependency-graph/) when it processes the application. It starts from a list of modules defined in its config file (`webpack.config.js`) and recursively builds a dependency graph that includes every module our application needs, then packages all of those modules into a small bundle that can be loaded by the browser.

## References

* [WebPack Docs](https://webpack.js.org/concepts/)
