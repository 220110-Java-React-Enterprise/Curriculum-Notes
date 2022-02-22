## Immutability

State is defined either by declaring a property of this.state (class components) or by defining state using a lifecycle hook (function components).

In either case, you should never be mutating state directly. This value, while able to be changed, should only ever be done so by the appropriate mutator.

#### How to Mutate State

_Class Based Components_

```javascript
import React from "react";

class TodoList extends React.Component {
  state = {
    items: [
      /*some items*/
    ],
  };

  count = 0;

  addItem = () => {
    this.setState({
      items: [...this.state.items, { id: ++this.count, value: "new item" }],
    }); /* new item here is arbitrary*/
  };

  render() {
    return (
      <div>
        <button onClick={this.addItem}>Add Item</button>
        <ul>
          {this.state.items.map((item) => (
            <li key={item.id}>{item.value}</li>
          ))}
        </ul>
      </div>
    );
  }
}

export default TodoList;
```

_Function Based Components_

```javascript
import React, { useState } from "react";

const TodoList = () => {
  let [items, setItems] = useState([
    /*some items*/
  ]);

  let count = 0;

  const addItem = () => {
    setItems([
      ...items,
      { id: ++count, value: "new item" },
    ]); /* new item here is arbitrary*/
  };

  return (
    <div>
      <button onClick={addItem}>Add Item</button>
      <ul>
        {items.map((item) => (
          <li key={item.id}>{item.value}</li>
        ))}
      </ul>
    </div>
  );
};

export default TodoList;
```

#### How NOT to Mutate State

_Class Based Components_

```javascript
import React from "react";

class TodoList extends React.Component {
  state = {
    items: [
      /*some items*/
    ],
  };

  count = 0;

  addItem = () => {
    this.state.items.push({ id: ++this.count, value: "new item" });
    this.setState(items); /* new item here is arbitrary*/
  };

  render() {
    return (
      <div>
        <button onClick={this.addItem}>Add Item</button>
        <ul>
          {this.state.items.map((item) => (
            <li key={item.id}>{item.value}</li>
          ))}
        </ul>
      </div>
    );
  }
}

export default TodoList;
```

_Function Based Components_

```javascript
import React, { useState } from "react";

const TodoList = () => {
  let [items, setItems] = useState([
    /*some items*/
  ]);

  let count = 0;

  const addItem = () => {
    items.push({ id: ++count, value: "new item" });
    setItems(items); /* new item here is arbitrary*/
  };

  return (
    <div>
      <button onClick={addItem}>Add Item</button>
      <ul>
        {items.map((item) => (
          <li key={item.id}>{item.value}</li>
        ))}
      </ul>
    </div>
  );
};

export default TodoList;
```

### Why not just change state directly?

In some examples, mutating state directly may appear to function just fine. However, mutating state directly can lead to components which are buggy or difficult to optimize. For example, you make your component more efficient by making it pure, which means it will only re-render when its props change. But say, for instance, you add or remove elements from an array stored in the component's state. The array itself will not be seen as changed so the component will not re-render. This update will not be reflected in the view.

Immutability also allows for changes to more easily be detected, because a reference comparison is a lot more efficient than a value comparison. No traversing objects needs to be done to detect a change. Complex features to become much easier to implement because of immutability as well.
