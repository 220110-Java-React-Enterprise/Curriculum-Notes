import { useState } from "react";

function CelsiusComponent(props) {
    let [tempreture, setTempreture] = useState(props.tempreture);

    function changeTempreture(e) {
        setTempreture(e.target.value)
    }

    function submitTempreture(e) {
        props.liftTempreture(tempreture);
    }

    return(
        <>
            <h3>Celsius tempreture: {tempreture}</h3>
            <input type="text" onChange={changeTempreture} />
            <button onClick={submitTempreture} >Submit!</button>
        </>
    );
}

export default CelsiusComponent;