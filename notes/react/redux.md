# Redux Primer
Redux is a library designed to better manage state in React. It can actually be used with libraries other than React. In order to better manage state throughout a React app, you use a store to hold one or more "slices" (slices are just separate state data split into smaller units). We use reducers to mutate state, we dispatch actions (state data payloads) to the reducers, and we subscribe to the store to get the up-to-date state. Redux follows a fairly simple paradigm, but seems more daunting than it actually is.

![redux workflow](https://raw.githubusercontent.com/LiquidPlummer/ReactCrashCourseLessonPlan/main/images/redux-flow.png)


## State
In React each component manages it's own internal state. This will still be the case with Redux, but now we will have a global state held in one or more stores, each with one or more slices. We can access these stores and grab slices of state from within our React components. It is not necessary to move all state into the Redux stores, it is best practice only to store what is needed outside the current component.  
  
State data in Redux is always plain JS objects and arrays. This means Redux state cannot contain functions, class instances, or JS types like Map, Set, and Date.
  
## Slices
Slices are just separate units of state in a store. When you put all the slices together you have the whole state held in a store. You define the state store by defining a reducer, and you split into slices by separating out your reducers. Redux documentation suggests this is done by features, code that is related to a specific concept or functionality in your application. A state store will require one single root reducer in order to be created, so the separated reducers which represent slices of state, are combined with the combineReducers() method.  
  
## Actions
An action is sort of like an event. Actions are what we dispatch to reducers to describe how the state is changing. Actions must have a `type` field. It is also usually necessary to send information about how the state will change, and this is typically sent in the `payload` field.  
  
## Reducers
Reducers take in state and action, then typically merge the action payload into state, creating a new state. The name comes from the concept of taking the existing state, plus changes to that state and merging them back into a new state. You also describe part of the overall state/slices when defining your reducers. A reducer is typically made up of a switch statement that filters different action types to different blocks of logic to alter state.
  
Make sure to keep in mind, state is immutable. You don't alter the existing state, you take the old state and merge in the payload, creating a new state. This is called reduction.  
  
Reducers are also typically provided with initial state. This can be helpful to define the state that will be stored, as well as keep default values.  
  
## Dispatching
In order to send updates to the store, you dispatch actions. You do so by calling the store's dispatch() method, with your action as a parameter. Remember, an action is just an object with a `type` field denoting what action it is, in order to be sent to the correct reducer logic. Actions typically also contain data used to alter the state, and this is often included in another field called `payload`.  
  
## Store
The store is where Redux keeps state data, outside of the components. From here it is accessable by subscribing. The store.subscribe() method takes an arrow function as a parameter, and returns a function that can be used to unsubscribe. The arrow function given is a callback function which is invoked whenever the store updates. Think of it like a subscription, hence the name. Once you subscribe each change will hook into your component with the callback function. This continues until you use the provided unsubscribe function. This is probably the most confusing part of the Redux workflow. See it in action below:


## Simple Redux Usage
Create a reducer in it's own js file. This will define the reducer's logic, initial state, and be used to create the store.
```javascript
//reducer.js
const initialState = {
  name: 'default',
  message: 'default message'
}

export default function appReducer(state = initialState, action) {
  switch (action.type) {
    case 'changeName': {
      return {
        ...state,
        name: action.payload
      }
    }
    case 'changeMessage': {
      return {
        ...state,
        message: action.payload
      }
    }
    default:
      return state
  }
}

```
  
  
Use one or more reduces to create a store. In this step you would combine sliced reducers into a single root reducer with combineReducers();
```javascript
//store.js
import { createStore } from "redux";
import appReducer from "./reducer";

const store = createStore(appReducer);

export default store;
```
  
  
Now you can subscribe to your store in any component that might need to see a change in data. Note how the subscribe() method is used. It is given an arrow function which contains logic to be invoked whenever the store updates, and it returns another function that can be used to unsubscribe when you no longer want to receive store updates.
```javascript
//dispatch-component.js
import store from "./store";

//the unsubscribe variable is assigned with the return value from subscribe() which is a funciton that can be used to unsubscribe.
const unsubscribe = store.subscribe(() => {
            //this function is invoked whenever the store is updated.
            console.log('New state: ', store.getState());
        })
```


