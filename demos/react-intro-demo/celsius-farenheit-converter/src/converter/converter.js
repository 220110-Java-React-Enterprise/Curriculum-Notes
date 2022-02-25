import Celsius from "./celsius";
import Farenheit from "./farenheit";
import { useState, useEffect } from "react";
import store from "../store/store";


export default function Converter() {
    const [temp, setTemp] = useState({farenheit: 0.0, celsius: 0.0});

    const unsubscribe = store.subscribe(() => {
        if(store.getState().updated == "UPDATE_FARENHEIT") {
            //Convert F to C and update C
            setTemp({farenheit: temp.farenheit, celsius: (store.getState().fTemp-32)*(5/9)});
        }

        if(store.getState().updated == "UPDATE_CELSIUS") {
            //Convert C to F and update F
            setTemp({farenheit: store.getState().cTemp * (9/5) + 32, celsius: temp.celsius});
        }
    })

    return (
        <>
            <Celsius temp={temp} />
            <hr />
            <Farenheit temp={temp}/>
        </>
    )
}