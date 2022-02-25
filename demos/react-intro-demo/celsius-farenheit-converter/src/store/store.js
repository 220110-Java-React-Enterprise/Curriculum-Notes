import { createStore } from "redux";
import tempReducer from "./reducer";



const store = createStore(tempReducer);

export default store;