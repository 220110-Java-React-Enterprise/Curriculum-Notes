import Celsius from "./celsius";
import { useState } from "react";
import store from "../store/store";

export default function Farenheit(props) {
    const handleChange = (event) => {
        store.dispatch({type: "UPDATE_FARENHEIT", payload: event.target.value});
    }

    return (
        <>
            <h1>Farenheit Temp: {props.temp.farenheit}</h1>
            New Farenheit Tempreture:
            <input type="text" onChange={handleChange} />
        </>
    )}