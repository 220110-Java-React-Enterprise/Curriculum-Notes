import CelciusComponent from "./CelciusComponent";
import FahrenheitComponent from "./FerenheitComponent";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import HomeComponent from "./HomeComponent";
import NotFoundComponent from "./NotFoundComponent";
import { useState } from "react";


function NavBar(props) {
    let [celsius, setCelsius] = useState(0);
    let [fahrenheit, setFahrenheit] = useState(0);

    function convertFtoC(tempreture) {
        setFahrenheit(tempreture);
        let newTempreture = (tempreture - 32) * (5 / 9);
        setCelsius(newTempreture)
    }

    function convertCtoF(tempreture) {
        setCelsius(tempreture);
        let newTempreture = (tempreture * (9 / 5)) + 32;
        setFahrenheit(newTempreture);
    }

    return (
        <>
            <h3>NavBar Component!</h3>
            <Router>
                [  <Link to="/celsius">Celsius</Link>  |
                <Link to="/fahrenheit">Fahrenheit</Link>  |
                <Link to="/brokenlink">Broken Link!</Link>  ]
                <Routes>
                    <Route exact path="/" element={<HomeComponent />} />
                    <Route exact path="/celsius"
                        element={<CelciusComponent tempreture={celsius} liftTempreture={convertCtoF} />} />
                    <Route exact path="/fahrenheit"
                        element={<FahrenheitComponent tempreture={fahrenheit} liftTempreture={convertFtoC} />} />
                    <Route element={NotFoundComponent} />
                </Routes>
            </Router>
        </>
    );
}

export default NavBar;