# Lists and Keys

A key is a specific attribute that react uses while rendering collection of elements. Keys help React identify which items have been changed, added, or removed, playing a significant part in the [DOM reconciliation process](https://reactjs.org/docs/reconciliation.html#recursing-on-children). Keys must be unique among sibling elements, but need not be globally unique. A unique ID associated with the element is the best choice to act as its key. If a unique key is not available, you may be able to add a new ID property to your model or hash some parts of the content to generate a key. Only if there is no better option should an index be used, and is an especially bad choice if you expect data to be reordered.

```javascript
import React from "react";

const GroceryList = () => {
  const items = ["Apples", "Bananas", "Milk"];
  return (
    <ul>
      {items.map((item) => (
        <li>{item}</li>
      ))}
    </ul>
  );
};
```
