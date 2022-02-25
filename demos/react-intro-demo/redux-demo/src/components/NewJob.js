import store from "../store/store";
import { useState } from "react";

function NewJob(props) {
    let [job, setJob] = useState("Job");
    let [desc, setDesc] = useState("Job Description");

    function changeJobText(e) {
        setJob(e.target.value);
    }

    function changeDescText(e) {
        setDesc(e.target.value);
    }


    function submitJob(e) {
        store.dispatch({type: "UPDATE_JOB", payload: job});
    }

    function submitDesc(e) {
        store.dispatch({type: "UPDATE_DESCRIPTION", payload: desc});
    }


    return(
        <>
            <h2>Enter a new job:</h2>
            Job: <input type="text" onChange={changeJobText}></input>
            <button onClick={submitJob}>Submit Job</button>
            <br />
            Description: <input type="text" onChange={changeDescText}></input>
            <button onClick={submitDesc}>Submit Description</button>
        </>
    );
}

export default NewJob;