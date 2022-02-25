function FunctionComponent(props) {

    console.log("FunctionalComponent: ", props);

    return(
        <>
            <h1>This is a functional component!</h1>
            <p>This is a paragraph in the functional component.</p>
            <p>Welcome, {props.name}</p>
        </>
    );
}

export default FunctionComponent;