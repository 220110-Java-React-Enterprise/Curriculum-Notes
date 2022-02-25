import { useEffect, useState } from "react";
import store from "../store/store";


function ViewJob(props) {
    let [data, setData] = useState({job: "job", description: "description"});
    //let [storeState, setStoreState] = useState({job: "job", description: "desc"});

    let isMounted;
    useEffect(() => {
        isMounted = true;


        return () => {
            isMounted = false;
        }
    });


    let unsubscribe = store.subscribe(() => {
        console.log("ViewJob state updating... ", store.getState());
        //setData(store.getState())
        let state = store.getState();
        a = state.job;
        b = state.description;
        
    });

    return(
        <>
            <h1>{a}</h1>
            <hr />
            <h4>{b}</h4>

        </>
    );
}

export default ViewJob;