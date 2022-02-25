import React, { useState } from "react";
import store from "../store/store";

export default function Celsius(props) {
    const handleChange = (event) => {
        store.dispatch({type: "UPDATE_CELSIUS", payload: event.target.value});
    }

    return (
        <>
            <h1>Celsius Temp: {props.temp.celsius}</h1>
            New Celsius Tempreture:
            <input type="text" onChange={handleChange} />
        </>
    );


}