import React from "react";

class ClassComponent extends React.Component {
    constructor(props) {
        super(props);
    }
    

    render() {
        console.log("ClassComponent: ", this.props);

        return(
            <>
                <h1>Class Component!</h1>
                <p>This is a paragraph in a class component</p>
                <p>Welcome, {this.props.name}</p>
            </>
        );
    }
}

export default ClassComponent;