
import React from "react";
//import Login from '../components/pages/login/Login'
import { BrowserRouter } from "react-router-dom";
import RootRouter from "./RootRouter";

function App() {
  return (
    <BrowserRouter>  
        <RootRouter />         
    </BrowserRouter>
  );
}

export default App;

