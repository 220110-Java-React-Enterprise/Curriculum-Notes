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


# HTML5 Semantic Elements

Semantic Elements defines the meaning for the web page rather than just presentation.


* The HTML elements like `<div>` and `<span>` are not releated to the content on the web page. This kind of elements are called as non semantic elements.
* The HTML elements like `<form>`, `<table>`, and `<article>` are used to define the content and  on the webpage. This kind of elements are called as semantic elements.

We will disscus about the following semantic elements that helps to define the element's purpose on the webpage:

```
<section>
<article>
<header>
<footer>
<nav>
<aside>
<figure>
<figcaption>
<details>
<mark>
<summary>
<time>
```

### Section

The HTML5 `<section>` tag defines a thematic grouping of content. In a document, we have sections like chapters, headers, footers, introduction, content, contact information, etc. 

*Example*
```
<section>
  <h1>Protocol</h1>
  <p>A protocol is a standard set of rules that allow electronic devices to communicate with each other.</p>
</section>
```

### Article

 The `<article>` element represents a section of content that forms an independent part of a document or site such as  Forum post, Blog post, Newspaper article, etc.,

*Example*
```
<article>
  <h1>What WHO do?</h1>
  <p>WHO works worldwide to promote health, keep the world safe, and serve the vulnerable. Our goal is to ensure that a billion more people have universal health coverage, to protect a billion more people from health emergencies, and provide a further billion people with better health and well-being..</p>
</article>
```

### Header

 The `<header>` element specifies a header for a document or section.

*Example*
```
<!-- example defines a header for an article -->
<article>
  <header>
    <h1>World Health Organisation</h1>
    <p>What we do?</p>
  </header>
  <p>WHO works worldwide to promote health, keep the world safe, and serve the vulnerable. Our goal is to ensure that a billion more people have universal health coverage, to protect a billion more people from health emergencies, and provide a further billion people with better health and well-being..</p>
</article>
```

### Footer

The `<footer>` element used to define the footer for a document or section. It contains information about the author of the document, copyright information, links to terms of use, contact information, etc.

*Example*
```
<footer>
  <p>Posted by: someone </p>
  <p>Contact information: <a href="mailto:someone@example.com">
  someone@example.com</a>.</p>
</footer>
```

### Navigation

The `<nav>` element is for major navigation blocks that specify a set of navigation links. 

*Example*
```
<nav>
  <a href="/html/">HTML</a> |
  <a href="/css/">CSS</a> |
  <a href="/js/">JavaScript</a> |
  <a href="/jquery/">jQuery</a>
</nav>
```

### Aside

The `<aside>` element is used to identify content that is related to the primary content of the web page. The content inside the `<aside>` element does not constitute the primary content of the page. For example, we can have author information, related links, related content, and advertisements.

*Example*
```
<p>I went TajMahal for this summer</p>

<aside>
  <h4>Taj Mahal</h4>
  <p>The Taj Mahal is an ivory-white marble mausoleum on the south bank of the Yamuna river in the Indian city of Agra.</p>
</aside>
```

### HTML figure and figcaption Elements

The `<figure>` element describes some flow content, optionally with a caption, that is self-contained and referenced as a single unit from the main flow of the document. The `<img>` and `<figcaption>` elements are grouped in a `<figure>` element. We use the `<img>` element to insert an image on the web page. To add the visual explanation of the image, we need a caption for that image. This can be achieved in the HTML5 by using `<figcaption>` element.

*Example*
```
<figure>
  <img src="WorldMap.jpg" alt="WorldMap">
  <figcaption>Fig1. - World Map </figcaption>
</figure>
```

### Other HTML Elements

* `<details>` - Used to add details that user can view or hide
* `<mark>` - Used to highlight or mark the text.
* `<summary>` - Defines a obvious heading for a `<details>` element
* `<time>` - Used to add a date/time. 


# HTML5 Audio tag

The HTML5 `<audio>` element used to embed audio in a web page.

**Example**
```
<body>

<h1>The audio element</h1>
<p>Click the Play button:</p>
<audio controls>
  <source src="River.ogg" type="audio/ogg">
  Invalid audio!!! - Browser doesn't support. 
</audio>

</body>
```
In the above example, we have two tags, `<audio>` and `<source>`. 

The `<audio>` element defines sound content and it has a *controls* attribute that adds audio controls, like play, pause, and volume. Any text within the `<audio>` and` </audio>` displayed on the browser only if the audio was not supported by the browser.

The `<source>` element defines the media resources for the audio files and it has attributes such as *src* and *type*. The *src* is used to specify the file format of the audio content and *type* specifies the media types that `<audio>` element supports.

The file format supported by `<audio>` element and respective media types are tabulated below: 

|File Format| Media Type|
| ------ | ------ |
|MP3| audio/mpeg|
|OGG| audio/ogg|
|WAV| audio/wav|


# HTML5 Video tag

The `<video>` element used to embed a video on a web page, such as a movie clip or other video streams.

**Example**
```
<body>

<h1>The video element</h1>
<video width="320" height="240" controls>
  <source src="movie.mp4" type="video/mp4">
    Invalid audio!!! - Browser doesn't support. 
</video>

</body>
```
HTML5 Video Attributes used in the above example are described below:

|Attribute| Value|  Description|
|-----|----|----|
|src  |URL| Specifies the URL of the video file|
|controls|  controls| Specifies the video controls such as a play/pause button, etc|
|height |pixels |Sets the height of the video player|
|width| pixels| Sets the width of the video player|

> Note: Any text between the `<video>` and `</video>` tags will be displayed in browsers that do not support the `<video>` element. 

The MIME Types  supported by the `<video>` element is tabulated below: 

|Format|  MIME-type|
|-----|----|
|MP4  |video/mp4|
|WebM |video/webm|
|Ogg  |video/ogg|

# HTML5 Validation

When we submit a form, the data in the form will be sent to the server, before that we need to make sure that all the required details are filled out also in the correct format. The process of ensuring or validating the data before submitting to the server is called Client-side form validation.

Let us discuss form validation. For example, we submit any registration form, we may come across such messages listed below :

* "This field is required" (it can't be blank).
* "Please enter the valid phone number" (it should contain the only number).
* "Invalid email address" (it should be in "lmn@asd.com" format).
* "Your password must include one number, one uppercase letter, one lowercase letter, and one special character".

The browser displays the above messages by validating the data entered the registration form. It checks whether the data is in the correct format and satisfies the constraints set by the application or not. If the browser validates the data, then it is called as *client-side validation*. Validation done by the server is called as *server-side validation*.

There are two different types of client-side validation. 

1. **Built-in form validation** - It uses HTML5 form validation features.
2. **JavaScript validation** - It is coded using JavaScript. This validation is completely customizable.

### Built-in form validation

We have attributes that can be used with the form elements for validation. Some of the attributes are listed below:

* **required**: Used when the user must fill the field before submitting the form.
* **minlength and maxlength**: Used to specify the minimum and maximum length of the text.
* **min and max**: Used to specify the min and max values for the numerical fields.
* **type**: Defines the data should be a number or an email address or other predefined type. 
* **pattern**: Defines a pattern (regular expression) the entered data needs to follow. 

If the data entered in a form satisfies the constraints are considered **valid**. If not, it is considered **invalid**. We use `: valid` and `: invalid` CSS  pseudo-class to differentiate between valid and invalid input fields. The`:invalid` CSS pseudo-class used to select and style form `<input>` elements whose value is *invalid* according to the validation attributes specified in the `<input>` element. Similarly, the `:valid` CSS pseudo-class selects and styles the vaild form input elements.

For example, the email inputs` (<input type="email">)` whose value does not match a valid email address pattern then the style defined by the `: invalid` CSS pseudo-class. Below, we have HTML and CSS code for this example.

```
HTML:

 <form> 
     <label>
        <span>Email:</span>
        <input type="email" id="email" placeholder="name@domain.com">
    </label>
</form> 

CSS:

//:valid
.valid {
    input[type=email]:valid { border-color: $g; }
}
//:invalid
.invalid {
    input[type=email]:invalid { border-color: $r; }

```


