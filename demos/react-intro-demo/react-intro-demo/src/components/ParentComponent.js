import FunctionalComponent from "./FunctionalComponent";
import ClassComponent from "./ClassComponent";
import ButtonComponent from "./ButtonComponent";
import { useState } from "react";

function ParentComponent(props) {
    let [name, setName] = useState("Kyle");


    return (
        <>
            <h1>This is the parent component!</h1>
            <hr />
            <FunctionalComponent name={name} setName={setName} />
            <hr />
            <ClassComponent name={name} setName={setName} />
            <hr />
            <ButtonComponent name={name} setName={setName} />
            <hr />
        </>
    );
}

export default ParentComponent;