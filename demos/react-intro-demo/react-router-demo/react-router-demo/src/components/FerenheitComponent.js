import { useState } from "react";

function FahrenheitComponent(props) {
    let [tempreture, setTempreture] = useState(props.tempreture);

    function changeTempreture(e) {
        setTempreture(e.target.value);
    }

    function submitTempreture(e) {
        props.liftTempreture(tempreture);
    }


    return(
        <>
            <h3>Fahrenheit tempreture: {tempreture}</h3>
            <input type="text" onChange={changeTempreture} />
            <button onClick={submitTempreture} >Submit!</button>
        </>
    );
}

export default FahrenheitComponent;