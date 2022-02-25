const initialState = {
    cTemp: 0.0,
    fTemp: 0.0,
    updated: "NONE"
}

export default function tempReducer(state = initialState, action) {
    console.log("Reducer invoked: ", action)
    switch(action.type) {
        case 'UPDATE_FARENHEIT': {
            return {
                ...state,
                fTemp: action.payload,
                updated: action.type
            }
        }

        case 'UPDATE_CELSIUS': {
            return {
                ...state,
                cTemp: action.payload,
                updated: action.type
            }
        }

        default:
            return state;
    }

}