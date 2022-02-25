const initialState = {
    job: "",
    description: ""
}

function reducer(state = initialState, action) {
    console.log("Reducer invoked: ", action);

    switch(action.type) {
        case "UPDATE_JOB": {
            return {
                ...state,
                job: action.payload
            }

        }

        case "UPDATE_DESCRIPTION": {
            return {
                ...state,
                description: action.payload
            }
        }

        default:
            return state;
    }
}

export default reducer;