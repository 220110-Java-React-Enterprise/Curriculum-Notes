import { useEffect, useState } from "react";

function ButtonComponent(props) {
    let [localName, setLocalName] = useState(props.name);

    useEffect(() => {
        console.log("Effect: (happens at first render and all subsequent renders) ", localName);

        return () => {
            console.log("Cleanup/Teardown: ", localName);
        }
    });


    console.log("ButtonComponent: ", props);

    function inputText(e) {
        console.log("Event: ", e.target.value);
        setLocalName(e.target.value);
        console.log("Local state: ", localName);
    }

    function buttonClick(e) {
        console.log("buttonClick: ", e.target.value);
        props.setName(localName);
    }

    return(
        <>
            <h3>This is the button component!</h3>
            <input type="text" onChange={inputText} ></input>
            <button type="button" onClick={buttonClick}>Button!</button>
        </>
    );
}

export default ButtonComponent;