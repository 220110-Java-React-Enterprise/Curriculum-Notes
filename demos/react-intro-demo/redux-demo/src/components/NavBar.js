import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import HomeComponent from "./HomeComponent";
import NewJob from "./NewJob";
import ViewJob from "./ViewJob";



function NavBar(props) {
    

    return (
        <>
            <h3>NavBar Component!</h3>
            <Router>
                [  <Link to="/viewjob">View Job</Link>  |
                <Link to="/newjob">New Job</Link>  ]
                <Routes>
                    <Route exact path="/" element={<HomeComponent />} />
                    <Route exact path="/newjob"
                        element={<NewJob />} />
                    <Route exact path="/viewjob"
                        element={<ViewJob />} />
                </Routes>
            </Router>
        </>
    );
}

export default NavBar;