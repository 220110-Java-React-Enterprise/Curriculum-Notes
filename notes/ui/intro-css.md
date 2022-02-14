# Overview of CSS

CSS stands for **Cascading Style Sheets** - it is a language for styling HTML documents by specifying certain rules for layout and display in key/value pairs. Style Sheets are a simple and powerful method of allowing attachment of rendering information to HTML documents. It used to style the webpages by setting background-color, font color, font size, font family, etc.

A CSS consists of a *set of rules* that defines the styles for a web page. A CSS style rule composed of **selectors** and **declarations**. The selector is an HTML Element *like h3 used in the below example*. The declaration is comprised of a property and a value surrounded by curly braces. In the below example font-family, font-style and color were properties of the selector h3. Arial, italic and red were the values assigned, respectively, to the properties.

*Example:*
 ```  
    h3 { 
        font-family: Arial; 
        font-style: italic; 
        color: red 
        }
```

# CSS Box Model

The CSS box model used to determine how our web page is rendered by browser. It considers each element on the page as a box, CSS allows you to apply different properties that define where and how that element appears. Web pages are made up of rectangular boxes arranged and related to each other. 

![Box model](https://upload.wikimedia.org/wikipedia/commons/e/ed/Box-model.svg)

Every box has 4 parts - **margin**, **border**, **padding** and **content**. The margin is an outermost box,  inside that the border, then padding, then the content is innermost. All box sizes/formatting can be styled with CSS.

**Margin**  -   It is a space between border and margin. It is useful to separate the element from its neighbors. The dimensions are given by the margin-box width and the margin-box height. 

**Border** -  It is the area between the box’s padding and margin. Its dimensions are given by the width and height of the border.

**Padding** -  It is a space around the content area and within the border-box. Its dimensions are given by the width of the padding-box and the height of the padding-box.

**Content** -  It consists of content like text, image, or other media content. It is bounded by the content edge and its dimensions are given by content-box width and height.

# Types of CSS

There are three types of CSS which are given below: 
* Inline CSS
* Internal or Embedded CSS
* External CSS

### Inline CSS

Inline CSS contains the CSS property in the body section attached with element is known as inline CSS. This kind of style is specified within an **HTML tag using style attribute**. 

**Example:**

    <!DOCTYPE html> 
    <html> 
    <head> 
        <title>Inline CSS</title> 
    </head> 
    <body> 
        <p style = "color:#009900; 
		   font-size:50px; 
           font-style:italic; 
           text-align:center;">
			            Hello World
	       </p> 
    </body> 
    </html>  
     
### Internal or Embedded CSS

This can be used when a single HTML document must be styled  **uniquely**. The CSS rule set should be within the HTML file in the *head section* i.e the CSS is embedded within the HTML file.

**Example:**
 ```  
    <!DOCTYPE html> 
    <html> 
    <head> 
        <title>Internal CSS</title> 
        <style> 
            .main { 
                text-align:center;  
            } 
            .hi{ 
                color:#009900; 
                font-size:50px; 
                font-weight:bold; 
            } 
            .greeting { 
                font-style:bold; 
                font-size:20px; 
            } 
        </style> 
    </head> 
    <body> 
        <div class = "main"> 
            <div class ="hi"> Hi, Everyone!!</div>   
            <div class ="greeting"> 
                Hello World!! 
            </div> 
        </div> 
    </body> 
    </html>  
 ```           

### External CSS

External CSS contains separate CSS file which contains only style property with the help of tag attributes (For example class, id, heading, … etc). CSS property written in a separate file with .css extension and should be linked to the HTML document using **link** tag. This means that for each element, style can be set only once and  that will be applied across web pages.
 
**Example:** The file given below contains CSS property. This file should be saved with an .css extension. For Ex: **style.css**

```
    body {
	    background-color:powderblue;
	    }
	.main {
	    text-align:center;
	    }
	.hi {
		color:#009900;
	    font-size:50px;
	    font-weight:bold;
	    }
	#greeting {
	    font-style:bold;
	    font-size:20px; 
	    }
```

Below, we have HTML file that makes use of the above created external style sheet (style.css). This can be achieved by using `<link>` tag. The `<link>` element has *rel* and *href* attributes. The *rel* specifices the relationship between the current document and the linked document. In this case, *rel* attribute value will be *stylesheet* because we going to add the external style sheet to the HTML document. The *href*  attribute is used to specify the location of the external style sheet file.

```
    <html>
        <head> 
            <link rel="stylesheet" href="style.css"/> 
        </head> 
        <body> 
            <div class = "main"> 
                <div class ="hi"> Hi, Everyone !</div> 
                <div id = "greeting "> 
                    Hello world !!
                </div> 
            </div> 
        </body> 
    </html> 
```
# CSS Properties

There are a number of CSS properties that you can use to style our webpage. Here we'll discuss some of the CSS properties such as Border, Padding, Margin, display, position, color,and text-align.

### CSS Border Property
  
The CSS border property allows to style the border area of a box. The properites and corresponding vlaues with examples covered under the CSS border are tabulated below:

|Property| values| Usage| Example|
|---|---|---|---|
|border-width| medium, thin, thick, length | Used to define the border area of a box|```div { border-width: medium 10px thick 15px; }```|
|border-style| none, hidden, dashed, dotted, double, groove, inset, outset, ridge and solid | sets the style of a box's border |```p { border-style: dotted; }```|
|border-color| hex-value for colors| specify the color of a box's border |```p { border-style: solid;  border-color: #ff0000; } ```|

### CSS Padding Property

The CSS padding property allow you to set the padding area for an element that separates its border from its content. The padding property can take one, two, three, or four  values separated by white spaces as listed in the below table. Depending on the list of property values, the HTML element has the padding area on the top, bottom, right, and left.

|Examples| Explanation|
|------|-----|
|`p { padding: 70px; }`| Sets the padding for an `<p>` element to 70 pixels for all four sides |
|`p { padding: 35px 70px; }`|Sets the padding for an `<p>` element to 35 pixels for top and bottom and 70 pixels for right and left sides.|
|`p { padding: 35px 70px 40px; }`|Sets the padding for an `<p>` element to 35 pixels for the top, 70 pixels for the left and right side and 40 pixels for the bottom. |
|`p { padding: 35px 70px 40px 80px; }`| Sets the padding for an `<p>` element to 35 pixels for the top, 70 pixels for the right side, 40 pixels for the bottom and 80 pixels for the left side.|

The padding property is a shorthand property for the padding-top, padding-right, padding-bottom, and padding-left properties. The below examples set padding on a specific side for the HTML element.

*Examples*:
```
h1 { 
	padding-bottom: 10px; 
} 
p { 
	padding-top: 20px; 
	padding-left: 50px;
 }
```

### CSS Margin Property

The CSS margin property is similar to the CSS border property,  but it sets the margins around the sides of an element's box instead of the border. It also takes one, two, three, or four values separated by white spaces. 
The shorthand properties are margin-top, margin-right, margin-bottom, and margin-left to set a margin on respective sides.

*Example:*
```
p {
    margin-left: 10px;
    margin-right: 30px;
}
h1{
    margin: 25px 50px;
}
```

### CSS Display Property

The display property controls the display behaviour of an element.  The CSS display property sets whether an element is treated as a block or inline elements and the layout used for its children, such as flow layout, flex or grid. 

There are two types of HTML elements: **inline-level elements** and **block-level elements**. The differences between these elements affect how you use the box model. 
Both Inline and block-level elements appear within the body of an HTML page. But, inline-level elements are used to create a short structure that can have data and other inline elements. Inline level elements include `<b>`, `<big>`,`< i>`, `<small>`, `<tt>`, `<abbr>`, `<acronym>`, `<code>`, `<strong>`, etc.  
Block-level elements used to create larger structures than inline elements also it starts on new lines by default whereas inline-level elements not. Block elements include `<p>`, `<h1>`, `<h2>`, `<h3>`, `<h4>`, `<h5>`,`<h6>`, `<ol>`, `<ul>`, `<pre>`, `<address>`, `<blockquote>`, `<dl>`, `<div>`, `<fieldset>`, `<form>`, `<hr>`, `<table>`, etc .

The Syntax for the display property is `selector {display: value}`. The property values and description with examples are tabulated below:

|Property value | Description | Example|
|------|-----|----|
| block | behaves likes block-level elements| `a {display: block;} `|
| inline| behaves like inline-level elements | ` ul li { display: inline; }`|
|none | elements doesn't generate boxes | ` h1 { display: none;}`|

### CSS Position Property

The position property defines how an element will be arranged on a page. The Syntax for the position property is `selector {position: value}`. The property values are static, relative, absolute, fixed, or inherit.

static - The element's box is arranged automatically consistent with the normal flow.

relative - The element's box position is relative to its normal flow position. You can adjust the normal flow position by using the top, bottom, left and right properties.

absolute - The element's box arranged to an absolute position with reference to its containing block. Its containing block is that the nearest ancestor element that has its position property set to relative, absolute, or fixed. The top, right, bottom, and left properties are used to set the offset of the element's box with reference to its containing block.

fixed - The element's box position is offset from its browser window by using the top, right, bottom, and left properties. The element's box won't move when the browser window is scrolled.

inherit - The inherit keyword is employed to specify that the value for this property should be taken from the parent element. If inherit is used with the root element, then the initial value for this property is going to be used.

*Example:*
```
a {position: static;}
div {position: relative; top: 20px; left: 50px;}
h1 {position: absolute; top: 30px; left: 20px;}
div {position: fixed; top: 325px; left: 60px;}
```
### CSS Color property
	
The color property is used to specify the foreground color of text.The color properties are set using 5 different color notation types which is listed below:

```
a {color: red;}
div {color: #3c5;}
h1 {color: #ffa500;}
div {color: rgb(100,20,255);}
#id1 {color: rgb(30%,50%,70%);} 
```
 ### CSS text-align property

The text-align property is used to align the content inside the element. The text inside the element can be aligned in 4 ways - left, right, center and justify. 

 *Example:* The text-align properties are set to left, right, justify, and center.
```
 div {text-align:left;}
 h1 {text-align: right;}
  p {text-align: justify;}
  div {text-align: center;}
```


# CSS Selectors

CSS selectors are used for selecting the content/text you want to style in our site. Selectors are the part of CSS ruleset. CSS selectors select the HTML elements according to its id, class, type, attribute, etc. There are several different types of selectors in CSS, some of them are listed below:

* Element Selector
* Id Selector
* Class Selector
* Universal Selector
* Attribute selectors
* Grouping Selector
* Child and descendent selectors
* General and adjacent sibling selectors
* Pseudo-element and pseudo-class selectors

## Element Selector

The element selector selects HTML elements by their name / tag name *like a, h1, div, p etc*.

*Example:* Here, we use `<p>` as an element selector. The text inside the `<p>` will be center-aligned also blue color.

```
<!DOCTYPE html>  
<html>  
<head>  
<style>  
p {  
    text-align: center;  
    color: blue;  
}   
</style>  
</head>  
<body>  
<p>This style will be applied on every paragraph.</p>  
<p> Here also</p>
</body>
</html>
```

## ID Selector

In the CSS, the ID selector is a name preceded by a hash character (“#”).  It uses the id attribute of an HTML element to match the specific HTML element. The **id** of an element should be unique within a page, so the id selector is used to select one unique element. 

*Example:* Here, we use `#para1` as an ID selector. Inside the body, we have two `<p>` elements. The CSS style rule applied to the element which has an attribute called `id`, whose value is `para1`. Therefore, `Hello World!` will be center-aligned also blue color.

```
<!DOCTYPE html>
<html>
<head>
<style>
#para1 {
  text-align: center;
  color: blue;
}
</style>
</head>
<body>

<p id="para1">Hello World!</p>
<p>This paragraph is not affected by the style.</p>

</body>
</html>
```

> *NOTE:* The id name should start with the alphabet, not with numbers. Also, the HTML element without the 'id' attribute doesn't get affected.

## Class Selector

In the CSS, the class selector is a name preceded by a period (“.”).  It uses the class attribute of an HTML element to match the specific HTML element. We can have a Class selector specific to an HTML element *like we have `p.class` in the below example*.

In the below example, we have two class selectors inside the `<style>` element. The class selector `.intro` is applied to the element which has an attribute called `class`, whose value is `intro` and the `p.intro`  class selector is applied to the `<p>` element which has an attribute called `class`, whose value is `intro`. Also, the `<p>` element without the `class` attribute doesn't get affected.

```
<!DOCTYPE html>
<html>
<head>
<style>
.intro {
  text-align: center;
  color: red;
}

p.intro {
  text-align: center;
  color: blue;
}
</style>
</head>
<body>

<h1 class="intro">Red and center-aligned heading</h1>
<p class="intro">blue and center-aligned paragraph.</p> 
<p> this will not be affected </p>
</body>
</html>
```

## Universal Selector

The universal selector denoted by an asterisk (*), matches all the elements on the page. If any other specific selector exists on the element, then the universal selector will be omitted.

In the below example, all the elements will have the style defined under `*` selector, except the element which has an attribute called `id`, whose value is `test`.
```
<!DOCTYPE html>
<html>
<head>
<style>
* {
  font-family: Arial;
  color: blue;
}
#test{
color: green;
}
</style>
</head>
<body>

<h1>Hello world!</h1>
<p>Every element on the page will be affected by the style.</p>
<p id="test">Not me!</p>
<p>And me!</p>

</body>
</html>
```
## Attribute Selector

An attribute selector selects the HTML elements that has a specific attribute or attribute with a specified value. You can create an attribute selector by having the attribute in a pair of square brackets `[attribute]`. 
The most commonly used attribute selectors are listed below:

[attribute] Selector - applies the style rule for all the element which has a specified attribute. 

[attribute="value"] Selector -  uses the `=` operator to select the element whose attribute value is exactly equal to the given value.

[attribute~="value1 value2 value3"] Selector - uses the `~=` operator to select elements that have the specified attribute with a value containing a given word, delimited by spaces.

[attribute|="value"] Selector - uses the `|=` operator to select elements that have the specified attribute with a value either equal to a given string or starting with that string followed by a hyphen (-).

[attribute^="value"] Selector -  uses the `^=` operator to select elements that have the specified attribute with a value beginning exactly with a given string. 

[attribute$="value"] Selector uses the `$=` operator to select elements that have the specified attribute with a value ending exactly with a given string. The comparison is case sensitive.

[attribute*="value"] Selector - uses the `*=` operator to select elements that have the specified attribute with a value containing a given substring.

*Example:*
```
<!DOCTYPE html>
<html>
<head>
   <title>Example of attribute selector</title>
  <style>
     [title] {
        color:green;
    }
    p[lang|=en] {
          	background: blue;
    }
     [class*="warning"] {
         color : red;
    }
}
  </style>
</head>
<body>
  <p title="heading">It is an example for CSS [attribute] Selector</p>
  <p lang="en">It is an example for  CSS [attribute|="value"] Selector</p>
  <p class="alert_warning">It is an example for CSS [attribute*="value"] Selector</p>
</body>
</html> 
```

## Grouping Selector

The CSS grouping selector is used to apply a common style for the number of elements on the page. You can group the selector using comma (,) separator.  It allows you to specify the same properties and rules for more than one element at the same time. This reduces the code and extra effort to declare common styles for each element. 

*Example:*  Here, h1 and h2 elements have a single rule, instead of having to specify it for each of them. Therefore, the text inside the `<h1>` and `<h2>` will be center aligned and red color.

```
<!DOCTYPE html>
<html>
<head>
<style>
h1, h2 {
  text-align: center;
  color: red;
}
</style>
</head>
<body>

<h1>Hello World!</h1>
<h2>Smaller heading!</h2>
<p>This is a paragraph.</p>

</body>
</html>
```
## Child  selectors

Child Selector selects all the elements that are the children of a specified element. The Syntax of Child Selector is ` element > element { property: value;} ` which selects those elements which are the children of specific parent. The left side of > is a parent element and on the right is the children element.

In the below example, Child selectors selects those `<p>` elements which are the direct children of `<div>`. 
```
<!DOCTYPE html>
<html>
<head>
<style>
div > p {
  background-color: red;
  font-family: Arial;
}
</style>
</head>
<body>

<div>
<h3>Not me!</h3>
  <p>I'll match, </p>
  <section><p> Not me! </p></section>
  <p>I'll match, </p>
</div>
<p>I'm not in a div.</p>

</body>
</html>
```

## Descendent selectors

The descendant selector selects all the elements which are a child of the element. It allows you to limit the targeted elements to the ones who are descendants of another element. The syntax is ` element element { property: value; }` you simply write the parent(s), separate with space, and then the actual element you want to target.

In the below example, we have descendant selector that applies the style for all `<p>` elements that are descendants of a `<div>` element. 
```
<!DOCTYPE html>
<html>
<head>
<style>
div p {
  background-color: red;
  font-family: Arial;
}
</style>
</head>
<body>

<div>
  <p>I'll match, </p>
  <section>
    <p> I'll match. </p>
  </section>
</div>
<p>I'm not in a div.</p>

</body>
</html>
```

## General Sibling Selector

The General Sibling selector selects all the elements which are siblings of a specifed element. The syntax is ` element ~ element { property: value; }`, which selects all the sibiling elements that are in same hierarchy level

*Example:* Here, general sibling selector selects all the `<p>` elements that are sibling to the `<div>` element will have red background color.
```
<!DOCTYPE html>
<html>
<head>
<style>
div ~ p {
  background-color: red;
  
}
</style>
</head>
<body>
<p>Not me</p>

<div>
  <p>1st Child of div element</p>
  <p>2nd Child of div element.</p>
</div>

<p>1st sibling of div element </p>
<p>2nd sibling of div element</p>

</body>
</html>
```

## Adjancent Sibiling Selector

The Adjancent Sibling selector selects the element that are the adjacent sibling of a specified element. The syntax is ` element + element { property: value; }`, which selects the second one, if it immediately follows the first one in order of appearance in an HTML page.

*Example:* Here, adjancent sibling selector selects the `<p>` element which immediately follows the `<div>` element will have red background color.

```
<!DOCTYPE html>
<html>
<head>
<style>
div + p {
  background-color: red;
  
}
</style>
</head>
<body>
<p>Not me</p>

<div>
  <p>1st Child of div element</p>
  <p>2nd Child of div element.</p>
</div>

<p>1st sibling of div element </p>
<p>2nd sibling of div element</p>

</body>
</html>
```

## Pseudo Class Selector

Pseudo Class Selector is used to specify the state of an element. It let us to apply a style to an element which are related with external factors like the history of the navigator ( like `:visited`), the status of its content (like `:checked` on certain form elements), or the position of the mouse (like `:hover`, which lets you know if the mouse is over an element or not).

The syntax for Pseudo Class Selector is `selector:pseudo-class { property: value; }` . These pseudo- classes are used with the selector to style the element on a specific state. Some of the most commonly used pseudo-classes selectors are listed below:

`:link` - Used to select only `<a>` element with href attributes and applies the style for unvisted link.
`:visited` - Used to select only `<a>` element with href attributes and applies the style for visited link. 
`:active` - selects an element which is activated by user clicks
`:hover` - selects the style when the element is in its hover state (mouse cursor rolls over the element). 
`:focus` - selects the form input element that has received focus. It is generally triggered when the user clicks or taps on an element or selects it with the keyboard's "tab" key.
`:lang` - Used to specify a language to use in a element.
`:first-child` - selects the first element among a group of sibling elements.

*Example:* Whenever mouse rolls over the `<div>` element, it changes the background color to blue.
```
<style>
div:hover {
  background-color: blue;
}
</style>
</head>
<body>
<div>Mouse Over Me</div>
</body>
```

## Pseudo Element Selector

Pseudo-elements allows to style the specified parts of an element that is not available under DOM tree.
It let us to apply to style the first letter or first line of an element's content, change the font of the first line of a paragraph, etc.

The syntax for Pseudo Element Selector is `selector::pseudo-element { property:value; }`. Some of the most commonly used pseudo-element selectors are listed below:

`::first-letter` - Selects the first letter of the text contents inside an element.
`::first-line` - Selects the first line of the text contents inside an element.
`::before` - Used to insert generated content immediately before an element.
`::after` - Used to insert generated content either before or after an element on the page generate content immediately after an element.

*Example:* The first letter of the text contents inside `<p>` element will be capitalized and blue color. Also the content will be inserted before and after the `<div>` element.

```
<!DOCTYPE html>
<html>
<head>
<style>
div::before{
content: "Content inserted before.";
color: red;
} 
p::first-letter {
  color: blue;
  text-transform: uppercase;
}
div::after{
content: "Content inserted after.";
color: blue;
}

</style>
</head>
<body>
<div>
<p>this is a paragraph.</p>
</div>
</body>
</html>
```

## Specificity in CSS

When we have more than one CSS style rule for an element, the browser selects one style rule for that element based upon a specificity as a score/rank/priority. Specificity only applies when the same element is targeted by multiple CSS declarations.  Specificity is the set of the rules applied to CSS selectors to determine which style is applied to an element. More specific selector will have higher Precedence. The specificity level of a selector has 4 categories listed below:

1. Inline CSS - Example: `<h1 style="color: #ffffff;">`
2. ID Selector 
3. Class Attribute and Pseudo-Classes Selectors.
4. Element and Pseudo-Elements Selector.

Inline CSS have higher priorty and Element and Pseudo-Elements Selector have lowest priorty.  When we have 2 CSS Style rule which has same priority, then the lower priorty will be selected by the browser.

             
             
# CSS3

CSS3 is the latest version of CSS. CSS3 supports responsive web design, all kinds of transitions, transformations, and animations and provides box-sizing tools that enable the user to adjust the size of any element without changing the dimensions or padding of the element.

## Responsive Web design

Responsive Web design is the approach that allows websites and pages to render (or display) on all devices and screen sizes by automatically adapting to the screen, whether it’s a desktop, laptop, tablet, or smartphone. Responsive web design works through CSS, using various settings to serve different style properties depending on the screen size, orientation, resolution, color capability, and other characteristics of the user’s device. It is a combination of flexible grids, flex boxes, flexible images, and media queries. The following image shows the responsive web design in different devices.


![](./images/RWD.png)


## Media Queries

Media queries allow you to customize the presentation of your web pages for a specific range of devices like mobile phones, tablets, desktops, etc. without any change in markups. It composed of a media type and expressions that check for the conditions of particular media features. It is a logical expression that is either true or false. 

**Syntax:**   A media query consists of an optional **media type** and any number of **media feature** expressions. Multiple queries are often combined in various ways by using **logical operators**. Media queries are case-insensitive. A media query is true if the media sort of the media query matches the media sort of the device and every one expression within the media query are true. It uses the `@media` rule to incorporate a block of CSS properties as long as a particular condition is true. Queries involving unknown media types are always false.

```
@media not|only mediatype and (mediafeature and|or|not mediafeature) {
  CSS-Code;
}
```
Media Types -  It describes the category of a device.
  * `all` - used for all media type devices 
  * `print`	- used for printers
  * `screen` - 	used primarily for screens like computer screens, tablets, smart-phones, etc.
  * `speech` - 	used for screenreaders that "reads" the page aloud

Media features - It describe specific characteristics of the user agent, output device, or environment. Some of the media features are `grid`, `height`, `width`, `hover`, `max-aspect-ratio`, `max-color`,`max-color-index`, `max-height`,etc.

Logical Operators  - It used to compose a media query . Logical Operators used in media queries are `not`, `and`, and `only`.
  
*Example:* It changes the background color of the `<body>` element to "red" and the font style to "Arial" when the browser window is 600px wide or less.
```
@media only screen and (max-width: 600px) {
  body {
    background-color: red;
    font-family: Arial;
  }
}
```
## Flex boxes

The Flexible Box Module, also known as flexbox, is a one-dimensional layout method for arranging elements in rows or columns. We can design a flexible responsive layout structure without using float or positioning easily using CSS Flex boxes.  

### Flex Container and Flex items

In any flexbox layout, the first step is to create a flex container. The flex container is an area of document laid out using flexbox.  We can define the flex container by setting the `display` property to `flex` or `inline-flex`. The parent element that has `display: flex`  property set on it is called the flex container. The items being represented as flexible boxes inside the flex container are called flex items. The direct children of the flex container called flex items. 

Example for creating a Flex Container:
```
.flex-container {
  display: flex;
}
```

### Properties of the flex container

**Flex direction property** - It used to change the direction of the flex items display. The `flex-direction` property can have the following values:
* `row` (default):  arranges the flex items from left to right (horizontally)
* `column`: arranges the flex items from top to bottom (vertically)
* `row-reverse`: arranges the flex items from  right to left.
* `column-reverse`: arranges the flex items from bottom to top.

**Flex Wrap property**- It is used to defines the flex items that should wrap or not. The `flex-wrap` property can have the following values:
* `nowrap` (default): makes flex items wrap on a single line.
* `wrap`:  makes flex items wrap to multiple lines according to flex item width.
* `wrap-reverse`:  similar to wrap property but it follows the reverse flow of the flex items.

**Flex-flow Property** - It is used as a shorthand property for setting both the flex-direction and flex-wrap properties. An example of `flex-flow` property value is `row wrap` which wraps and arranges the flex items horizontally.

**justify-content Property** - It is used to align the flex items within the container. The `justify-content property` can have the following values:
* `flex-start` -  used to align the flex items at the beginning of the container.
* `flex-end`  - used to align the flex items at the end of the container.
* `center`  -  used to align the flex items at the center of the container.
* `space-around` -  used to align the flex items in such a way each has an equal amount of space around them.

**align-items Property** - It is used to align the flex items vertically. The `align-items` property can have the following values:
* `center` - flex items are aligned at the center  of the container.
* `flex-start` - aligns the flex items at the top of the container.
* `flex-end `- aligns the flex items at the bottom of the container.
* `stretch` (default) - stretches the flex items to fill the container.
* `baseline`-  the flex items are aligned with baseline.

### Properties of the flex items

 * `order`- used to define the order of the flex items.
*  `flex-grow` - used to define the amount that a flex item can grow relative to the remaining items.
*  `flex-shrink` - used to define the amount that a flex item can shrink relative to the remaining items.
*  `flex-basis` - used to define the initial length of an item.
* `flex property` - it is a shorthand property for the flex-grow, flex-shrink, and flex-basis properties. 
* `align-self`- used to define the alignment for a specific flex item which can override the default alignment.

## Import fonts via @font-face

The @font-face CSS at-rule allows you to define and use your custom fonts, thus allowing you to extend the limited set of standard system fonts that are installed by default on a computer, and that browsers can access and use. The syntax for @font-face rule is `@font-face {   property:value }`.The property inside the @fontface describes the font face’s font-family, font-variant, font-weight, font-stretch, font-style, source (src, which indicates the source of the font face that you’re fetching into the page), and Unicode range.

*Example:* The font-family property specifies the font family name that you will be able to use throughout the document. The src property provides the source of the font URL to the browser to fetch the font. The font-style and font-weight property used to change the style and weight of the font.

```
@font-face {
  font-family: 'Graublau Web';
  font-style: normal;
  font-weight: 400;	
  src:  url('GraublauWeb.eot?') format('eot'), 
        url('GraublauWeb.woff') format('woff'), 
        url('GraublauWeb.ttf') format('truetype');
}
```

           
## CSS animations using @keyframes

The CSS animation  is used for creating animations in our site.The main component of CSS animations is @keyframes, the CSS rule where animation is created. Inside @keyframes, you can define these stages, each having a different style declaration.
            
In the below example, we set the animation stages using @keyframes properties. Here we have 2 stages 0%-100%, from (equal to 0%) and to (equal to 100%). Also, we can mention the CSS styles applied for each stage.
```
@keyframes Fadeout {
  0% {
    opacity: 1;
  }
  100% {
    opacity: 0;
  }
```
The animation property is used to call `@keyframes` inside a CSS selector. Animation can have multiple properties such as `animation-name`, `animation-duration`,`animation-timing-function` ( linear | ease | ease-in | ease-out | ease-in-out | cubic-bezier ), `animation-delay`, and `animation-iteration-count`, `animation-direction`, and `animation-fill-mode`( none | forwards | backwards | both ).


## CSS tranisition

CSS transitions let you define the changes for HTML elements, the specific time intervals, the speed of the acceleration curve and much more. The transition-property specifies the CSS properties to which you want the transition effect. Only these CSS properties are animated.

Syntax: `transition: <property> <duration> <timing-function> <delay>;`

The below code defines a transition effect of the width property for a duration of five seconds. When you hover your cursor over the blue box, the blue box increases its width gradually for a time duration of five seconds. 
```
<!DOCTYPE html>
<html>
<head>
<style>
div{
width: 100px;
height: 100px;
background: blue;
transition: width 5s;
}
div:hover {
width: 600px;
}
</style>
</head>
<body>
<div></div>
<p>Move the cursor over the div element above, to see the transition effect.</p>
</body>
</html>
```






