import { Link } from "react-router-dom";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import ButtonComponent from "./ButtonComponent";
import ClassComponent from "./ClassComponent";
import FunctionComponent from "./FunctionalComponent";


function NavBar(props) {
    return (
        <>
            <Link to="/class">Class Component!</Link> |
            <Link to="/function">Functional Component!</Link>

            <Router>

                <Switch>
                    <Route path="/class" exact>
                        <ClassComponent />
                    </Route>

                    <Route path="/function" exact>
                        <FunctionComponent />
                    </Route>
                </Switch>
            </Router>

            <ButtonComponent />
        </>
    );
}

export default NavBar;