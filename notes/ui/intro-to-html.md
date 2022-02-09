# Introduction to HTML

[HTML](https://en.wikipedia.org/wiki/HTML) stands for Hypertext Markup Language - it is a markup language for creating web pages and applications. HTML contains a particular syntax - namely **elements** and **attributes** - that web browsers parse in order to render the content of the webpage. With HTML, the structure and content of a webpage is defined. Styling and dynamic behavior are introduced with CSS and JavaScript, respectively.

### Elements

HTML is composed of many different **elements** - these provide the structure of the document. Elements are defined within HTML files using **tags** - for example, one very common tag is the `<div>` tag. The tag is enclosed within angle brackets. Most elements have a closing tag which define the end of the element, using the backslash notation - for example, a closing "div" tag would be `</div>`. HTML elements may be *nested* within other elements, like so:

```html
<div> text inside the div but outside the paragraph
  <p> this text is inside the paragraph </p>
</div>
```

In order for HTML to be **valid**, tags must be properly nested - an outer tag cannot be closed before an inner one. For example, the following markup would not be considered valid:

```html
<div> invalid!
  <p> cannot close the div here => </div>
</p>
```

Not all elements have closing tags, some are self-closing. For example, the `<img />` tag, which defines an image.

### Attributes

HTML elements can also have **attributes** defined within the tag - these are key/value pairs that give metadata about the tag that are important for the browser to know. For example, image elements must have a URL which the browser can call to retrieve the image file to display on the page - we use the `src` attribute to do this: `<img src="/URL/to/get/cat.png" alt="cool cat!" />`. As you may have guessed, the `alt` attribute specifies an alternative text to show when the image cannot be displayed.

#### Global Attributes

**Global** attributes are those that can be applied to any element on the page. Some important global attributes are:

* class
* id
* hidden
* lang
* style
* tabindex
* title

There are also many attributes that should be applied to only certain elements, including the `src` and `alt` attributes shown above. We'll discuss more about these when relevant.

## Starting HTML Documents

Every HTML document (ending with `.html` extension) should begin with a special tag known as the DOCTYPE declaration - this lets browsers know what kind of document it is using (HTML, in our case) as well as which version of the markup language is being used. For HTML5, the newest version and the one which we'll be using, the DOCTYPE syntax is:

```html
<!DOCTYPE html>
```

The doctype declaration tag does not have a closing tag and it is not self-closing either.

Next, the tag which begins the root of our HTML document is the `<html>` tag. Everything about our webpage will be nested within this tag.

Within the `html` element we have two important tags - the `<head>` and the `<body>` tags. The `head` element will contain all the metadata associated with this page, including the title, character encodingg, and references to external stylesheets. The `body` element contains the actual content of our page that will be rendered on the screen by the browser.

### Hello World Example

Let's write a simple webpage that will show off our knowledge of HTML thus far. Open up a new file in a simple text editor and save the file as `hello-world.html`. Then write the following HTML markup and save it:

```html
<!DOCTYPE html>
<html>
  <head>
    <title>Hello World!</title>
    <meta charset="utf-8">
  </head>
  <body>
    <div>
      <!-- THIS IS A COMMENT! -->
      <p>This is my first paragraph written in HTML</p>
    </div>
  </body>
</html>
```

The only tag you may be unfamiliar with is the `meta` tag above - this defines the character encoding that the file will be using. Also, the `<!-- ... -->` syntax denotes a comment.

If you now open your `hello-world.html` file in your browser of choice, you'll see your webpage rendered. It may look ugly now, but we'll address that when we talk about CSS.

### Common HTML elements

Before listing all the HTML elements available to use, it's important to know the difference between **inline** and **block**-level elements. Block-level elements are those that will render on new lines in blocks by default, instead of rendering within the line itself like inline elements do. One example of a block element is `<div>`, and a common inline element is `<span>`. Try them out on your webpage and notice the difference. 

There are a vast number of HTML elements you could use on your webpage, but below are listed the most common:

* `<div>` - defines a "division of the page"
* `<p>` - defines a paragraph
* `<span>` - an inline tag for grouping text or elements
* `<b>` - bold text
* `<i>` - italicized text
* `<h1>`, `<h2>`, ... `<h6>` - these are headings, h1 is largest and h6 is smallest
* `<br>` - line break
* `<table>` - defines a table
* `<img src="URL">`
* `<ol>` - an ordered list
* `<ul>` - an unordered list
* `<a href="">` - makes a hyperlink

#### Hyperlinks

To make a hyperlink in a webpage, use the `<a>` tag:

```html
<p> Here is a <a href="www.google.com">link to Google!</a></p>
```

#### Tables

To create a table, use the following markup. `<tr>` defines a table row, `<td>` defines a table cell, and `<th>` is used for table headers.

```html
<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Name</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>1</td>
      <td>Alice</td>
    </tr>
    <tr>
      <td>2</td>
      <td>Bob</td>
    </tr>
    <tr>
      <td>3</td>
      <td>Charlie</td>
    </tr>
  </tbody>
</table>
```

#### Lists

There are two options for making lists in HTML - ordered or unordered lists. Ordered lists are defined with `<ol>`, unordered lists are defined with `<ul>`, and the list items within either are denoted with `<li>`:

```html
<ol> <!-- ordered lists render as 1, 2, 3, etc.. -->
  <li>First item</li>
  <li>Second item</li>
  <li>Third item</li>
</ol>
<ul> <!-- list items in here will just be bullet points -->
  <li>First item</li>
  <li>Second item</li>
  <li>Third item</li>
</ul>
```

# HTML5

HTML5 introduced a new **DOCTYPE** declaration `<!DOCTYPE html>` and the character encoding (charset) declaration `<meta charset="UTF-8">`.  The `<DOCTYPE>` declaration is used to inform the browser about the version of HTML used in the document. It is known as the Document Type Declaration (DTD). It just instructs the browser about the document type. A **character encoding** is an approach of converting bytes into characters. For validating the HTML document, a program must choose a character encoding.

HTML5 also introduced features to allow us to embed audio and video files on the web page and provides the support to run JavaScript in the background.

Take a look at the structure of the HTML5 file given below:

```
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Title of the document</title>
  </head>

  <body>
    Content of the document......
  </body>
</html>
```

> **NOTE:** HTML5 uses UTF-8 as a default character encoding.

> `<!DOCTYPE html>` should be in the beginning of the document before any tags.


## Helpful Resources

* [Mozilla](https://mdn.dev)
